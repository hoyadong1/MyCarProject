package mycar;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import manager.Manageable;

public class RepairShop implements Manageable {

    String name;
    String location;
    int cost;

    HashMap<Part, Integer> partList = new HashMap<>();

    @Override
    public void read(Scanner scan) {
        name = scan.next();
        location = scan.next();
        cost = scan.nextInt();
        while (true) {
            String code = scan.next();
            if (code.equals("0")) {
                break;
            }
            int num = scan.nextInt();

            Part p = MyCarProgram.findPart(code);

            partList.put(p, num);

        }
    }

    @Override
    public void print() {
        Iterator<HashMap.Entry<Part, Integer>> iterator = partList.entrySet().iterator();
        System.out.printf("%s %s\n", name, location);
        while (iterator.hasNext()) {
            HashMap.Entry<Part, Integer> entry = iterator.next();
            System.out.printf("%s : %d\n", entry.getKey().code, entry.getValue());
        }
    }

    @Override
    public boolean matches(String kwd) {
        if (kwd.equals(name)) {
            return true;
        }
        return false;
    }


}
