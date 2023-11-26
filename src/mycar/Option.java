package mycar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import manager.Manageable;

public class Option implements Manageable {

    String name;
    int price;

    List<Review> reviews = null;

    @Override
    public void read(Scanner scan) {
        name = scan.next();
        price = scan.nextInt();
        reviews = MyCarProgram.reviewManager.findAll(name);

    }

    @Override
    public void print() {
        System.out.printf("%s %d %n", name, price);
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

    public List<Review> getReviews() {
        return reviews;
    }

	public int getPrice() {
		// TODO Auto-generated method stub
		return price;
	}
}
