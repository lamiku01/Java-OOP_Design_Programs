package homework5;

import java.util.Scanner;
import java.lang.String;
import java.text.NumberFormat;

class Employee {
	String Name, SSNumber;
	double Salary;
	
	public Employee(String Name, String SSNumber, double Salary) throws SSNLengthException, SSNCharacterException {
		setName(Name);
		setSSNumber(SSNumber);
		setSalary(Salary);
	}
	public String getName(){
		return Name;
	}
	public void setName(String Name) {
		this.Name = Name;
	}
	public String getSSNumber() {
		return SSNumber;
	}
	public void setSSNumber(String SSNumber) throws SSNCharacterException, SSNLengthException {
		int count = 0;
		for (int x = 0; x < SSNumber.length(); x++) {
			if(SSNumber.charAt(x) >= '0' && SSNumber.charAt(x) <= '9') {
				count++;
			}
			else if ((SSNumber.charAt(x) != '-') && (SSNumber.charAt(x) != ' ')) {
				throw new SSNCharacterException(SSNumber);
			}
		}
		if(count != 9) {
			throw new SSNLengthException(SSNumber);
		}
		this.SSNumber = SSNumber;	
	}	
	public double getSalary() {
		return Salary;
	}
	public void setSalary(double Salary) {
		this.Salary = Salary;
	}
	
	public boolean equals(Employee other) {
		return (Name.equalsIgnoreCase(other.Name) || (SSNumber.equalsIgnoreCase(other.SSNumber)));
	}
	
	public String toString() {
		NumberFormat fmt = NumberFormat.getCurrencyInstance();
		return "\n------------------ \nName: " +Name +"\nSSN: " +SSNumber +"\nSalary: " +fmt.format(Salary); 
	}	
}

class SSNLengthException extends Exception{
	public SSNLengthException(String SSNumber){
		 super("ERROR- SSN does not contain exactly 9 digits: " + SSNumber);
	 }
}
 
 class SSNCharacterException extends Exception{
	 public SSNCharacterException(String SSNumber){
		 super("ERROR- SSN contains one or more non-digits: " + SSNumber);
	 }
 }
 
public class EmployeeBuilder {
	
	private static boolean checkEquality(Employee employees[], Employee other, int count) {
		 for (int x = 0; x < count; x++ ) {
			 if (employees[x].equals(other)) {
				 return true;
			 }
		 }
		 return false;
	}
	private static double avgSalary(Employee employees[], double count) {
		
		double totalSalary = 0;
		
		for(int x =0; x < count; x++) {
			totalSalary += employees[x].getSalary();
		}
		if (count > 0) {
			return (totalSalary/count);
		}
		else
			return 0;
	}
	public static void main(String[] args) {
		
		int count = 0, x =0; 
		String Name , SSNumber;
		double Salary;
		
		NumberFormat fmt = NumberFormat.getCurrencyInstance();
		
		Scanner scan = new Scanner (System.in);
		
		System.out.println("How many employees would you like to add (1-100)?: ");
		int numEmployees = scan.nextInt();
	
		while(numEmployees > 100 || numEmployees < 1) {
			System.out.println("Please enter a valid amount (1-100): ");
			numEmployees = scan.nextInt();
		}
		
		Employee employees[] = new Employee[numEmployees];
		 
		for (x = 0; x < numEmployees; x++) {
		
			String o = scan.nextLine();
		
			System.out.println("\nEmployee #" +(count + 1));
			System.out.println("Name: ");
			Name = scan.nextLine();
			System.out.println("Social Security Number: ");
			SSNumber = scan.nextLine();
			System.out.println("Salary: ");
			Salary = scan.nextDouble();
			
			try {
				employees[count] = new Employee(Name, SSNumber, Salary);

				if(!checkEquality(employees, employees[count], count)){
					count ++;
				}
				else {
					System.out.println("ERROR- Employee or SSN already exists");
				}
			}
			catch (SSNLengthException | SSNCharacterException e){
				System.out.println(e.getMessage());
			}
		}
		
		double avgSalary = avgSalary(employees, count);
		
		System.out.println("\n\nEmployee Information:");
		System.out.println("Average employee salary: " +fmt.format(avgSalary));
		for (x = 0; x < count; x++) {
			if(employees[x].getSalary() > avgSalary) {
				System.out.println("\nEmployee #" +(x+1) +employees[x] + "\nAbove average salary \n------------------");
			}
			else if(employees[x].getSalary() < avgSalary) {
				System.out.println("\nEmployee #" +(x+1) +employees[x] + "\nBelow average salary \n------------------");
			}
			else if(employees[x].getSalary() == avgSalary) {
				System.out.println("\nEmployee #" +(x+1) +employees[x] + "\nAverage salary \n------------------");
			}
		}
		scan.close();
	}
}
