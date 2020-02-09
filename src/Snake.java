
public class Snake {
	static SingleLinkedList snaKe = new SingleLinkedList();
	static SingleLinkedList PointsSnake = new SingleLinkedList();
	public static void createSnake() {
		for (int i = 0; i < 3; i++) {
			SnakePartt abc = new SnakePartt(14, 25 + i, Screen.RandomLetter());
			snaKe.addFront(abc);
		}
		
	}
	public static SingleLinkedList Add(int x,int y,String letter) {
		SnakePartt ab=new SnakePartt(x,y,letter);
		snaKe.addFront(ab);
		return snaKe;
	}
	public static void Move(int direction) {
		Node snakeTemp = snaKe.head;
		SnakePartt temp = (SnakePartt) (snakeTemp.getData());
		int tempX = temp.getX();
		int tempY = temp.getY();
		int temp2X, temp2Y;
		if (direction == 0) { // right
			temp.setY(temp.getY() + 1);
		} else if (direction == 1) { // up
			temp.setX(temp.getX() - 1);
		} else if (direction == 2) { // left
			temp.setY(temp.getY() - 1);
		} else if (direction == 3) { // down
			temp.setX(temp.getX() + 1);
		}
		Screen.board2D[temp.getX()][temp.getY()] = temp.getLetter();
		snakeTemp = snakeTemp.getLink();
		while (snakeTemp != null) {
			temp = (SnakePartt) (snakeTemp.getData());
			temp2X = temp.getX();
			temp2Y = temp.getY();
			temp.setY(tempY);
			temp.setX(tempX);
			Screen.board2D[temp.getX()][temp.getY()] = temp.getLetter();
			snakeTemp = snakeTemp.getLink();
			if (snakeTemp == null) {
				Screen.board2D[temp2X][temp2Y] = " ";
				Screen.board2D[tempX][tempY] = temp.getLetter();
			}
			tempX = temp2X;
			tempY = temp2Y;
		}
	}
	public static void EatLetter(int direction) {
		Node snakeTemp = snaKe.head;
		String gecici = "";
		SnakePartt temp = (SnakePartt) (snakeTemp.getData());
		if (direction == 0) {
			if (Screen.board2D[temp.getX()][temp.getY() + 1] != "#" && Screen.board2D[temp.getX()][temp.getY() + 1] != " ") {
				gecici = Screen.board2D[temp.getX()][temp.getY() + 1];
				Screen.board2D[temp.getX()][temp.getY() + 1] = " ";
				Snake.Add(temp.getX(), temp.getY() + 1, gecici);
				Screen.ThrowSquareorLetter(1);
				Screen.PlayersScore += 5;
			}
		} else if (direction == 1) {
			if (Screen.board2D[temp.getX() - 1][temp.getY()] != "#" && Screen.board2D[temp.getX() - 1][temp.getY()] != " ") {
				gecici = Screen.board2D[temp.getX() - 1][temp.getY()];
				Screen.board2D[temp.getX() - 1][temp.getY()] = " ";
				Snake.Add(temp.getX() - 1, temp.getY(), gecici);
				Screen.ThrowSquareorLetter(1);
				Screen.PlayersScore += 5;
			}
		} else if (direction == 2) {
			if (Screen.board2D[temp.getX()][temp.getY() - 1] != "#" && Screen.board2D[temp.getX()][temp.getY() - 1] != " ") {
				gecici = Screen.board2D[temp.getX()][temp.getY() - 1];
				Screen.board2D[temp.getX()][temp.getY() - 1] = " ";
				Snake.Add(temp.getX(), temp.getY() - 1, gecici);
				Screen.ThrowSquareorLetter(1);
				Screen.PlayersScore += 5;
			}
		} else {
			if (Screen.board2D[temp.getX() + 1][temp.getY()] != "#" && Screen.board2D[temp.getX() + 1][temp.getY()] != " ") {
				gecici = Screen.board2D[temp.getX() + 1][temp.getY()];
				Screen.board2D[temp.getX() + 1][temp.getY()] = " ";
				Snake.Add(temp.getX() + 1, temp.getY(), gecici);
				Screen.ThrowSquareorLetter(1);
				Screen.PlayersScore += 5;
			}
		}
	}
	public static boolean CheckWall(int direction) {
		Node snakeTemp = snaKe.head;
		SnakePartt temp = (SnakePartt) (snakeTemp.getData());
		if (direction == 0) {
			if (Screen.board2D[temp.getX()][temp.getY() + 1] == "#")
				Screen.GameFinishFlag = false;
		} else if (direction == 1) {
			if (Screen.board2D[temp.getX() - 1][temp.getY()] == "#")
				Screen.GameFinishFlag = false;
		} else if (direction == 2) {
			if (Screen.board2D[temp.getX()][temp.getY() - 1] == "#")
				Screen.GameFinishFlag = false;
		} else {
			if (Screen.board2D[temp.getX() + 1][temp.getY()] == "#")
				Screen.GameFinishFlag = false;
		}
		return Screen.GameFinishFlag;
	}
	public static boolean EatItself(int direction) {
		Node SnakeTemp = snaKe.head;
		SnakePartt Temp = (SnakePartt) (SnakeTemp.getData());
		int TempX = Temp.getX();
		int TempY = Temp.getY();
		int Temp2X, Temp2Y;
		while (SnakeTemp.getLink()!=null) {
			SnakeTemp=SnakeTemp.getLink();
			Temp = (SnakePartt) (SnakeTemp.getData());
			Temp2X=Temp.getX();
			Temp2Y=Temp.getY();
			if (direction == 0&&(TempX==Temp2X&&Temp2Y==TempY+1)) { // right
				return false;
			}else if(direction == 1&&(TempX-1==Temp2X&&Temp2Y==TempY)) { //up
				return false;
			}else if(direction == 2&&(TempX==Temp2X&&Temp2Y==TempY-1)) { //left
				return false;
			}else if(direction == 3&&(TempX+1==Temp2X&&Temp2Y==TempY)) { //down
				return false;
			}
		}
		return true;
	}
	public static SingleLinkedList reverseSnake(SingleLinkedList a) {
		SingleLinkedList b=new SingleLinkedList();
		Node temp=a.head;
		SnakePartt temp2;
		while (temp!=null) {
			temp2=(SnakePartt)temp.getData();
			if(temp2.isFlagFor3Letter()==true) {
			SnakePartt inst=new SnakePartt(temp2.getX(),temp2.getY(),temp2.getLetter());
			b.add(inst);
			temp2.setFlagFor3Letter(false);}
			temp=temp.getLink();
		}
		return b;
	}
	public static String TakePointFromCodon() {
		int point = 0;
		String codon = "";
		PointsSnake=reverseSnake(snaKe);
		Node x = PointsSnake.head;
		Node temp=PointsSnake.Reverse(x);
		SnakePartt temp2=(SnakePartt)temp.getData();
		while (temp != null) {
			temp2=(SnakePartt)temp.getData();
			if(temp2.isFlagFor3Letter()==true) {
			codon += (String) temp2.getLetter();
			temp2.setFlagFor3Letter(false);}
			temp = temp.getLink();
		}
		point = Screen.codonPoints.SearchCodon(codon);
		Screen.PlayersScore+=point;
		PointsSnake = new SingleLinkedList();
		return codon + " - " + point;

	}
	public static boolean SnakeOrNot(int x,int y) {
		Node temp=Snake.snaKe.head;
		SnakePartt temp2=(SnakePartt)temp.getData();
		while (temp!=null) {
			temp2=(SnakePartt)temp.getData();
			if((temp2.getX()==x)&&(temp2.getY()==y))
				return false;
			temp=temp.getLink();
		}
		return true;
	}
}
