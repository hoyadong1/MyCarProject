package mycar;

import java.util.*;

public class MyCarProgram {
	static Manager<Car> CarMgr = new Manager<>();
	static Manager<Part> PartMgr = new Manager<>();
	static Manager<Option> OptionMgr = new Manager<>();
	static Manager<CarStore> CarStoreMgr = new Manager<>();
	static Manager<RepairShop> RepairShopMgr = new Manager<>();
	
	Scanner scan = new Scanner(System.in);
	
	public void run() {
		OptionMgr.readAll("Option.txt", new Factory<Option>() {
			public Option create(Scanner scan) {
				return new Option();
			}
		});
		PartMgr.readAll("Part.txt", new Factory<Part>() {
			public Part create(Scanner scan) {
				return new Part();
			}
		});
		CarMgr.readAll("Car.txt", new Factory<Car>() {
			public Car create(Scanner scan) {
				int n = scan.nextInt();
				if (n == 1) return new Car();
				return new ElectricCar();
				
			}
		});
		CarStoreMgr.readAll("CarStore.txt", new Factory<CarStore>() {
			public CarStore create(Scanner scan) {
				return new CarStore();
			}
		});
		RepairShopMgr.readAll("RepairShop.txt", new Factory<RepairShop>() {
			public RepairShop create(Scanner scan) {
				return new RepairShop();
			}
		});
		Menu();
	}
	
	private void Menu() {
		int num;
		while (true) {
			System.out.print("(1)차량추천 (2)차량구매견적 (3)차량매물검색 (4)수리 및 교체 (기타) 종료 ");
			num = scan.nextInt();
			if (num < 1 || num > 4)
				break;
			switch (num) {
			case 1:
				RecommendCar();
				break;
			case 2:
				PurchaseCar();
				break;
			case 3:
				SearchCar();
				break;
			case 4:
				RepairCar();
				break;
			default:
				break;
			}
		}
	}

	private void RepairCar() {
		// TODO Auto-generated method stub
		
	}

	private void SearchCar() {
		// TODO Auto-generated method stub
		
	}

	private void PurchaseCar() {
		// TODO Auto-generated method stub
		
	}

	private void RecommendCar() {
		// TODO Auto-generated method stub
		
	}
	
	

	public static Option findOption(String kwd) {
		return OptionMgr.find(kwd);
	}
	public static Car findCar(String kwd) {
		return CarMgr.find(kwd);
	}
	public static Part findPart(String kwd) {
		return PartMgr.find(kwd);
	}
	
	

	public static void main(String[] args) {
		MyCarProgram mcp = new MyCarProgram();
		mcp.run();
	}

}
