package mycar;

import java.util.Scanner;
import manager.Manageable;

public class Part implements Manageable {

    String code;
    String name;
    int price;
    int fixPrice;

    @Override
    public void read(Scanner scan) {
        code = scan.next();
        name = scan.next();
        price = scan.nextInt();
        fixPrice = scan.nextInt();
    }

    void read(String a) {
        code = a;
    }

    @Override
    public void print() {
        System.out.printf("%s %s %d %d\n", code, name, price, fixPrice);
    }

    @Override
    public boolean matches(String kwd) {
        if (kwd.equals(code)) {
            return true;
        }
        return false;
    }

    boolean isMatches(Part p) {
        return code.equals(p.code);
    }

    public int insertSelf(int row) {
        if (row == 0) {
            Start1.data = new Object[][]{{code, price},
                    {null, null},
                    {null, null},
                    {null, null},
                    {null, null},
                    {null, null},
                    {null, null},};
        } else {
            for (int i = 0; i < 2; i++) {
                if (i == 0) {
                    Start1.data[row][i] = code;
                }
                if (i == 1) {
                    Start1.data[row][i] = price;
                }
            }
        }
        return (row + 1);
    }
}

