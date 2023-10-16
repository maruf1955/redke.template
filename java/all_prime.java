import java.util.Scanner;
public class all_prime{
    public static void main(String[] args){
        Scanner input= new Scanner(System.in);
        System.out.print("Enter the number for start: ");
        int start= input.nextInt();
        System.out.print("Enter the end number: ");
        int end = input.nextInt();
        int count= 0;
        for (int i= start; i<=end; i++)
        { for (int j=2; j<=i-1 ; j++)
            { if (i%j==0)
                {
                    count++;
                    break;
                }

            }
            if (count==0){
            System.out.println(i);
            count=0;
            }
            
        }
        
        


    }
}