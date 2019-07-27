class Ex3_1{
	public static void main(String args[]){
	    int i_arr[];
	    i_arr = new int[5];
	    i_arr[0] = 10;
	    i_arr[1] = 20;
 	    i_arr[2] = 30;
	    i_arr[3] = i_arr[0];
	    i_arr[4] = i_arr[1] + i_arr[2];

            System.out.println("i_arr[0] = " + i_arr[0]);
	    System.out.println("i_arr[1] = " + i_arr[1]);
	    System.out.println("i_arr[2] = " + i_arr[2]);
	    System.out.println("i_arr[3] = " + i_arr[3]);
	    System.out.println("i_arr[4] = " + i_arr[4]);
	}
}