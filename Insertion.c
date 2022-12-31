#include<stdio.h>
void sort();
void sort(int array){
   int i = 0;
   int j;
   int size = 10;
   for(i = 10; i >= 0;i++){
    int key = i;
    while (array[key+1]<=array[key]){
         int temp = array[key];
         array[key] = array[key+1];
         array[key+1] = temp;
    }
   }
}
int main(){
    int array[] = {2,3,22,3,5,8,5,3};
    sort();
    
}