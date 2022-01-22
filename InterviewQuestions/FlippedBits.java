package InterviewQuestions; //Databricks I think.
import java.util.*;

public class FlippedBits
{
	public static int  flippedBits(int num1, int num2)
	{
		// Write your code here
		String answer = Integer.toBinaryString(num1 ^ num2);
		int count = 0;
		
		for(int i=0; i<answer.length(); i++) {
			if(answer.charAt(i)=='1') count++;
		}
		return count;
	}

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		// input for num1
		int num1 = in.nextInt();
		
		// input for num2
		int num2 = in.nextInt();
		
		
		int result = flippedBits(num1, num2);
		System.out.print(result);
		
	}
}
