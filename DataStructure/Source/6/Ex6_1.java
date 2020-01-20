public class Ex6_1{
	public static void main(String args[]){
		LinkedList L = new LinkedList();
		System.out.println("(1) ���� ����Ʈ�� ��� 3�� �����ϱ�");
		L.insertLastNode("��");
		L.insertLastNode("��");
		L.insertLastNode("��");
		L.printList();

		System.out.println("(2) �� ��� �ڿ� �� ��� �����ϱ�");
		ListNode pre = L.searchNode("��");
		if(pre == null) 
			System.out.println("�˻�����>> ã�� �����Ͱ� �����ϴ�.");
		else{
			L.insertMiddleNode(pre, "��");
			L.printList();
		}

		System.out.println("(3) ����Ʈ�� ��带 �������� �ٲٱ�");
		L.reverseList();
		L.printList();

		System.out.println("(4) ����Ʈ�� ������ ��� �����ϱ�");      
		L.deleteLastNode();
		L.printList();
	}
}

class LinkedList{
	private ListNode head;
	public LinkedList(){
		head = null;
	}
	public void insertMiddleNode(ListNode pre, String data){       
		ListNode newNode = new ListNode(data);
		newNode.link = pre.link;
		pre.link = newNode;
	}
	public void insertLastNode(String data){
		ListNode newNode = new ListNode(data);
		if(head == null){
			this.head = newNode;
		}
		else{
			ListNode temp = head;
			while(temp.link != null) temp = temp.link;
			temp.link = newNode;
		}
	}
	public void deleteLastNode(){
		ListNode pre, temp;
		if(head == null)  return;
		if(head.link == null){
			head = null;
		}
		else{
			pre = head;
			temp = head.link;
			while(temp.link != null){
				pre = temp;
				temp = temp.link;
			}
			pre.link = null;
		}
	}
	public ListNode searchNode(String data){
		ListNode temp = this.head;
		while(temp != null){
			if(data == temp.getData())  
				return temp;
			else temp = temp.link;
		}
		return  temp;
	}
	public void reverseList(){
		ListNode next = head;
		ListNode current = null;
		ListNode pre = null;
		while(next != null){
			pre = current;
			current = next;
			next = next.link;
			current.link = pre;
		}
		head = current;
	}
	public void printList(){
		ListNode temp = this.head;
		System.out.printf("L = (");
		while(temp != null){
			System.out.printf(temp.getData());
			temp = temp.link;
			if(temp != null){
				System.out.printf(", ");
			}			
		}
		System.out.println(")");
	}
}

class ListNode{
	private String data;
	public ListNode link;
	public ListNode(){
		this.data = null;
		this.link = null;
	}
	public ListNode(String data){
		this.data = data;
		this.link = null;
	}
	public ListNode(String data, ListNode link){
		this.data = data;
		this.link = link;
	}
	public String getData(){
		return  this.data;
	}
}