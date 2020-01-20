class AccessControl_3{
    private int num1, num2, sum;
    private double ave;
    AccessControl_3(int a, int b){
	this.num1 = a;
	this.num2 = b;
    }
    private int getSum(){
 	sum = num1 + num2;
	return sum;
    }
    private double getAve(){
	ave = sum/2;
	return ave;
    }
}