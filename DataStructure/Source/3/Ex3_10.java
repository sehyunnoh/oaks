class  Ex3_10{
        public static void main(String args[]){           
 	   Week nowWeek = Week.FRI;
	   switch (nowWeek){
		case MON:
		   System.out.println("������ �������Դϴ�.");
		   break;
		case TUE:
		   System.out.println("������ ȭ�����Դϴ�.");
		   break;
		case WED:
		   System.out.println("������ �������Դϴ�.");
		   break;
		case THU:
		   System.out.println("������ ������Դϴ�.");
		   break;
		case FRI:
		   System.out.println("������ �ݿ����Դϴ�.");
		   break;
		case SAT:
		   System.out.println("������ ������Դϴ�.");
		   break;
		default :
		   System.out.println("������ �Ͽ����Դϴ�.");
           }
        }
}