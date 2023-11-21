package mycar;

import java.util.List;
import java.util.Scanner;

public class Option implements Manageable {

    String name;
    int price;
    int fixPrice;

    List<Review> reviews = null;

    @Override
    public void read(Scanner scan) {
        name = scan.next();
        price = scan.nextInt();
        fixPrice = scan.nextInt();
        reviews = MyCarProgram.reviewManager.findAll(name);

    }

    @Override
    public void print() {
        System.out.printf("%s %d %d %n", name, price, fixPrice);
        System.out.println("--리뷰--");
        if (reviews == null) {
            System.out.println("리뷰가 없습니다.");
        } else {
            for (Review review : reviews) {
                review.print();
            }
        }
    }

    @Override
    public boolean matches(String kwd) {
        if (kwd.equals(name)) {
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }
}
