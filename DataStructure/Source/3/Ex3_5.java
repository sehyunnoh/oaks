class  Triangle  implements Shape{
	int x, y;
	double area;
	Triangle(int x, int y){
	   this.x = x;
	   this.y = y;
        }
        public void getArea(){
	   this.area = this.x * this.y * 0.5;
	}
}

class  Rectangle  implements Shape{
	int x, y;
	double area;
	Rectangle(int x, int y){
	   this.x = x;
	   this.y = y;
        }
        public void getArea(){
	   this.area = this.x * this.y;
	}
}