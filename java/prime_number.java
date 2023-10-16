import java.util.Scanner;
public class prime_number{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number for check prime or not: ");
        int n = input.nextInt();
        if (n==0 || n==1){
            System.out.println("Number is not prime");
        }
        else{
            for (int i = 2; i < n ; i++){
            if(n%i==0){
                System.out.print("Number is not prime..");
                break;
            }
            else{
                System.out.print("Number is prime...");
                break;
            }
        }
        

        }
    }
}