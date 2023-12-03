package mycar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import manager.Manageable;


public class Car implements Manageable {

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

        while (true) {
            String option = scan.next();
            if (option.equals("0")) {
                break;
            }
            Option o = MyCarProgram.findOption(option);
            optionList.add(o);
        }
    }

    @Override
    public void print() {
        System.out.printf("%s %s %d %d %s %d %d\n\t\t", code, name, price, year, fuel,
            fuelEfficiency, power);
        for (Option o : optionList) {
            System.out.print(o.name + " ");
        }
        System.out.println();
    }

    @Override
    public boolean matches(String kwd) {
        if (kwd.equals(code)) {
            return true;
        }
        if (kwd.equals(name)) {
            return true;
        }
        return false;
    }

    public boolean isRange(CarRange c) {
        if (price < c.startPrice || price > c.endPrice) {
            return false;
        }
        if (year < c.startYear || year > c.endYear) {
            return false;
        }
        int i = 0;
        for (String compFuel : c.fuelList) {
            if (compFuel.equals(fuel)) {
                break;
            }
            i++;
        }
        if (i == c.fuelList.size()) {
            return false;
        }
        if (fuelEfficiency < c.startFuelEffi || fuelEfficiency > c.endFuelEffi) {
            return false;
        }
        if (power < c.startPower || power > c.endPower) {
            return false;
        }
        return true;
    }

    public int insertSelf(int row) {
        if (row == 0) {
            Start1.data = new Object[][]{{code, name, price, year, fuel, fuelEfficiency, power},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},};
        } else {
            for (int i = 0; i < 7; i++) {
                if (i == 0) {
                    Start1.data[row][i] = code;
                }
                if (i == 1) {
                    Start1.data[row][i] = name;
                }
                if (i == 2) {
                    Start1.data[row][i] = price;
                }
                if (i == 3) {
                    Start1.data[row][i] = year;
                }
                if (i == 4) {
                    Start1.data[row][i] = fuel;
                }
                if (i == 5) {
                    Start1.data[row][i] = fuelEfficiency;
                }
                if (i == 6) {
                    Start1.data[row][i] = power;
                }
            }
        }
        return (row + 1);
    }

    public List<String> getOptionListName() {
        ArrayList<String> optionListName = new ArrayList<>();
        for (Option option : optionList) {
            if (option != null) {
                optionListName.add(option.name);

            }
        }

        return optionListName;
    }

    public void addOptionList(Option o) {
        optionList.add(o);
    }

    public void removeOption() {
        optionList.clear();
    }

    public String getCarName() {
        return name;
    }
    public String getCarCode() {
        return code;
    }
    public int getCarPrice() {
        int sum = price;
        for (Option option : optionList) {
            sum += option.price;
        }
        return sum;
    }

    public double getOptionRate() {
        double sum = 0;
        int optionCount = 0;
        double avg = 0;
        for (Option option : optionList) {
            avg = option.avgReview();
            if (avg != 0) {
                optionCount++;
            }
            sum += avg;
        }
        return sum / optionCount;
    }
}
