
public class MultiLinkedList {
	AminoAcidsNode head;

	public void AddAminoAcid(String name, String symbol) {
		if (head == null) {
			AminoAcidsNode newNode = new AminoAcidsNode(name, symbol);
			head = newNode;
		} else {
			AminoAcidsNode temp = head;
			while (temp.getDown() != null) {
				temp = temp.getDown();
			}
			AminoAcidsNode newNode = new AminoAcidsNode(name, symbol);
			temp.setDown(newNode);
		}
	}

	public void AddCodonsNode(String AminoAcidSymbol, String data) {
		if (head != null) {
			AminoAcidsNode temp = head;
			while (temp != null) {
				if (AminoAcidSymbol.equals(temp.getSymbol())) {
					CodonsNode temp2 = temp.getRight();
					if (temp2 == null) {
						CodonsNode newNode = new CodonsNode(data);
						temp.setRight(newNode);
					} else {
						while (temp2.getNext() != null) {
							temp2 = temp2.getNext();
						}
						CodonsNode newNode = new CodonsNode(data);
						temp2.setNext(newNode);
					}
				}
				temp = temp.getDown();
			}
		}
	}

	public int AminoAcidsSize() {
		int count = 0;
		if (head != null) {
			AminoAcidsNode temp = head;
			while (temp != null) {
				count++;
				temp = temp.getDown();
			}
		}
		return count;
	}

	public int CodonsSize() {
		int count = 0;
		if (head != null) {
			AminoAcidsNode temp = head;
			while (temp != null) {
				CodonsNode temp2 = temp.getRight();
				while (temp2 != null) {
					count++;
					temp2 = temp2.getNext();
				}
				temp = temp.getDown();
			}
		}
		return count;
	}

	public String Display() {
		String gecici = "";
		if (head != null) {
			AminoAcidsNode temp = head;
			while (temp != null) {
				gecici += temp.getAminoAcidName() + "--->";
				CodonsNode temp2 = temp.getRight();
				while (temp2 != null) {
					gecici += temp2.getAminoAcidsName() + " point= " + temp2.getPoint() + "\n";
					temp2 = temp2.getNext();
				}
				gecici += "\n";
				temp = temp.getDown();

			}
		}
		return gecici;
	}

	public int SearchCodon(String codon) {
		if (head != null) {
			AminoAcidsNode temp = head;
			while (temp != null) {
				CodonsNode temp2 = temp.getRight();
				while (temp2 != null) {
					if (temp2.getAminoAcidsName().equals(codon)) {
						return temp2.getPoint();
					}
					temp2=temp2.getNext();
				}
				temp=temp.getDown();
			}
		}return 0;
	}
}
