import java.util.Scanner;
public class reverse{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your digit: ");
        int n = input.nextInt();
        int temp = n;
        while (temp!=0){
            int r= temp%10;
            System.out.print(r);
            temp= temp/10;
        }
    }
}