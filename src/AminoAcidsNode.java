
public class AminoAcidsNode {
	private String AminoAcidName;
	private String symbol;
	private AminoAcidsNode down;
	private CodonsNode right;
	
	public AminoAcidsNode(String Name,String sym) {
		AminoAcidName=Name;
		symbol=sym;
		down=null;
		right=null;
	}

	public String getAminoAcidName() {
		return AminoAcidName;
	}

	public void setAminoAcidName(String aminoAcidName) {
		AminoAcidName = aminoAcidName;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public AminoAcidsNode getDown() {
		return down;
	}

	public void setDown(AminoAcidsNode down) {
		this.down = down;
	}

	public CodonsNode getRight() {
		return right;
	}

	public void setRight(CodonsNode right) {
		this.right = right;
	}
}
