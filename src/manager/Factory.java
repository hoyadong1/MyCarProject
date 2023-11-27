package manager;

import java.util.Scanner;

public interface Factory<T extends Manageable> {

    public T create(Scanner scan);
}
