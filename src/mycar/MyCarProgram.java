package mycar;

import java.util.HashSet;
import java.util.Scanner;
import manager.CarManager;
import manager.CarStoreManager;
import manager.Manager;
import manager.OptionManager;
import manager.PartManager;
import manager.RepairShopManager;
import manager.ReviewManager;

public class MyCarProgram {

    Scanner scan = new Scanner(System.in);

    public void run() {
        ReviewManager.getInstance().readAll("Review.txt", scan -> new Review());
        ReviewManager.getInstance().printAll();
        OptionManager.getInstance().readAll("Option.txt", scan -> new Option());
        PartManager.getInstance().readAll("Part.txt", scan -> new Part());
        CarManager.getInstance().readAll("Car.txt", scan -> {
            int n = scan.nextInt();
            if (n == 1) {
                return new Car();
            }
            return new ElectricCar();
        });
        CarStoreManager.getInstance().readAll("CarStore.txt", scan -> new CarStore());
        RepairShopManager.getInstance().readAll("RepairShop.txt", scan -> new RepairShop());

        OptionManager.getInstance().printAll();
        //CarManager.getInstance().printAll();
    }

    private void Menu() {
        int num;
        while (true) {
            System.out.print("(1)차량추천 (2)차량구매견적 (3)차량매물검색 (4)수리 및 교체 (기타) 종료 ");
            num = scan.nextInt();
            if (num < 1 || num > 4) {
                break;
            }
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
        System.out.print("수리할 부품 코드를 입력하세요: ");
        String code = scan.next();
        boolean exists = false;

        // 부품 코드 입력받아 있으면 if문 실행 없으면 else문 실행
        Part repairPart = findPart(code);
        if (repairPart != null) {
            // 부품 이름과 부품 수리 견적 출력
            System.out.println("부품 이름: " + repairPart.name);
            System.out.println("부품 수리 견적: " + repairPart.fixPrice);

            // 해당 부품을 보유한 정비소 출력 없으면 없다고 안내
            System.out.println("해당 부품을 보유한 정비소:");
            for (RepairShop repairShop : RepairShopManager.getInstance().mList) {
                if (repairShop.partList.containsKey(repairPart)) {
                    System.out.println(repairShop.name + " (" + repairShop.location + ")");
                    exists = true;
                }
            }
            if (!exists) {
                System.out.println("해당 부품이 정비소에 존재하지 않습니다.");
            }
        } else {
            System.out.println("해당 부품이 존재하지 않습니다.");
        }
    }

    private void SearchCar() {
        System.out.print("차종 코드를 입력하세요: ");
        String carCode = scan.next();
        System.out.println("검색 결과:");
        boolean carExists = false;
        Car findingCar = findCar(carCode);
        for (CarStore store : CarStoreManager.getInstance().mList) {
            if (store.haveCar(findingCar)) {
                carExists = true;
                System.out.println(store.name + " " + store.location + " : "
                    + store.carList.get(findingCar) + "대");
            }
        }
        if (!carExists) {
            System.out.println("해당 차량은 현재 전국 매장에 존재하지 않습니다.");
        }
    }

    private void PurchaseCar() {
        HashSet<String> carType = CarTypeArray();
        String inputCarType = null;
        String inputCarOption = null;
        Car purchaseCar = null;
        Option option = null;

        for (String string : carType) {
            System.out.println(string);
        }
        System.out.println("차종을 입력하세요.");
        inputCarType = scan.next();
        purchaseCar = findCar(inputCarType);

        OptionManager.getInstance().printAll();
        System.out.println("옵션을 입력하세요. 0 : 종료");
        while (true) {
            inputCarOption = scan.next();
            if (inputCarOption.equals("0")) {
                break;
            }
            option = findOption(inputCarOption);
            purchaseCar.optionList.add(option);
            purchaseCar.price += option.price;
        }
        purchaseCar.print();
    }

    private void RecommendCar() {
        CarRange CR = new CarRange();
        CR.read(scan);
        System.out.println("당신이 원하는 스펙에 맞는 차량 리스트입니다.");
        for (Car c : CarManager.getInstance().mList) {
            if (c.isRange(CR)) {
                c.print();
            }
        }
    }

    public static Option findOption(String kwd) {
        return OptionManager.getInstance().find(kwd);
    }

    public static Car findCar(String kwd) {
        return CarManager.getInstance().find(kwd);
    }

    public static Part findPart(String kwd) {
        return PartManager.getInstance().find(kwd);
    }

    public HashSet<String> CarTypeArray() {
        // TODO arrlylist 아무거나 입력받아도 특정 키워드로 중복제거하는 기능 제작
        HashSet<String> carType = new HashSet<>();
        for (Car car : CarManager.getInstance().mList) {
            carType.add(car.name);
        }
        return carType;
    }

    public void makeRecommendList(CarRange cr) {
        int row = 0;
        for (Car c : CarManager.getInstance().mList) {
            if (c.isRange(cr)) {
                row = c.insertSelf(row);
            }
        }
    }

    public static void main(String[] args) {
        MyCarProgram mcp = new MyCarProgram();
        mcp.run();
    }

}
