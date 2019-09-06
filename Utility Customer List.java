package Homework4;

import java.util.Arrays;
import java.util.Scanner;
import java.lang.Comparable;

//UtilityCustomer abstract class
abstract class UtilityCustomer implements Comparable<UtilityCustomer>
{
	private int accountNum;
	
	public abstract double calculateBill();
	
	public UtilityCustomer(int accountNum) 
	{
		this.accountNum = accountNum;
	}
	public int getAccountNum() {
		return accountNum;
	}
	public void setAccountNum(int accountNum) {
		this.accountNum = accountNum;
	}
	public String toString() {
		return "\n--------------\nAccount Number: " + accountNum; 
	}
	
	public interface Comparable{
		public int compareTo(UtilityCustomer o);
	}
	//sorts array in descending order
	public int compareTo(UtilityCustomer o) {

		if (getAccountNum() < o.getAccountNum()) {
			return 1;
		}
		else if (getAccountNum() == o.getAccountNum()) {
			return 0;
		}
		else {
			return -1;
		}
	
	}
}


//GasCustomer subclass		
class GasCustomer extends UtilityCustomer{

	private int cubicMetersUsed;
	private	final double GASPRICE = 2.75;

	public GasCustomer(int accountNum, int cubicMetersUsed) {
		super(accountNum);
		this.cubicMetersUsed = cubicMetersUsed;
	}
	public int getCubicMetersUsed() {
		return cubicMetersUsed;
	}
	public void setCubicMetersUsed(int cubicMetersUsed) {
		this.cubicMetersUsed = cubicMetersUsed;
	}
	public double calculateBill() {
		return cubicMetersUsed * GASPRICE;
	}
	public String toString() {
		return super.toString() + "\nGas Customer \nGas consumption: " +cubicMetersUsed + "\nBill: " +calculateBill() +"\n--------------";
	}

}

//ElectricCustomer subclass
class ElectricCustomer extends UtilityCustomer{

	private int kWattHourUsed;
	private final double ELECPRICE = 1;
	private final double FEE = 30;

	public ElectricCustomer(int accountNum, int kWattHourUsed) {
		super(accountNum);
		this.kWattHourUsed = kWattHourUsed;
	}
	public int getKWattHourUsed(){
		return kWattHourUsed;
	}
	public void setkWattHourUsed(int kWattHourUsed){
		this.kWattHourUsed = kWattHourUsed;
	}
	public double calculateBill() {
		return ((kWattHourUsed * ELECPRICE) + FEE);
	}
	public String toString() {
		return super.toString() + "\nElectric Customer \nElectric consumption: " +kWattHourUsed + "\nBill: " +calculateBill() +"\n--------------";
	}
}

//client class
public class CollectionOfUcustomers {
	
	public static void main(String[] args) {
		
		int accountNum = 0, cubicMetersUsed = 0, kWattHourUsed= 0;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("How many customers would you like to add? (1-10)");
		int numCust = scan.nextInt();
		
		while(numCust > 10 || numCust < 1) {
			System.out.println("Please enter an amount between 0 and 10");
			numCust = scan.nextInt();
			
		}
		
		UtilityCustomer[] utilityCustomer = new UtilityCustomer[numCust];
		
		for (int x = 0; x < numCust; x++) {

			System.out.println("Please pick the type of customer you wish to add (1-2): \n1. Gass \n2. Elecrtic");
			int typeCust = scan.nextInt();

			if(typeCust == 1) {
				System.out.println("Gas account number: ");
				accountNum = scan.nextInt();
				System.out.println("Gas consumption: ");
				cubicMetersUsed = scan.nextInt();
				utilityCustomer[x] = new GasCustomer(accountNum, cubicMetersUsed);				
			}
			else if (typeCust == 2) {
				System.out.println("Electric account number: ");
				accountNum = scan.nextInt();
				System.out.println("Electric consumption: ");
				kWattHourUsed = scan.nextInt();
				utilityCustomer[x] = new ElectricCustomer(accountNum, kWattHourUsed);
			}
			else {
				System.out.println("Invalid customer type.");
			}
		}
	
		Arrays.sort(utilityCustomer);
		
		System.out.println("\n\nUtility Customers: ");
		for(int x = 0; x < numCust; x++) {
			System.out.println(utilityCustomer[x]);
		}
	}
}
