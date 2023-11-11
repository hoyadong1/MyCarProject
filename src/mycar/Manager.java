package mycar;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Manager <T extends Manageable>{
	ArrayList<T> mList = new ArrayList<>();
	
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
		for(T m : mList) {
			m.print();
		}
	}

	void search(Scanner scan) {
		String kwd = null;
		while (true) {
			System.out.print(">> ");
			kwd = scan.next();
			if (kwd.equals("end"))
				break;
			for (T m : mList) {
				if (m.matches(kwd))
					m.print();
			}
		}
	}

	public T find(String kwd) {
		for(T m : mList) {
			if(m.matches(kwd)) return m;
		}
		return null;
	}

}