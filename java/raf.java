import java.util.Scanner;
public class raf{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your number: ");
        int m = input.nextInt();
        int sum=  Math.pow(m,2);
        System.out.print(sum);
    }
}A