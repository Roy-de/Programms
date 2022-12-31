class InsertionSort {
/*Function to sort array using insertion sort*/
void sort(int array[])
{
int n = array.length;
for (int i = 1; i < n; ++i) {
     int key = array[i];
     int j = i - 1;

 /* Move elements of arr[0..i-1], that are
                   greater than key, to one position ahead
                   of their current position */
       while (j >= 0 && array[j] > key) {
          array[j + 1] = array[j];
          j = j - 1;
          }
     array[j + 1] = key;
    }
 }
  
   /* A utility function to print array of size n*/
 static void printArray(int array[])
  {
 int n = array.length;
 for (int i = 0; i < n; ++i)
   System.out.print(array[i] + " ");
  
    System.out.println();
 }
 public static void main(String args[])
  {
    int k = 0;
    int array[] = new int[10];
    for(int i = array.length; i > 0; i--){
        int key = i;
      array[k] = key;
      k++;
    }
    InsertionSort ob = new InsertionSort();
    ob.sort(array);
      
    printArray(array);
 }
}