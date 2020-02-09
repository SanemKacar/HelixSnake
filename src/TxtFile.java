import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class TxtFile {
	static Charset utf8 = StandardCharsets.UTF_8;

	public static void WriteToTxt(DoubleLinkedList a) throws IOException {
		NodeDouble temp = a.head;
		Score RealTemp = (Score) temp.getData();
		int counter = 1;
		try {
			Writer writer = new BufferedWriter(
					new OutputStreamWriter(new FileOutputStream("HighScoreTable.txt"), utf8));
			if (temp.getNext() == null && a.size() == 1 && counter < 11) {
				writer.write(RealTemp.getName() + ";" + Integer.toString(RealTemp.getScore()) + "\r\n");
				counter++;
			} else {
				while (temp.getNext() != null && counter < 11) {
					writer.write(RealTemp.getName() + ";" + Integer.toString(RealTemp.getScore()) + "\r\n");
					temp = temp.getNext();
					RealTemp = (Score) temp.getData();
					counter++;
					if (temp.getNext() == null && counter < 11) {
						writer.write(RealTemp.getName() + ";" + Integer.toString(RealTemp.getScore()) + "\r\n");
						counter++;
					}
				}
			}
			writer.close();
		} catch (IOException ex) {
		}
	}

	public static void ReadFromTop10Score() {
		try {
			int counter = 1;
			FileReader reader = new FileReader("HighScoreTable.txt");
			BufferedReader bufferedReader = new BufferedReader(reader);
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				if (counter > 11)
					break;
				String[] tag = line.split(";", -1);
				Score inst = new Score(tag[0], Integer.parseInt(tag[1]));
				Screen.scoreTable.Add(inst);
				counter++;
			}
			reader.close();
		} catch (Exception e) {
		}
	}

	public static void ReadFromAminoAcidTxtFile() {
		try {
			FileReader reader = new FileReader("aminoacids.txt");
			BufferedReader bufferedReader = new BufferedReader(reader);
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				String[] tag = line.split(",", -1);
				Screen.codonPoints.AddAminoAcid(tag[0], tag[1]);
				for (int i = 2; i < tag.length; i++) {
					Screen.codonPoints.AddCodonsNode(tag[1], tag[i]);
				}
			}
			reader.close();
		} catch (Exception e) {
		}
	}
}
