class AccessControl_2{
    private int num1, num2, sum;
    private double ave;
    AccessControl_2(int a, int b){
	this.num1 = a;
	this.num2 = b;
    }
    public int getSum(){
 	sum = num1 + num2;
	return sum;
    }
    public double getAve(){
	ave = sum/2.0;
	return ave;
    }
}