import java.util.*;
import java.lang.Math;
import java.math.BigInteger;

public class fibonacci {
    public static BigInteger fibonacci(int n)  {
        BigInteger a = BigInteger.valueOf(0); 
        BigInteger b = BigInteger.valueOf(1); 
        BigInteger c = BigInteger.valueOf(1); 
        for (int i = 2 ; i <= n ; i++) { 
            c =  a.add(b); 
            a = b; 
            b = c; 
        } 
        return (b); 
    }

    // A utility method that returns true if x is a perfect square 
    public static boolean isPerfectSquare(int x) { 
        int s = (int) Math.sqrt(x); 
        return (s * s == x); 
    }

    // Returns true if n is a Fibonacci Number, else false
    public static boolean isFibonacci(int n) {
        // n is Fibonacci if one of (5 * n * n + 4) or (5 * n * n - 4) or both is a perfect square
        int sum = 5 * n * n;
        return (isPerfectSquare(sum + 4) || isPerfectSquare(sum - 4)); 
    }

    // Finding the biggest fibo number before sum
    public static int lar_sum(int n) 
    { 
    	//Check if Last fibo number
        if (n == 0 || n == 1) 
            return n; 
  
        // Find the biggest fibo number before sum
        int num1 = 0;
        int num2 = 1;
        int sum = 1; 
        while (sum <= n) { 
            num1 = num2; 
            num2 = sum; 
            sum = num1 + num2; 
        } 
        return num2; 
    } 
  
    public static void printSum(int n) 
    { 
        while (n > 0) { 
            int i = lar_sum(n); 
            //System.out.println(f);
            
            //Counter
            n = n - i; 
            
            // Print the sum  
            if (n > 0)
            	System.out.print(i + " + "); 
            else
            	System.out.print(i + " "); 
        } 
    } 

    public static void main(String[] args) {
        //Read the input with a scanner
        Scanner user = new Scanner(System.in);
        //array list to storage the data
        String choice;
        int input = 0;
        //variables for 
        System.out.println("This program asks for an input and outputs:\nNth fibonacci number\nIf your input is fibonacci\nUnique sum of fibonacci numbers \n");
        do {
            System.out.print("Enter an integer between 1 and 1 Million: ");
            
            //I added check to make sure input is an integer 
            if (user.hasNextInt()) {
            	//user.nextLine();
                input = user.nextInt();
                if (input > 1 && input < 1000000) {
                    //Part 1
                	System.out.println("\nFibonacci of " + input +  "th term: " + fibonacci(input)+"\nIs your input Fibonacci: " + isFibonacci(input));
                    //Part 2
                	System.out.print("Sum of your input " + input + "= "); 
                    //Part 3
                	printSum(input);
                    System.out.println();
                            
                } else {
                    System.out.println("\nPlease enter an integer between 1 and 1 Million");
                }
            }
            else {
                System.out.println("Enter only integer number you doofus");
                user.nextLine();
            }
            System.out.println("\n *** Another try? Enter Y or Yes to continue ***");
            choice = user.next();
            System.out.println();
        } while( choice.equalsIgnoreCase("YES") || choice.equalsIgnoreCase("Y" ));

        System.out.println("Have a nice one");
    }

}