class Ex3_17{
        public static void main(String args[]){     
	   System.out.println("- main�޼ҵ� ����!");
	   int cnt;
	   cnt = printCh('*', 10);
	   System.out.println("���� " + cnt + "�� ��¿Ϸ�.");
	   System.out.println("- main�޼ҵ� ��!");
       }   

	static int printCh(char ch, int num){
	   System.out.println("- printCh�޼ҵ� ����!");
	   int i;
	   for(i=0; i<num; i++)
		System.out.print(ch);
	   System.out.println();
	   System.out.println("- printCh�޼ҵ� ��!");

	   return i;
   	}
}