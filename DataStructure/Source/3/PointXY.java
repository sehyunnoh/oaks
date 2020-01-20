class  PointXY{
	int x, y;
	PointXY(int x, int y){   // 持失切 五社球
	   this.x = x;
	   this.y = y;
        }
        void setX(int x){
           this.x = x;
	}
	void setY(int y){
           this.y = y;
	}
	void moveXY(int x, int y){
	   this.x += x;
	   this.y += y;
	}
}