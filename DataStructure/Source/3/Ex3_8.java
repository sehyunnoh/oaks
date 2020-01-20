class  Point{
	int x, y;
	Point(int x, int y){
	   this.x = x;
	   this.y = y;
        }
}

class Ex3_8{
	public static void main(String args[]){
	    int i = 100;
	    int j = i;
	    System.out.printf("i = (%d) %n", i);
	    System.out.printf("j = (%d) %n", j);

	    Point p1 = new  Point(10, 20);
	    Point p2 = p1;
       	    System.out.printf("p1 = (%d, %d) %n", p1.x, p1.y);
	    System.out.printf("p2 = (%d, %d) %n", p2.x, p2.y);

	    i = 300;
	    System.out.printf("i = (%d) %n", i);
	    System.out.printf("j = (%d) %n", j);

            p1.x = 30;
            System.out.printf("p1 = (%d, %d) %n", p1.x, p1.y);
	    System.out.printf("p2 = (%d, %d) %n", p2.x, p2.y);
       }
}