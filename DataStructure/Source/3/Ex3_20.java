class Ex3_20{
        public static void main(String args[]){     
	   int a=10, b=0, result;
	   try {
		result = a/b;
		System.out.println(result);	
	   }
	   catch (java.lang.ArithmeticException  exp) {
		System.out.println("�߸��� ��������Դϴ�!");
	   }
	   finally {
		System.out.println("���� ��..");
	   }
       }   
}