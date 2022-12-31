#include <stdio.h>

int bubblesort();

int bubblesort(){
    int array[10] = {23,45,1,776,46,22,666,13,86,44};
    int temp;
    int i;
    for (i=0;i<=10;i++){
        if(array[i]>array[i+1]){
            temp = array[i+1];
            array[i] = array[i+1];
            array[i] = temp;
            printf("Array %d \n",array[i]);
          }
        else {
            continue;
        };
        
    }
    
}

int main(){
  bubblesort();
}