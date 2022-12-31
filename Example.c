#include <stdio.h>
#include <stdlib.h>

#define PI 3.14

int calculator();
void forxexample();
//Calculator function
int calculator(radius){
    int result;
    result = PI * radius * radius;
    return result;
}
//Fork example
void forxexample(){
    int radius = rand();
    printf("Area of parent circle: %d\n",calculator(radius));
    radius = random();
    printf("Area of child circle: %d\n",calculator(radius));

}
//Main function
int main(){
    fork();
    fork();
    forxexample();
    return 0;  
}