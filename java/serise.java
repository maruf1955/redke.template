import java.util.Scanner;
public class serise{
    public static void main(String[] args){
        int n;
        Scanner input= new Scanner(System.in);
        System.out.print("Enter your number: ");
        n = input.nextInt();
        int i=0;
        int sum=0;
        do{
            sum+=i;
            i++;
        }while(i<=n);
        System.out.println("The sum is: "+sum);
        int odd_sum=0;
        for(int x=1; x<=n;x+=2){
            odd_sum+=x;

        }
        System.out.println("Odd sum is:"+odd_sum);
        double y=1.5;
        double sum_double=0;
        while(y<= n){
            sum_double+=y;
            y++;
            
        }
        System.out.println("double sum: "+sum_double);
        int power_sum=0;
        for(int j=0;j<=n;j++){
            power_sum+=Math.pow(j,2);
        }
        System.out.println("power_sum is: "+power_sum);
        int k=1;
        int mul=1;
        do{
            mul*=k;
            k++;
        }while(k<=n);
        System.out.println("Multiple is: "+mul);
        int odd_mul=1;
        int l=1;
        while(l<=n){
            odd_mul*=l;
            l+=2;
        }
        System.out.println("odd mul is: "+odd_mul);
        double double_mul=1;
        for (double m=1.5;m<=n;m++){
            double_mul*=m;
        }
        System.out.println("double_mul: "+double_mul);
        int pow_mul=1;
        int o=1;
        do{
            pow_mul*=Math.pow(o,2);
            o++;
        }while(o<=n);
        System.out.println("pow_mul is: "+pow_mul);

    }
}