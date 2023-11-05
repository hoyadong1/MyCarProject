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
				if (n == 1)
					return new Car();
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

	}

	private void SearchCar() {
		// TODO Auto-generated method stub

	}

	private void PurchaseCar() {
		// TODO Auto-generated method stub

	}

	private void RecommendCar() {
		CarRange CR = new CarRange();
		CR.read();
		System.out.println("당신이 원하는 스펙에 맞는 차량 리스트입니다.");
		for(Car c : carMgr.mList) {
			if(c.isRange(CR)) c.print();
		}
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

	class CarRange {
		int startPrice;
		int endPrice;
		int startYear;
		int endYear;
		ArrayList<String> fuelList = new ArrayList();
		int startFuelEffi;
		int endFuelEffi;
		int startPower;
		int endPower;

		void read() {
			System.out.println("원하는 차량 가격대 입력");
			System.out.print(">>");
			startPrice = scan.nextInt();
			endPrice = scan.nextInt();

			System.out.println("원하는 차량 연식범위 입력");
			System.out.print(">>");
			startYear = scan.nextInt();
			endYear = scan.nextInt();

			System.out.println("원하는 차량 연료타입 입력(가솔린, 전기, 하이브리드, LPG, 디젤)공백 구분 다중입력 가능, 입력마치면 0입력");
			System.out.print(">>");
			String fuel;
			while (true) {
				fuel = scan.next();
				if (fuel.equals("0"))
					break;
				fuelList.add(fuel);
			}

			System.out.println("원하는 차량 연비 범위 입력");
			System.out.print(">>");
			startFuelEffi = scan.nextInt();
			endFuelEffi = scan.nextInt();

			System.out.println("원하는 차량 출력범위 입력");
			System.out.print(">>");
			startPower = scan.nextInt();
			endPower = scan.nextInt();
		}
	}

	public static void main(String[] args) {
		MyCarProgram mcp = new MyCarProgram();
		mcp.run();
	}

}
