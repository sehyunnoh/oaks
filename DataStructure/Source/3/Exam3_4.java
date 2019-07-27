class  Exam3_4{	
      public static void main(String srgs[]){
	  PointXY p1 = new PointXY(100, 100);
	  System.out.println("x:" + p1.x + ", y:" + p1.y);

	  p1.setX(200);	  
	  System.out.println("x:" + p1.x + ", y:" + p1.y);
	
	  p1.setY(300);	  
	  System.out.println("x:" + p1.x + ", y:" + p1.y);

	  p1.moveXY(50, 50);	  
	  System.out.println("x:" + p1.x + ", y:" + p1.y);        
	}
}