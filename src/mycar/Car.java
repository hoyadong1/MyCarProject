package mycar;

import java.util.*;

public class Car implements Manageable{
	String code;
	String name;
	int price;
	int year;
	String fuel;
	int fuelEfficiency;
	int power;
	
	ArrayList<Option> optionList = new ArrayList<>();

	@Override
	public void read(Scanner scan) {
		code = scan.next();
		name = scan.next();
		price = scan.nextInt();
		year = scan.nextInt();
		fuel = scan.next();
		fuelEfficiency = scan.nextInt();
		power = scan.nextInt();
		
		while(true) {
			String option = scan.next();
			if(option.equals("0")) break;
			Option o = MyCarProgram.findOption(option);
			optionList.add(o);
		}
	}

	@Override
	public void print() {
		System.out.printf("%s %s %d %d %s %d %d\n\t\t", code, name, price, year, fuel, fuelEfficiency,power);
		for(Option o : optionList) {
			System.out.print(o.name+" ");
		}
		System.out.println();
	}

	@Override
	public boolean matches(String kwd) {
		if(kwd.equals(code)) return true;
		return false;
	}

}
