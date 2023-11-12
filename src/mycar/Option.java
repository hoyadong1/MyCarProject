package mycar;

import java.util.Scanner;

public class Option implements Manageable {

    String name;
    int price;
    int fixPrice;

    @Override
    public void read(Scanner scan) {
        name = scan.next();
        price = scan.nextInt();
        fixPrice = scan.nextInt();
        while (true) {
            MyCarProgram.findReview(name);
            //TODO 같은 이름을 가진 옵션을 모두 추가하는 방법 생각하기....
        }

    }

    @Override
    public void print() {
        System.out.printf("%s %d %d %n", name, price, fixPrice);
    }

    @Override
    public boolean matches(String kwd) {
        if (kwd.equals(name)) {
            return true;
        }
        return false;
    }

}
