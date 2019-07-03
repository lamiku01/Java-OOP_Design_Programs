package homework2;

import java.util.Scanner;

class BabysittingJob
{
	int jobNumber;
	int code;
	String babysitter;
	int numChildren;
	int hours;
	int fee;
	int year;
	int jobNum;
	
	public BabysittingJob(int jobNumber, int code, int numChildren, int hours)
	{
		this.jobNumber = jobNumber;
		this.code = code;
		this.numChildren = numChildren;
		this.hours = hours;
		
		if (code == 1)
		{
			babysitter = "Cindy";
			fee = numChildren * (hours * 7);
		}
		if (code == 2)
		{
			babysitter = "Greg";
			fee = hours * (9 + (4 * (numChildren - 1)));
		}
		if (code == 3)
		{
			babysitter = "Marcia";
			fee = hours * (9 + (4 * (numChildren - 1)));
		}
	}
	
	public String toString()
	{
		return  babysitter + " will babysit " +numChildren + " children for " + hours +" hours for a total of $" +fee; 
	}
}

public class problem_1 {
	
	public static void main(String[] args)
	{
		int x = 0;
		
		Scanner scan = new Scanner(System.in);
		BabysittingJob obj1 = new BabysittingJob(1,1,1,1);
		
		System.out.println("Please enter the following: ");
		
		while (x == 0) 
		{
			System.out.println("A year between 2019 and 2025: ");
			int year = scan.nextInt();
			if (year < 2019 || year > 2025)
			{
				System.out.print("Please enter a valid year.\n");
			}
			else
			{
				x++;
				obj1.year = year;
			}
		}
		while (x == 1)
		{
			System.out.println("A job number between 1 and 9999: ");
			int jobNum = scan.nextInt();
			if (jobNum < 1 || jobNum > 9999)
			{
				System.out.print("Please enter a valid job number.\n");
			}
			else
			{
				x++;
				obj1.jobNum = jobNum;
				Integer.toString(obj1.jobNum);
			}
		}
		while (x == 2)
		{
			System.out.println("A babysitter code (1-3): ");
			int code = scan.nextInt();
			if (code < 1 || code > 3)
			{
				System.out.print("Please enter a valid code.\n");
			}
			else
			{
				x++;
				obj1.code = code;
			}
		}
		while(x == 3)
		{
			System.out.println("Number of children (1-9): ");
			int numChildren = scan.nextInt();
			if (numChildren < 1 || numChildren > 9)
			{
				System.out.print("Please enter a valid number of children.\n");
			}
			else
			{
				x++;
				obj1.numChildren = numChildren;
			}
		}
		while (x == 4)
		{
			System.out.println("Number of hours (1-12): ");
			int hours = scan.nextInt();
			if (hours < 1 || hours > 12)
			{
				System.out.print("Please enter a valid number of hours.\n");
			}
			else
			{
				x++;
				obj1.hours = hours;
			}
		}

		String syear = String.valueOf(obj1.year);
		String sjobNum = String.format("%04d", obj1.jobNum);
		String jobNumber = syear.substring(2) + sjobNum;
		
		
		System.out.println("\nJob number: " + jobNumber);
		BabysittingJob obj2 = new BabysittingJob(obj1.jobNumber,obj1.code,obj1.numChildren,obj1.hours);
		System.out.println(obj2.toString());

	}
}

