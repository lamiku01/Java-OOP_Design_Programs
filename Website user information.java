 
package Homework3;

import java.util.Scanner;
import java.lang.String;


//ProcessForm class
class ProcessForm
{
	
	String id, name, pWord, rePWord, email, pNum;
	
	private String[] UserInfo = {"id", "name", "pword", "repword", "email", "pnum"};
	
	//constructor
	public ProcessForm(String[] UserInfo) {
		
		
		int arrayLength = UserInfo.length;
		if(arrayLength != 6)
		{
			System.out.println("Please enter all 6 elements ");
		}
	}
	
	//getter
	public String[] getUserInfo(){
		return UserInfo;
	}
	
	//setter
	public void setUserInfo(int index, String value) {
		UserInfo[index] = value;
	}
	
	//toString method
	public String toString(String[] UserInfo) { //change this to not print passwords
		
		String info = ("\nUser Information: \nId: " + UserInfo[0] + "\nName: " + UserInfo[3] + "\nEmail: " + UserInfo[4] + "\nPhone Number: " + UserInfo[5]);
		return info;
	}
	
	//checks for matching and valid passwords
	public boolean CheckPasswords(String pWord, String rePWord){
		if (pWord.equals(rePWord)) {
			return true;
		}
		else {
			System.out.println("Passwords do not match. Please try again.");
			return false;
		}
	}
	
	//checks for valid email address
	public boolean CheckEmailAdd(String email) {

		int x = email.indexOf('@');
		int y = email.indexOf('.');
		int z = email.indexOf('@', x);
		int a = email.lastIndexOf("@");
		
		if(a != x) {
			System.out.println("Invalid email. Please try again.");
			return false;
		}
		else if(z > x){
			System.out.println("Invalid email. Please try again.");
			return false;
		}
		else if (x > 0) {
			if (y > x) {
				return true;
			}
			else {
				System.out.println("Invalid email. Please try again.");
				return false;
			}
		}
		else {
			System.out.println("Invalid email. Please try again.");
			return false;
		}
	}
	
	public boolean CheckPhone(String pNum) {
		
		if(pNum.matches("[2-7]\\d{2}-\\d{4}")) {
			return true;
		}
		else if(pNum.matches("\\d{3}-[2-7]\\d{2}-\\d{4}")) {
			return true;
		}
		else {
			System.out.println("Invalid phone number. Please try again.");
			return false;
		}
	}
}
	

public class Website_User {
	
	public static void main(String[] args) {
		
		int x = 0;
		
		String[] UserInfo1= {"a", "b", "c", "d", "e", "f"};
		
		ProcessForm obj1 = new ProcessForm(UserInfo1);
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Please enter the following information:");
		
		while (x == 0) 
		{
			System.out.println("User id: ");
			String id = scan.nextLine();
			x++;
			obj1.id = id;
		}
		while (x == 1)
		{
			System.out.print("Password: ");
			String pWord = scan.nextLine();
			System.out.print("Please enter again for validation: ");
			String rePWord = scan.nextLine();
			if (obj1.CheckPasswords(pWord, rePWord) == true){
				x++;
				obj1.pWord = pWord;
				obj1.rePWord = rePWord;
			}
		}
		while (x == 2)
		{
			System.out.print("Name: ");
			String name = scan.nextLine();
			x++;
			obj1.name = name;
			
		}
		while (x == 3)
		{
			System.out.print("Email address: ");
			String email = scan.nextLine();
			if (obj1.CheckEmailAdd(email) == true) {
				x++;
				obj1.email = email;
			}
		}
		while (x == 4)
		{
			System.out.println("Phone number: ");
			String pNum = scan.nextLine();
			if (obj1.CheckPhone(pNum) == true) {
				x++;
				obj1.pNum = pNum; 
			}
		}
		
		
		String [] UserInfo = {obj1.id, obj1.pWord, obj1.rePWord, obj1.name, obj1.email, obj1.pNum};
		
		String output = obj1.toString(UserInfo);
		
		System.out.println(output);
	}
	
}
