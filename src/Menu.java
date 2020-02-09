import java.awt.Color;
import java.util.Scanner;

import enigma.console.TextAttributes;
import enigma.core.Enigma;
public class Menu {
	static enigma.console.Console console = Enigma.getConsole("HELIX SNAKE", 100, 40);
	static Scanner scanner=new Scanner(System.in);
	
	public static void clear() {
		Menu.console.getTextWindow().setCursorPosition(0,0);
		for (int i = 0; i < 200; i++) {
			for (int j = 0; j <200; j++) {
				System.out.print(" ");
			}
		}
		Menu.console.getTextWindow().setCursorPosition(0,0);
	}
	public  void dispLay() throws Exception {
		String choice="";
		console.setTextAttributes(new TextAttributes(Color.GREEN));
		clear();
		console.getTextWindow().setCursorPosition(0,0);
		System.out.println();
		System.out.println();
		System.out.println("            ---     ---    -----------    ---               -------------    ---          ---");
		System.out.println("           |   |   |   |  |           |  |   |             |             |   \\  \\        /  /");
		System.out.println("           |   |   |   |  |   --------   |   |               ----   ----      \\  \\      /  /");
		System.out.println("           |   |   |   |  |   |          |   |                  |  |           \\  \\    /  /");
		System.out.println("           |   |---|   |  |   -----      |   |                  |  |            \\   --   /");
		System.out.println("           |           |  |        |     |   |                  |  |             >      <"      );
		System.out.println("           |   |---|   |  |   -----      |   |                  |  |            /   --   \\");
		System.out.println("           |   |   |   |  |   |          |   |                  |  |           /  /    \\  \\"          );
		System.out.println("           |   |   |   |  |   --------   |    ----------     ---    ----      /  /      \\  \\");
		System.out.println("           |   |   |   |  |           |  |              |  |             |   /  /        \\  \\" );
		System.out.println("            ---     ---    -----------    --------------    -------------    ---          ---");
		System.out.println();
		System.out.println();
		System.out.println("            ------------    ---       --    --------------    ---        ---    ----------- ");
		System.out.println("           |            |  |   \\     |  |  |              |  |   |     /   /   |           |");
		System.out.println("           |    --------   |    \\    |  |  |    ------    |  |   |    /   /    |   -------- " );
		System.out.println("           |   |           |     \\   |  |  |   |      |   |  |   |   /   /     |   |        ");
		System.out.println("           |    --------   |  |\\  \\  |  |  |   |      |   |  |   |__/   /      |   -----    ");
		System.out.println("           |            |  |  | \\  \\ |  |  |    ------    |  |    __   <       |        |   ");
		System.out.println("            ---------   |  |  |  \\  \\|  |  |              |  |   |  \\   \\      |   -----    ");
		System.out.println("                    |   |  |  |   \\     |  |    ------    |  |   |   \\   \\     |   |        ");
		System.out.println("            ---------   |  |  |    \\    |  |   |      |   |  |   |    \\   \\    |   --------  ");
		System.out.println("           |            |  |  |     \\   |  |   |      |   |  |   |     \\   \\   |           | ");
		System.out.println("            ------------    --        --    ---        ---    ---       ---     -----------  " );
		System.out.println();
		console.setTextAttributes(new TextAttributes(Color.PINK));
		System.out.println("                       Welcome to the Snake Game version of Amino Acids Codons");
		System.out.println();
		console.setTextAttributes(new TextAttributes(Color.CYAN));
		System.out.println("                            # For New Game         ---> Press \"1\"");
		System.out.println("                            # Show HighScore Table ---> Press \"2\"");
		System.out.println("                            # To Exit              ---> Press \"3\"");
		console.setTextAttributes(new TextAttributes(Color.PINK));
		System.out.print("Your choice is: "+choice);
		console.setTextAttributes(new TextAttributes(Color.WHITE));
		choice=scanner.nextLine();
		clear();
		console.getTextWindow().setCursorPosition(0,0);
		if(choice.equals("1")) {
			clear();
			console.getTextWindow().setCursorPosition(0,0);
			new Screen();
			dispLay();
		}else if(choice.equals("2")) {
			displayTop10();
			Thread.sleep(4000);
			clear();
			console.getTextWindow().setCursorPosition(0,0);
			dispLay();
		}
		else {
			clear();
			console.getTextWindow().setCursorPosition(0,0);
			System.exit(0); //Shot down the enigma console,
		}
		
	}
	public void displayTop10() {
		int counter=1;
		NodeDouble temp=Screen.scoreTable.head;
		Score temp2=(Score)temp.getData();
		clear();
		console.setTextAttributes(new TextAttributes(Color.RED));
		System.out.print(" -------SCORE TABLE--------"+"\n");
		System.out.print("\n");
		console.setTextAttributes(new TextAttributes(Color.WHITE));
		while (temp!=null) {
			temp2=(Score)temp.getData();
			System.out.print(" "+counter+"-"+temp2.getName()+"  Score: "+temp2.getScore()+"\n");
			temp=temp.getNext();
			counter++;
			if(counter>10)
				break;
		}
		
	}
	
}
