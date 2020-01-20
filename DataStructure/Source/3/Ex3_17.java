class Ex3_17{
        public static void main(String args[]){     
	   System.out.println("- main메소드 시작!");
	   int cnt;
	   cnt = printCh('*', 10);
	   System.out.println("문자 " + cnt + "개 출력완료.");
	   System.out.println("- main메소드 끝!");
       }   

	static int printCh(char ch, int num){
	   System.out.println("- printCh메소드 시작!");
	   int i;
	   for(i=0; i<num; i++)
		System.out.print(ch);
	   System.out.println();
	   System.out.println("- printCh메소드 끝!");

	   return i;
   	}
}