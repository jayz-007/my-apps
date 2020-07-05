package csv.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CSVMerger {
	public static void main(String args[]) throws IOException {
		mergeCSV("S1.CSV", "S2.CSV");

	}

	public static void mergeCSV(String file1, String file2) throws IOException {
		try {
			BufferedReader f1 = new BufferedReader(new FileReader(file1));
			BufferedReader f2 = new BufferedReader(new FileReader(file2));
			File file = new File("Merged");
			String lineOfF1, lineOfF2, lineMerged;
			FileWriter writer = new FileWriter(file);

			while (((lineOfF1 = f1.readLine()) != null) && ((lineOfF2 = f2.readLine()) != null)) {
				lineMerged = lineOfF1 + "," + lineOfF2 + '\n';
				writer.write(lineMerged);

			}
			f1.close();
			f2.close();
			writer.close();
			System.out.println("merged succes");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
