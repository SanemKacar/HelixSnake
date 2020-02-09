import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import enigma.console.TextAttributes;
import enigma.event.TextMouseListener;

public class Screen {
	public TextMouseListener tmlis;
	public KeyListener klis;
	int timeCounter = 0, forTime = 0, cursor = 0;
	static int levelCounter = 1, PlayersScore = 0;
	public int keypr; // key pressed?
	public int rkey; // key (for press/release)
	// ----------------------------------------------------
	public boolean leftDir = false, rightDir = true, upDir = false, downDir = false;
	static String[][] board2D = new String[25][60];
	static DoubleLinkedList scoreTable = new DoubleLinkedList();
	static MultiLinkedList codonPoints = new MultiLinkedList();
	static boolean GameFinishFlag = true;
	boolean flagWall = true, flagEatItself = true;
	
	public Screen() throws Exception {
		klis = new KeyListener() {
			public void keyTyped(KeyEvent e) {
			}

			public void keyPressed(KeyEvent e) {
				if (keypr == 0) {
					keypr = 1;
					rkey = e.getKeyCode();
				}
			}

			public void keyReleased(KeyEvent e) {
			}
		};
		Menu.console.getTextWindow().addKeyListener(klis);
		Game();
	}
	public String[][] CreateBoard() {
		for (int i = 0; i < board2D.length; i++) {
			for (int j = 0; j < board2D[0].length; j++) {

				if (i == 0 || i == 24) {
					board2D[i][j] = "#";
				} else if (j == 0 || j == 59) {
					board2D[i][j] = "#";
				} else
					board2D[i][j] = " ";
			}
		}
		for (int i = 0; i < 3; i++) {
			ThrowSquareorLetter(1);
		}
		return board2D;
	}
	public static String[][] ThrowSquareorLetter(int a) {
		if (a == 0) {
			do {
				int x = (int) (Math.random() * 60);
				int y = (int) (Math.random() * 25);
				if (board2D[y][x].equals(" ")&&Snake.SnakeOrNot(y, x)==true) {
					board2D[y][x] = "#";
					break;
				}
			} while (a < 3);
		} else {
			do {
				int x = (int) (Math.random() * 60);
				int y = (int) (Math.random() * 25);
				if (board2D[y][x].equals(" ")&&Snake.SnakeOrNot(y, x)==true) {
					board2D[y][x] = RandomLetter();
					break;
				}
			} while (a < 3);
		}
		return board2D;
	}
	public static String RandomLetter() {
		int a = (int) (Math.random() * 4);
		if (a == 0)
			return "A";
		else if (a == 1)
			return "C";
		else if (a == 2)
			return "G";
		else
			return "T";
	}
	public void displayBoardWithSnake() {
		Snake.createSnake();
		Node snakeTemp = Snake.snaKe.head;
		while (snakeTemp != null) {
			SnakePartt temp = (SnakePartt) (snakeTemp.getData());
			board2D[temp.getX()][temp.getY()] = temp.getLetter();
			snakeTemp = snakeTemp.getLink();
		}
	}
	public void Game() throws Exception {
		StartGameAgain();
		TxtFile.ReadFromTop10Score();
		TxtFile.ReadFromAminoAcidTxtFile();
		displayBoardWithSnake();
		CreateBoard();
		display();
		while (GameFinishFlag) {
			Menu.console.setTextAttributes(new TextAttributes(Color.ORANGE));
			if (timeCounter % 10 == 0) {
				Menu.console.getTextWindow().setCursorPosition(68, 21);
				System.out.print("  Timer : " + timeCounter / 10);
				Menu.console.getTextWindow().setCursorPosition(68, 25);
				System.out.print("  Level = " + levelCounter);
				Menu.console.getTextWindow().setCursorPosition(70, 1);
				System.out.print("AminoAcids - Point");
				Menu.console.getTextWindow().setCursorPosition(70, 2);
				System.out.print("------------------");
			}
			Menu.console.setTextAttributes(new TextAttributes(Color.BLUE));
			Menu.console.getTextWindow().setCursorPosition(68, 23);
			System.out.print("  Score = " + PlayersScore);
			if (timeCounter % 150 == 0 && timeCounter != 0) {
				ThrowSquareorLetter(0);
				levelCounter++;
			}
			Menu.console.setTextAttributes(new TextAttributes(Color.WHITE));
			if (keypr == 1) {
				if (rkey == KeyEvent.VK_LEFT && rightDir != true) {
					leftDir = true;
					rightDir = false;
					upDir = false;
					downDir = false;
					forTime = 0;
				} else if (rkey == KeyEvent.VK_RIGHT && leftDir != true) {
					rightDir = true;
					leftDir = false;
					upDir = false;
					downDir = false;
					forTime = 0;
				} else if (rkey == KeyEvent.VK_UP && downDir != true) {
					upDir = true;
					rightDir = false;
					leftDir = false;
					downDir = false;
					forTime = 0;
				} else if (rkey == KeyEvent.VK_DOWN && upDir != true) {
					downDir = true;
					leftDir = false;
					rightDir = false;
					upDir = false;
					forTime = 0;
				} else {
					downDir = false;
					leftDir = false;
					rightDir = false;
					upDir = false;
					forTime = 1;
				}
				keypr = 0;
			}
			if (leftDir == true) {
				flagWall = Snake.CheckWall(2);
				flagEatItself = Snake.EatItself(2);
				if (flagWall == false || flagEatItself == false)
					break;
				Snake.EatLetter(2);
				flagWall = Snake.CheckWall(2);
				if (flagWall == false)
					break;
				Snake.Move(2);
			} else if (rightDir == true) {
				flagWall = Snake.CheckWall(0);
				flagEatItself = Snake.EatItself(0);
				if (flagWall == false || flagEatItself == false)
					break;
				Snake.EatLetter(0);
				flagWall = Snake.CheckWall(0);
				if (flagWall == false)
					break;
				Snake.Move(0);
			} else if (upDir == true) {
				flagWall = Snake.CheckWall(1);
				flagEatItself = Snake.EatItself(1);
				if (flagWall == false || flagEatItself == false)
					break;
				Snake.EatLetter(1);
				flagWall = Snake.CheckWall(1);
				if (flagWall == false)
					break;
				Snake.Move(1);
			} else if (downDir == true) {
				flagWall = Snake.CheckWall(3);
				flagEatItself = Snake.EatItself(3);
				if (flagWall == false || flagEatItself == false)
					break;
				Snake.EatLetter(3);
				flagWall = Snake.CheckWall(3);
				if (flagWall == false)
					break;
				Snake.Move(3);
			}
			display();
			if (Snake.snaKe.Size() % 3 == 0) {
				Node temp = Snake.snaKe.head;
				SnakePartt temp2=(SnakePartt)temp.getData();;
				String bos;
				for (int i = 0; i < 3; i++) {
					temp2=(SnakePartt)temp.getData();
					if (temp2.isFlagFor3Letter()==true) {
					Menu.console.getTextWindow().setCursorPosition(70, 3 + cursor);
					bos=Snake.TakePointFromCodon();
					System.out.print(bos);
					cursor++;
					}
					temp=temp.getLink();
				}
			}

			try {
				if (forTime == 0) {
					Thread.sleep(100);
					timeCounter++;
				}

			} catch (Exception e) {
			}
		}
		System.out.println();
		if (flagWall == false || flagEatItself == false) {
			Menu.console.getTextWindow().setCursorPosition(10, 27);
			System.out.println("Game Overrr!!!");
			Menu.console.getTextWindow().setCursorPosition(10, 28);
			System.out.println("Please enter your name: ");
			String name = Menu.scanner.nextLine();
			Score inst1 = new Score(name, PlayersScore);
			scoreTable.Add(inst1);
			TxtFile.WriteToTxt(scoreTable);
		}
	}
	public void StartGameAgain() throws Exception {
		timeCounter = 0; forTime = 0; cursor = 0;levelCounter = 1; PlayersScore = 0;leftDir = false; rightDir = true; upDir = false; downDir = false;
		GameFinishFlag = true;
		flagWall = true; flagEatItself = true;
		Snake.snaKe = new SingleLinkedList();
		scoreTable = new DoubleLinkedList();
	}
	public void display() {
		System.out.println();
		Menu.console.getTextWindow().setCursorPosition(0, 0);
		Menu.console.setTextAttributes(new TextAttributes(Color.WHITE));
		System.out.println("      ---------------------------BOARD--------------------------");
		System.out.println();
		for (int i = 0; i < board2D.length; i++) {
			for (int j = 0; j < board2D[0].length; j++) {
				Menu.console.getTextWindow().setCursorPosition(j + 5, i + 1);
				if(Snake.SnakeOrNot(i, j)==false)
					Menu.console.setTextAttributes(new TextAttributes(Color.MAGENTA));
				else if(board2D[i][j]=="#")
					Menu.console.setTextAttributes(new TextAttributes(Color.CYAN));
				else
					Menu.console.setTextAttributes(new TextAttributes(Color.GREEN));
				System.out.print(board2D[i][j]);
			}
		}Menu.console.setTextAttributes(new TextAttributes(Color.WHITE));

	}

}
