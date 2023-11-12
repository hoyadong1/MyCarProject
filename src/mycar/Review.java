package mycar;

import java.util.Scanner;

public class Review implements Manageable {

    int rating = 0;
    String reviewComment = null;
    //Option option = null;
    String optionName = null;

    //input txt => 옵션이름 별점 리뷰내용
    @Override
    public void read(Scanner scan) {
        optionName = scan.next();
        //option = MyCarProgram.findOption(scan.next());
        rating = scan.nextInt();
        reviewComment = scan.next();
    }

    @Override
    public void print() {
        System.out.printf(" rating : %d] comment : %s", rating, reviewComment);
    }

    @Override
    public boolean matches(String kwd) {
        if (kwd.equals(optionName)) {
            return true;
        } else if (kwd.equals(Integer.toString(rating))) {
            return true;
        }
        return false;
    }
}
