import java.util.Scanner;
public class Rubixcube{
    public static void main(String[] args){
        
        Scanner input = new Scanner(System.in);
        int a,b,c;
        System.out.print("Enter length of rows1: ");
        a = input.nextInt();
        System.out.print("Enter length of rows2:");
        b = input.nextInt();
        System.out.print("Enter length of rows3:");
        c= input.nextInt();
        int [][][] rubix = new int [a][b][c];
        System.out.print("Length of the rubix cube is: ");
        System.out.println(rubix.length);
        for(int i=0;i<a;i++){
            for (int j=0;j<b;j++){
                for(int k=0; k<c;k++){
                    rubix [i][j][k] = input.nextInt();
                }
            }
        }
        for(int i=0;i<a;i++){
            for (int j=0;j<b;j++){
                for(int k=0; k<c;k++){
                    System.out.print(rubix[i][j][k]);
                }
                System.out.println();
            }
        }
        

        

        
    }
}