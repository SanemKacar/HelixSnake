import java.awt.Color;
import enigma.console.TextAttributes;
import enigma.core.Enigma;

public class P3Main {
	public static void main(String[] args) throws Exception {
		Menu x=new Menu();
		TxtFile.ReadFromAminoAcidTxtFile();
		TxtFile.ReadFromTop10Score();
			Menu.console.getTextWindow().setCursorPosition(0,0);
			x.dispLay();
		
		
		
	}
}
