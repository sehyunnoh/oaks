class Ex3_16{
        public static void main(String args[]){     
	   System.out.println("- main메소드 시작!");

	   printCh('*', 10);

	   System.out.println("- main메소드 끝!");
       }   

	static void printCh(char ch, int num){
	   System.out.println("- printCh메소드 시작!");
	   for(int i=0; i<num; i++)
		System.out.print(ch);
	   System.out.println();
	   System.out.println("- printCh메소드 끝!");
   	}
}