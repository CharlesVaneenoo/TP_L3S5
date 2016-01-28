#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>
#include <errno.h>
#include <assert.h>
#include <string.h>   
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>


int mcat_scd(const char * pathname, int bufsize){

	int file;
	int displayLines = -1;
	char * buffer;

	buffer = malloc(bufsize+1);
	file = open(pathname,O_RDONLY);

	while (displayLines != 0){
		displayLines = read(file,buffer,bufsize);

		if (displayLines == bufsize) {
			write(STDOUT_FILENO,buffer,bufsize);
		}
		else if (displayLines < bufsize) {
			write(STDOUT_FILENO,buffer,displayLines);
			buffer[displayLines] = '\0';
		}
	}
	free(buffer);
	return 0;
}

int main(int argc, char *argv[]){

	char * pathname = argv[argc-1];
	
	mcat_scd(pathname,atoi(getenv("MCAT_BUFSIZ")));

	return 0;

}
