
public class DoubleLinkedList {

	public NodeDouble head;
	private NodeDouble tail;

	public DoubleLinkedList() {
		head = null;
		tail = null;
	}
	public void Add(Score inst) {
		NodeDouble newNode=new NodeDouble(inst);
		int Score=inst.getScore();
		if(head==null&&tail==null) {
			head=newNode;
			tail=newNode;
		}
		else {
			NodeDouble temp=Screen.scoreTable.head;
			Score realTemp=(Score) temp.getData();
			if(Score>=realTemp.getScore()) {
				head.setPrev(newNode);
				newNode.setNext(head);
				head=newNode;
			}else {
				while (temp.getNext()!=null&&Score<realTemp.getScore()) {
					temp=temp.getNext();	
					realTemp=(Score) temp.getData();
				}
				if(temp.getNext()==null&&Score<realTemp.getScore()) {
					newNode.setPrev(temp);
					temp.setNext(newNode);
				}else {
					temp.getPrev().setNext(newNode);
					newNode.setPrev(temp.getPrev());
					newNode.setNext(temp);
					temp.setPrev(newNode);
				}
			}
		}
	}
	public static String printL(DoubleLinkedList a) {
		NodeDouble temp=a.head;
		String gecici="";
		Score RealTemp=(Score)temp.getData();
		while (temp!=null) {
			RealTemp=(Score)temp.getData();
			gecici+=" Name: "+RealTemp.getName()+"  Score: "+RealTemp.getScore();
			temp=temp.getNext();
		}
		return gecici;
	}
	public int size() {
		int count = 0;
		if (head != null) {
			NodeDouble temp = head;
			while (temp != null) {
				count++;
				temp = temp.getNext();
			}
		}
		return count;
	}

}