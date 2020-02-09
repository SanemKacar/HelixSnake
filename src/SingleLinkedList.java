
public class SingleLinkedList {
	public Node head;

	public SingleLinkedList() {
		head = null;
	}

	public void addFront(Object data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
		} else {
			Node temp = head;
			head = newNode;
			head.setLink(temp);
		}
	}

	public void add(Object data) {
		Node inputNode = new Node(data);
		if (head == null) {
			head = inputNode;
		} else {
			Node temp = head;
			while (temp.getLink() != null) {
				temp = temp.getLink();
			}
			temp.setLink(inputNode);
		}
	}

	public String Display() {
		String output = "";
		Node temp = head;
		while (temp != null) {
			output += temp.getData() + " ";
			temp = temp.getLink();
		}
		return output;
	}

	public int Size() {
		Node temp = head;
		int counter = 0;
		while (temp != null) {
			counter++;
			temp = temp.getLink();
		}
		return counter;
	}

	public int Search(Object data) {
		Node temp = head;
		int count = 0;
		while (temp != null) {
			if ((int) data == (int) temp.getData())
				count++;
			temp = temp.getLink();
		}
		return count;
	}

	public boolean search(Object data) {
		if (head == null) {
			return false;
		} else {
			Node temp = head;

			boolean retVal = false;
			while (temp != null) {
				if ((int) temp.getData() == (int) data) {
					retVal = true;
					break;
				}

				temp = temp.getLink();
			}

			return retVal;
		}
	}

	public void deleteFront() {
		if (head != null)
			head = head.getLink();
	}
	public void DeleteLastThree() {  //snake will be reverse so from original snake this temporary delete last 3 element
		for (int i = 0; i < 3; i++) {
			Node temp=head;
			while (temp.getLink()!=null) {
				temp=temp.getLink();
			}
			temp=null;
		}
	}
	public void Delete(Object data) {
		if (head.getLink() != null && head != null) {
			while ((int) head.getData() == (int) data) {
				if (head.getLink() != null)
					head = head.getLink();
				else {
					head = null;
					break;
				}
			}
			Node temp = head;
			Node prev = null;
			while (temp != null) {
				if ((int) temp.getData() == (int) data) {
					prev.setLink(temp.getLink());
					temp = temp.getLink();
				} else {
					prev = temp;
					temp = temp.getLink();
				}
			}
		} else {
			if ((int) (head.getData()) == (int) data) {
				head = null;
			}
		}
	}
	public Node Reverse(Node node) {
		Node prev=null;
		Node next=null;
		Node curr=head;
		while (curr!=null) {
			next=curr.getLink();
			curr.setLink(prev);
			prev=curr;
			curr=next;
		}
		node=prev;
		return node;
		
	}
	public Object GetFromList(Node head, int n) {
		int count = 1;

		// if count equal too n return node.data
		if (count == n)
			return (Object) head.getData();

		// recursively decrease n and increase
		// head to next pointer
		return GetFromList(head.getLink(), n - 1);
	}
/*
	public static SingleLinkedList reverseSnake(SingleLinkedList a) {
		Node temp;
		SingleLinkedList TEMP=new SingleLinkedList();
		SnakePartt af;
		for (int i = 0; i < a.Size(); i++) {
			temp = a.head;
			af=(SnakePartt)temp.getData();
			for (int j = a.Size()-1; j > 0; j--) {
				temp = temp.getLink();
			}
			TEMP.addFront(temp.getData());
		}
		return TEMP;
	}*/
}
