#include <stdlib.h>
#include <unistd.h>
#include <sys/stat.h>
#include <dirent.h>
#include <assert.h>
#include <limits.h>
#include <stdio.h>
#include <string.h>
#include <sys/types.h>
#include <errno.h>

int valid_sub(char* dir){
		if ( !strcmp(dir,"..") || !strcmp(dir,".") ) {
			return 1;
		}
		return 0;
} 


char* my_readlink(const char *pathname){
  ssize_t n;
  char * buf = malloc(1024 * sizeof(char));

 if ( (n = readlink(pathname, buf,sizeof(buf))) < 0) {
           
            printf("Error %d :\n",errno);
            switch(errno){
              case EACCES : 
                printf("Search permission is denied for a component of the path prefix : %s\n.",pathname);
              break;
              case ELOOP : 
                printf("Too many symbolic links were encountered in translating the pathname %s.\n",pathname);
              break;
              case ENAMETOOLONG : 
                printf("A pathname, or a component of a pathname, was too long. The pathname in question is %s\n",pathname);
              break;
              case ENOENT : 
                printf("The named file %s does not exist.\n",pathname);
              break;
              case ENOTDIR : 
                printf("A component of the path prefix %s is not a directory.\n",pathname);
              break;
              case EFAULT:
                printf("buf extends outside the process's allocated address space.\n");
              break;
              case EINVAL : 
              printf("The named file %s is not a symbolic link or bufsiz is not positive..\n",pathname);
              break;
              case EIO :
                printf("An I/O error occurred while reading from the filesystem.\n");
              break;
              case ENOMEM : 
                printf("Insufficient kernel memory was available.\n");
              break;
              default :
                printf("The error number does not exist, there is no description for the error.\n");
              break;
            }
  }
  else {
    buf[n] = '\0';
  }
  return buf;
}

int mdu(const char *pathname, int mode, int link){

	struct stat st;
	struct dirent *subdir;
	char subdir_pathname[PATH_MAX+1]; 
  char *pathname_link;
  DIR *dir;
  DIR *dir2;
	int status;
	int size=-1;

	if ( (status = lstat(pathname,&st)) < 0) {
		printf("Error %d :\n",errno);
            switch(errno){
              case EACCES : 
                printf("Search permission is denied for a component of the path prefix : \"%s\"\n.",pathname);
              break;
              case ELOOP : 
                printf("Too many symbolic links were encountered in translating the pathname \"%s\".\n",pathname);
              break;
              case ENAMETOOLONG : 
                printf("A pathname, or a component of a pathname, was too long. The pathname in question is \"%s\"\n",pathname);
              break;
              case ENOENT : 
                printf("The named file \"%s\" does not exist.\n",pathname);
              break;
              case ENOTDIR : 
                printf("A component of the path prefix \"%s\" is not a directory.\n",pathname);
              break;
              case EFAULT:
                printf("Bad adress.\n");
              break;
              case EBADF  : 
              	printf("fd is bad.\n");
              break;
              case ENOMEM : 
                printf("Out of memory.\n");
              break;
              case EOVERFLOW : 
                printf("Can't represent stat of the file \"%s\"\n",pathname);
              break;
              default :
                printf("The error number does not exist, there is no description for the error.\n");
              break;
            }
            exit(EXIT_FAILURE);
	}
	else {
		switch(mode){
			case 0:
        	size = (st.st_blocks)/2;
			break;
			case 1:
					size = st.st_size;
			break;
			case 2:
          size = st.st_blocks;
			break;
			default:
					exit(EXIT_FAILURE);
			break;
		}

  if(S_ISLNK(st.st_mode) && link == 1) {
			pathname_link = my_readlink(pathname);
			return mdu(pathname_link,mode,0);
		}
		else if (S_ISDIR(st.st_mode)) {
    		dir = opendir(pathname);
				assert(dir); 
			while ( (subdir=readdir(dir))!=NULL)  {
				if (!valid_sub(subdir->d_name)) {
					snprintf(subdir_pathname, PATH_MAX,"%s/%s",pathname,subdir->d_name);
            if ( (dir2 = opendir(subdir_pathname)) != NULL){
              printf("%d\t%s\n",mdu(subdir_pathname,mode,0),subdir_pathname);
					     }
          size+=mdu(subdir_pathname,mode,0); 
				}
			}
      closedir(dir);
		}
	}
		return size;
}

int main(int argc, char *argv[]) {

	int c;
	int mode = 0;
	int link = 0;

	char *pathname = argv[argc-1];

	while ( (c = getopt(argc,argv,"bLB:")) != -1 ) {
			switch(c) {
				case 'b' :
					mode = 1;
				break;

				case 'B':
					mode = 2;
				break;

				case 'L':
					link = 1;
				break;
			}
		}
		printf("%d\t%s\n",mdu(pathname,mode,link),pathname);
		return 0;
}
