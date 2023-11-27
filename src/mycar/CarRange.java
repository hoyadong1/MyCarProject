package mycar;

import java.util.ArrayList;
import java.util.Scanner;

public class CarRange {
    int startPrice;
    int endPrice;
    int startYear;
    int endYear;
    ArrayList<String> fuelList = new ArrayList();
    int startFuelEffi;
    int endFuelEffi;
    int startPower;
    int endPower;

    void read(Scanner scan) {
        System.out.println("원하는 차량 가격대 입력");
        System.out.print(">>");
        startPrice = scan.nextInt();
        endPrice = scan.nextInt();

        System.out.println("원하는 차량 연식범위 입력");
        System.out.print(">>");
        startYear = scan.nextInt();
        endYear = scan.nextInt();

        System.out.println("원하는 차량 연료타입 입력(가솔린, LPG, 디젤, 전기, 하이브리드)공백 구분 다중입력 가능, 입력마치면 0입력");
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

    void read(int a, int b, int c, int d, int e, int f, int g, int h, int list[]) {
        startPrice = a;
        endPrice = b;
        startYear = c;
        endYear = d;
        startFuelEffi = e;
        endFuelEffi = f;
        startPower = g;
        endPower = h;

        for (int i : list) {
            if (i == 0)
                fuelList.add("가솔린");
            if (i == 2)
                fuelList.add("LPG");
            if (i == 4)
                fuelList.add("디젤");
            if (i == 6)
                fuelList.add("전기");
            if (i == 8)
                fuelList.add("하이브리드");
        }
    }

    void print() {
        System.out.printf("%d %d %d %d %d %d %d %d", this.startPrice, this.endPrice, this.startYear,
                this.endYear, this.startFuelEffi, this.endFuelEffi, this.startPower, this.endPower);
    }
}
