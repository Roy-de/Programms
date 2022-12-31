#include <stdio.h>
#include <stdlib.h>


int main(){
    FILE  *f;
    char name[100];
    int y;
    f = fopen("test.txt","w+");
    if(f == NULL){
        printf("Error....no such file");
    }
    else{
        printf("Success \n");
        printf("Enter your name \n");
        fflush(stdin);
        scanf("%s",&name);
        fputs("murithi",f);
        fseek(f,1,SEEK_CUR);
        printf("%ld \n",ftell(f));
    } 
    fwrite(&name,sizeof(name),3,f);
    printf("\nname: %ds \n",name);
    fread(&name,sizeof(char),100,f);
    printf("\n File content is: %s",name);
    fclose(f);
    return 0;
}