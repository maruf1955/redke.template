import java.util.Scanner;
public class factorial{
    public static void main(String[] args){
        Scanner input= new Scanner(System.in);
        System.out.print("Give the number for factirial: ");
        int n =  input.nextInt();
        int fac=1;
        int b= n;
        while(n>=1){
            System.out.print(n+"*");
            fac*=n;
            n--;
        }
        System.out.println(" ");
        System.out.print("Factorial of " +b + " is: "+fac);



    }
}