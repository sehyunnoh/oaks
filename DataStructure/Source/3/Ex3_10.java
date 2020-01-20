class  Ex3_10{
        public static void main(String args[]){           
 	   Week nowWeek = Week.FRI;
	   switch (nowWeek){
		case MON:
		   System.out.println("오늘은 월요일입니다.");
		   break;
		case TUE:
		   System.out.println("오늘은 화요일입니다.");
		   break;
		case WED:
		   System.out.println("오늘은 수요일입니다.");
		   break;
		case THU:
		   System.out.println("오늘은 목요일입니다.");
		   break;
		case FRI:
		   System.out.println("오늘은 금요일입니다.");
		   break;
		case SAT:
		   System.out.println("오늘은 토요일입니다.");
		   break;
		default :
		   System.out.println("오늘은 일요일입니다.");
           }
        }
}