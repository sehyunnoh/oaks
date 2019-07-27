class Search{	
	public void sequentialSearch1(int a[], int size, int key){		      
		int i=0;
		System.out.printf("\n %d를 순차검색하여라! ->> ", key);
		while(i<size && (a[i]!=key)) i++;
		if(i<size)
			System.out.printf("%d 번째에 검색 성공! \n", i+1);
		else 
			System.out.printf("%d 번째에 검색 실패! \n", i+1);		
	}
	
	public void sequentialSearch2(int a[], int size, int key){		      
		int i=0;
		System.out.printf("\n %d를 순차검색하여라! ->> ", key);
		while(a[i] < key) i++;
		if(a[i] == key)
			System.out.printf("%d 번째에 검색 성공! \n", i+1);
		else 
			System.out.printf("%d 번째에 검색 실패! \n", i+1);		
	}	
}

class Ex12_1{
	public static void main(String args[]){
		int a1[] = {8, 30, 1, 9, 11, 19, 2};
		int size = a1.length;
		Search S = new Search();
		System.out.printf("\n정렬되지 않은 자료에서의 순차검색 >> ");
		S.sequentialSearch1(a1, size, 9);
		S.sequentialSearch1(a1, size, 6);
		
		int a2[] = {1, 2, 8, 9, 11, 19, 29};
		size = a2.length;
		System.out.printf("\n정렬되어 있는 자료에서의 순차검색 >> ");
		S.sequentialSearch2(a2, size, 9);
		S.sequentialSearch2(a2, size, 6);
	}
}
