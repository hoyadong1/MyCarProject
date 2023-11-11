package mycar;

import java.util.Scanner;

public class Review implements Manageable {

    int rating = 0;
    String reviewComment = null;

    @Override
    public void read(Scanner scan) {
        rating = scan.nextInt();
        reviewComment = scan.next();
    }

    @Override
    public void print() {
        System.out.printf(" rating : %d] comment : %s", rating, reviewComment);
    }

    @Override
    public boolean matches(String kwd) {
        if (kwd.equals("" + rating)) {
            return true;
        }
        return false;
    }
}
