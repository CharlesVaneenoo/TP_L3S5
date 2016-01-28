#include <limits.h>
#include <unistd.h>
#include <stdio.h>

void prlimit(void) {
	printf("NAME_MAX : %d\n",NAME_MAX);
	printf("PATH_MAX : %d\n",PATH_MAX);
}

int main(void){
	prlimit();
	return 0;
}
