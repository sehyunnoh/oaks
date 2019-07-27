class  Exam3_3{	
      public static void main(String srgs[]){
	  for(int i=1; i<=5; i++){
	     for(int x=1; x<=5-i; x++)
		System.out.print(' ');
	     for(int j=1; j<=i; j++)
		System.out.print('*');
	     for(int x=1; x<=i-1; x++)
		System.out.print('*');
	     System.out.println();
           }
	}
}