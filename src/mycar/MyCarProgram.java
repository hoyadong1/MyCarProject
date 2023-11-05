package mycar;

import java.util.*;

public class MyCarProgram {
	static Manager<Car> carMgr = new Manager<>();
	static Manager<Part> partMgr = new Manager<>();
	static Manager<Option> optionMgr = new Manager<>();
	static Manager<CarStore> carStoreMgr = new Manager<>();
	static Manager<RepairShop> repairShopMgr = new Manager<>();
	
	Scanner scan = new Scanner(System.in);
	
	public void run() {
		optionMgr.readAll("Option.txt", new Factory<Option>() {
			public Option create(Scanner scan) {
				return new Option();
			}
		});
		partMgr.readAll("Part.txt", new Factory<Part>() {
			public Part create(Scanner scan) {
				return new Part();
			}
		});
		carMgr.readAll("Car.txt", new Factory<Car>() {
			public Car create(Scanner scan) {
				int n = scan.nextInt();
				if (n == 1) return new Car();
				return new ElectricCar();
				
			}
		});
		carStoreMgr.readAll("CarStore.txt", new Factory<CarStore>() {
			public CarStore create(Scanner scan) {
				return new CarStore();
			}
		});
		repairShopMgr.readAll("RepairShop.txt", new Factory<RepairShop>() {
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
		System.out.println("원하는 차량 스펙 입력");
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
		return optionMgr.find(kwd);
	}
	public static Car findCar(String kwd) {
		return carMgr.find(kwd);
	}
	public static Part findPart(String kwd) {
		return partMgr.find(kwd);
	}
	
	

	public static void main(String[] args) {
		MyCarProgram mcp = new MyCarProgram();
		mcp.run();
	}

}
