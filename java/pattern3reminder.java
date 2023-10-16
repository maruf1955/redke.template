import java.util.*;
class pattern3reminder{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of row: ");
        int n = input.nextInt();
        for (int i=1; i<=n; i++){
            for (int j=1;j<=i; j++){
                System.out.print(j%2+" ");
            }
            System.out.println();
            
        }
    }
}