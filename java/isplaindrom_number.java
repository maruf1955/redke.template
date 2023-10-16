import java.util.Scanner;
public class isplaindrom_number{
    public static void main(String[] args){
        Scanner input= new Scanner(System.in);
        System.out.print("Enter your digit over here: ");
        int n= input.nextInt();
        int temp = n;
        int sum= 0;
        while (temp!=0){
            int r = temp%10;
            sum=sum*10+r;
            temp=temp/10;
        }
        if(sum==n){
            System.out.print("Isplaindrom...");

        }
        else{
            System.out.print("Not Isplaindrom..");
        }
    }
}