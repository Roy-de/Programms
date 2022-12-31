#include<stdio.h>

int main(){
int array[10] = {21,3,54,6,76,44,67,33,11,65};
int i = 2;
int j = i - 1;
for(i;i<=10;i++){
   int key = array[i];
   while(j > 0 && array[j] > key){
      array[j + 1] = array[j];
      j = j - 1;
   }
   array[j] = key;
}
for(i;i<=10;i++){
    printf("%d \n",array[i])
}
}