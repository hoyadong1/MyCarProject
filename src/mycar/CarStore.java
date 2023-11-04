package mycar;

import java.util.*;

public class CarStore implements Manageable {
	String name;
	String location;
	
	HashMap<Car,Integer> CarList = new HashMap<>();
	Iterator<HashMap.Entry<Car, Integer>> iterator = CarList.entrySet().iterator();

	@Override
	public void read(Scanner scan) {
		name = scan.next();
		location = scan.next();
		
		while(true) {
			String code = scan.next();
			if(code.equals("0")) break;
			int num = scan.nextInt();
			Car c = MyCarProgram.findCar(code);
			
			CarList.put(c, num);
		}
	}

	@Override
	public void print() {
		System.out.printf("%s %s\n", name,location);
		while(iterator.hasNext()) {
			HashMap.Entry<Car, Integer> entry = iterator.next();
			System.out.printf("%s : %d\n",entry.getKey().code,entry.getValue());
		}
	}

	@Override
	public boolean matches(String kwd) {
		if(kwd.equals(name)) return true;
		return false;
	}

}
