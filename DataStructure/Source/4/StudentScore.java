class StudentScore  extends StudentInfo{
    private int kor, eng, math, sum;
    private double ave;
    StudentScore(String dept, String stdNo, String name,
                 int kor, int eng, int math){
	super(dept, stdNo, name);
	this.kor = kor;
	this.eng = eng;
	this.math = math;
	this.sum = 0;
	this.ave = 0.0;
    }
   public int getSum(){
	sum = kor + eng + math;
	return sum;
   }	
   public double getAve(){
	ave = sum/3.0;
	return ave;
   }
   public void getStdInfo(){
	super.getStdInfo();
   }
   public void getStdScore(){
	System.out.println("** �л� ���� ��� **");
	System.out.println("���� : " + kor);
	System.out.println("���� : " + eng);
	System.out.println("���� : " + math);
	System.out.println("���� : " + getSum());
	System.out.println("��� : " + getAve());
   }
}