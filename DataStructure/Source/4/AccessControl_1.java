class AccessControl_1{
    int num1, num2, sum;
    double ave;
    AccessControl_1(int a, int b){
	this.num1 = a;
	this.num2 = b;
    }
    int getSum(){
 	sum = num1 + num2;
	return sum;
    }
    double getAve(){
	ave = sum/2.0;
	return ave;
    }
}