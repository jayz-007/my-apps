package csv.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CSVLoader {

	private List lines = new ArrayList<String>();

	public CSVLoader(String pathname) {
		try {
			File myFile = new File(pathname);
			BufferedReader br = new BufferedReader(new FileReader(myFile));
			String line;
			while (((line = br.readLine()) != null)) {
				lines.add(line);
			}
			br.close();

		} catch (Exception e) {
			System.out.println("Invalid file:");
		}

	}

	public List<String> getList() {
		return lines;
	}

}
