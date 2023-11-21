package manager;

import java.util.Scanner;

public interface Manageable {

    public void read(Scanner scan);

    public void print();

    public boolean matches(String kwd);
}
