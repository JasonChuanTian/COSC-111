import java.util.Scanner;
/**
 * @author Chuan.Tian(Jason)
 * @version 1.0
 * @Description Convert binary number to decimal
 */

public class BinaryToDecimal
{
	
	public static void main(String[] args)
	{
		//Declarations
		long inputNumber;
		long decimalNumber;
		long digits[] = new long[20];
		
		boolean noError;
		
		inputNumber = takeInputLong();
		digits = extractDigits(inputNumber);
		noError = dataValidation(inputNumber,digits);
		
		if (noError)
		{
			
			decimalNumber = binaryToDecimal(digits);
			displayResults(0,inputNumber,decimalNumber);
			
		}
		
	}
	
	
	public static boolean isBinary(long a[])
	{
		for (int i=0; i<a.length; i++)
		{
			if(!(a[i]==0 || a[i]==1))
				return false;
		}
		return true;
	}
	
	
	public static long binaryToDecimal(long n[])
	{
		long t[] = new long[n.length];
		long decimal = 0;
		for (int i=0; i<n.length; i++)
			t[i] = n[i] * (long)(Math.pow(2, i));
		for (int i=0; i<n.length; i++)
			decimal += t[i]; //add together
		return decimal;
	}
	
	
	public static long[] extractDigits (long n)
	{
		long num[] = new long[20];
		num[19] = (long)(n/(Math.pow(10, 20)));
		for (int i=18; i>0; i--)
		{
			n = n - num[i+1] * (long)Math.pow(10, i+1); //Extracting highest digit
			num[i] = (long)(n/Math.pow(10, i)); //obtain current digit
		}
		num[0] = n%10;
		return num;
	}
	
	
	public static boolean dataValidation(long inputNumber, long digits[])
	{
		boolean noErr;
		
		if (inputNumber<0) 
		{
			noErr = false;
			System.out.println("ERROR 00: Can Not Be negtive.");
		}
		else if (!isBinary(digits))
		{
			noErr = false;
			System.out.println("ERROR 01: Not a Binary number.");
		}
		else
			noErr = true;
		if (!noErr)
			System.out.println("An error(s) has occurred, terminating program....");
		
		return noErr;
	}
	
	
	public static long takeInputLong()
	{
		long inputNumber;
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a number (up to 19-digits) in binary:");
		inputNumber = input.nextLong();
		return inputNumber;
	}
	
	
	public static void displayResults(int mode,long input1,long input2)
	{
		if (mode == 0)
		{
			System.out.println("The binary number you entered: " + input1 );
			System.out.println("Its equivalent decimal number is " + input2 );
		}
	}
	
	
}

