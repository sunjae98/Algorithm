import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
		ArrayList<String> color = new ArrayList<String>();
		
		color.add("black");
		color.add("brown");
		color.add("red");
		color.add("orange");
		color.add("yellow");
		color.add("green");
		color.add("blue");
		color.add("violet");
		color.add("grey");
		color.add("white");
		
		
		Scanner sc = new Scanner(System.in);
		
		String c1 = sc.next();
		int value1 = color.indexOf(c1) * 10; 
		
		String c2 = sc.next();
		int value2 = color.indexOf(c2);
		
		String c3 = sc.next();
		int value3 = color.indexOf(c3);
		long product = (long) Math.pow(10,value3);
		
		long result = (value1 + value2) * product;
		
		System.out.print(result);
		
		
	}

}