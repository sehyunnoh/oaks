class Search{	
	public void sequentialSearch1(int a[], int size, int key){		      
		int i=0;
		System.out.printf("\n %d�� �����˻��Ͽ���! ->> ", key);
		while(i<size && (a[i]!=key)) i++;
		if(i<size)
			System.out.printf("%d ��°�� �˻� ����! \n", i+1);
		else 
			System.out.printf("%d ��°�� �˻� ����! \n", i+1);		
	}
	
	public void sequentialSearch2(int a[], int size, int key){		      
		int i=0;
		System.out.printf("\n %d�� �����˻��Ͽ���! ->> ", key);
		while(a[i] < key) i++;
		if(a[i] == key)
			System.out.printf("%d ��°�� �˻� ����! \n", i+1);
		else 
			System.out.printf("%d ��°�� �˻� ����! \n", i+1);		
	}	
}

class Ex12_1{
	public static void main(String args[]){
		int a1[] = {8, 30, 1, 9, 11, 19, 2};
		int size = a1.length;
		Search S = new Search();
		System.out.printf("\n���ĵ��� ���� �ڷῡ���� �����˻� >> ");
		S.sequentialSearch1(a1, size, 9);
		S.sequentialSearch1(a1, size, 6);
		
		int a2[] = {1, 2, 8, 9, 11, 19, 29};
		size = a2.length;
		System.out.printf("\n���ĵǾ� �ִ� �ڷῡ���� �����˻� >> ");
		S.sequentialSearch2(a2, size, 9);
		S.sequentialSearch2(a2, size, 6);
	}
}
