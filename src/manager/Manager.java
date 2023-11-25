package manager;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Manager<T extends Manageable> {

    public ArrayList<T> mList = new ArrayList<>();

    public Scanner openFile(String filename) {
        Scanner filein = null;
        try {
            filein = new Scanner(new File(filename));
        } catch (IOException e) {
            System.out.println("파일 입력 오류");
            System.exit(0);
        }
        return filein;
    }

    public void readAll(String filename, Factory<T> fac) {
        Scanner filein = openFile(filename);
        while (filein.hasNext()) {
            T t = fac.create(filein);
            t.read(filein);
            mList.add(t);
        }
        filein.close();
    }

    public void printAll() {
        for (T m : mList) {
            m.print();
        }
    }

    void search(Scanner scan) {
        String kwd = null;
        while (true) {
            System.out.print(">> ");
            kwd = scan.next();
            if (kwd.equals("end")) {
                break;
            }
            for (T m : mList) {
                if (m.matches(kwd)) {
                    m.print();
                }
            }
        }
    }

    public T find(String kwd) {
        for (T m : mList) {
            if (m.matches(kwd)) {
                return m;
            }
        }
        return null;
    }

    public List<T> findAll(String kwd) {
        List<T> result = new ArrayList<>();
        for (T m : mList) {
            if (m.matches(kwd)) {
                result.add(m);
            }
        }
        return result.isEmpty() ? null : result;
    }

    public void addElement(T e) {
        mList.add(e);
    }
}
