import java.util.Scanner;
public class sum_of_digit{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your digit: ");
        int n = input.nextInt();
        int sum=0;
        int temp= n;
        while (temp !=0){
            int r = temp%10;
            sum+=r;
            temp=temp/10;

        }
        System.out.print("Sum of the digit is: "+sum);
    }
}