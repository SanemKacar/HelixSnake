
public class CodonsNode {
	private String aminoAcidsName;
	private int point;
	private CodonsNode next;
	
	public CodonsNode(String data) {
		String [] temp=data.split("-",-1);
		aminoAcidsName=(String) temp[0];
		point=Integer.parseInt(temp[1]);
		next=null;
	}
	
	public String getAminoAcidsName() {
		return aminoAcidsName;
	}

	public void setAminoAcidsName(String aminoAcidsName) {
		this.aminoAcidsName = aminoAcidsName;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public CodonsNode getNext() {
		return next;
	}

	public void setNext(CodonsNode next) {
		this.next = next;
	}
}
