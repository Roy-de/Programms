import java.util.Scanner;
public class Main{
public static void main(String[] args){
Scanner sc = new Scanner(System.in);
int v_in, d_t;

System.out.println("for Two Tiles [use only 1/2]");

System.out.println("Vacuum cleaner is in tiles A=1/B=2");
v_in = sc.nextInt();

System.out.println("Tiles Dirty ?: [yes=1/no=2]");
d_t = sc.nextInt();

if(v_in==1 && d_t==1){
System.out.println("A is cleaned now");
System.out.println("Vacuum is in B tiles");

int a;
System.out.println("B tiles is dirty ?: [yes=1/no=2]");
a=sc.nextInt();
v_in=2;
if(v_in==2 && a==1){
System.out.println("B is cleaned now");
}
else if(v_in==2 && a==2){
System.out.println("B is already cleaned");
}
else{
System.out.println("Tiles error");
}
}
else if (v_in==1 && d_t==2){
System.out.println("A is cleaned");

System.out.println("Vacuum is in B tiles");

int a;
System.out.println("B Dirty ?: [yes=1/no=2]");
a = sc.nextInt();
v_in=2;
if(v_in==2 && a==1){
System.out.println("B cleaned now");
}
else if(v_in ==2 && a==2){
System.out.println("B is cleaned");
}
else{
System.out.println("Tiles error");
}
}
System.out.println("\nAll the tiles are now completely cleaned");
sc.close();
}
}