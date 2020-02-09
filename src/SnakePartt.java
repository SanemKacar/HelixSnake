
public class SnakePartt {
	private int X;
	private int Y;
	private String letter;
	private boolean flagFor3Letter;
	public SnakePartt(int x, int y, String letter) {
		X = x;
		Y = y;
		this.letter = letter;
		flagFor3Letter=true;
	}
	public boolean isFlagFor3Letter() {
		return flagFor3Letter;
	}
	public void setFlagFor3Letter(boolean flagFor3Letter) {
		this.flagFor3Letter = flagFor3Letter;
	}
	public int getX() {
		return X;
	}
	public void setX(int x) {
		X = x;
	}
	public int getY() {
		return Y;
	}
	public void setY(int y) {
		Y = y;
	}
	public String getLetter() {
		return letter;
	}
	public void setLetter(String letter) {
		this.letter = letter;
	}
	
}
