import java.util.Scanner;
public class Armstrong{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your number: ");
        int n = input.nextInt();
        int temp = n;
        double sum= 0;
        while (temp!=0){
            int r = temp%10;
            sum=  sum+ Math.pow(r,3);
            temp= temp/10;
        }
        if (n==sum){
            System.out.print("Armstrong number");


        }
        else{
            System.out.print("Not a Armstrong number");
        }

        
    }
}