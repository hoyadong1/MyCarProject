package mycar;

import java.util.Scanner;

public class Option implements Manageable{
	String name;
	int price;
	int fixPrice;

	@Override
	public void read(Scanner scan) {
		name = scan.next();
		price = scan.nextInt();
		fixPrice = scan.nextInt();
	}

	@Override
	public void print() {
		System.out.printf("%s %d %d\n", name,price,fixPrice);
	}

	@Override
	public boolean matches(String kwd) {
		if(kwd.equals(name)) return true;
		return false;
	}

}
