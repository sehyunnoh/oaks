class  StudentInfo{
   protected  String dept, stdNo, name;
   StudentInfo(String dept, String stdNo, String name){
	this.dept = dept;
	this.stdNo = stdNo;
	this.name = name;
   }
   public void getStdInfo(){
	System.out.println("** �л� ���� ��� **");
	System.out.println("�а� : " + dept);
	System.out.println("�й� : " + stdNo);
	System.out.println("�̸� : " + name);
   }
}