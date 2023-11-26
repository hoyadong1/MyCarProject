package mycar;

import java.util.Scanner;
import manager.Manageable;

public class Review implements Manageable {

    int rating = 0;
    String reviewComment = null;
    String optionName = null;

    //input txt => 옵션이름 별점 리뷰내용
    @Override
    public void read(Scanner scan) {
        optionName = scan.next();
        rating = scan.nextInt();
        reviewComment = scan.nextLine();
    }

    @Override
    public void print() {
        System.out.printf("%s rating : [%d] comment : %s %n", optionName, rating,
            reviewComment);
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

    public int getRating() {
        return rating;
    }

    public String getReviewComment() {
        return reviewComment;
    }
}
