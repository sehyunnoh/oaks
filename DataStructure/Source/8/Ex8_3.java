interface Queue{
	boolean isEmpty();
	void enQueue(char item);
	char deQueue();
	void delete();
	char peek();
}

class QNode{
	char data;
	QNode link;
}

class LinkedQueue implements Queue{
	QNode front;
	QNode rear;
		
	public LinkedQueue(){
		front = null;
		rear = null;		
	}
	
	public boolean isEmpty(){
		return (front == null);
	}
	
	public void enQueue(char item){
		QNode newNode = new QNode();
		newNode.data = item;
		newNode.link = null;
		if(isEmpty()){
			front = newNode;
			rear = newNode;
		}
		else {
			rear.link = newNode;
			rear = newNode;			
		}
		System.out.println("Inserted Item : " + item);
	}
	
	public char deQueue(){
		if(isEmpty()) {
			System.out.println("Deleting fail! Linked Queue is empty!!");
			return 0;
		}
		else{ 
			char item = front.data;
			front = front.link;
			if(front == null)
				rear = null;
			return item;
		}				
	}
	
	public void delete(){
		if(isEmpty()){
			System.out.println("Deleting fail! Linked Queue is empty!!");			
		}
		else {
			front = front.link;
			if(front == null)
				rear = null;
		}
	}
	
	public char peek(){
		if(isEmpty()){
			System.out.println("Peeking fail! Linked Queue is empty!!");
			return 0;
		}
		else 
			return front.data;		
	}
	
	public void printQueue(){
		if(isEmpty())
			System.out.printf("Linked Queue is empty!! %n %n");
		else{
			QNode temp = front;
			System.out.printf("Linked Queue>> ");
			while(temp != null){
				System.out.printf("%c ", temp.data);
				temp = temp.link;
			}
			System.out.println();System.out.println();
		}
	}
}

class Ex8_3{
	public static void main(String args[]){		
		char deletedItem;
		LinkedQueue LQ = new LinkedQueue();
		
		LQ.enQueue('A');
		LQ.printQueue();
		
		LQ.enQueue('B');
		LQ.printQueue();
		
		deletedItem = LQ.deQueue();
		if(deletedItem != 0)
			System.out.println("deleted Item : " + deletedItem);
		LQ.printQueue();
		
		LQ.enQueue('C');
		LQ.printQueue();
		
		deletedItem = LQ.deQueue();
		if(deletedItem != 0)
			System.out.println("deleted Item : " + deletedItem);
		LQ.printQueue();

		deletedItem = LQ.deQueue();
		if(deletedItem != 0)
			System.out.println("deleted Item : " + deletedItem);
		LQ.printQueue();		
		
		deletedItem = LQ.deQueue();
		if(deletedItem != 0)
			System.out.println("deleted Item : " + deletedItem);
		LQ.printQueue();	
	}
}