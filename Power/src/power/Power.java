/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package power;
import java.util.Scanner;

/**
 *
 * @author harisu
 */
public class Power {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter the base");
       double base = input.nextDouble();
        System.out.println("Enter the power");
        int pow = input.nextInt();
        System.out.println("The result is :"+power(base,pow));
    }
    public static double power(double x,int n){
        if(n == 0)
            return 1.0;
        else if(n == 1)
            return x;
        else{
                if(n%2 ==0){
                       double answer = power(x,n/2);
                       double result = answer * answer;
                        return result;

               }
                else{
                    double answer = power(x,(n-1)/2);
                    double result = answer * answer * x;
                    return result;
                }
        }
    }
}
