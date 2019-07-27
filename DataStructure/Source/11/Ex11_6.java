class Sort{
	private int sorted[] = new int [30];
	
	public void merge(int a[], int m, int middle, int n){
		int size = a.length;
		int  i, j, k, t;
		i = m;
		j = middle+1;
		k = m;
		while(i<=middle && j<=n){
			if(a[i] <= a[j])  sorted[k] = a[i++];
			else  sorted[k] = a[j++];
			k++;
		}
		if(i>middle){
			for(t=j; t<=n; t++, k++) 
				sorted[k] = a[t];
		}
		else{
			for(t=i; t<=middle; t++, k++) 
				sorted[k] = a[t];
		}
		
		for(t=m; t<=n; t++)
			a[t] = sorted[t];
		System.out.printf("\n 병합 정렬 >> ");
		for(t=0; t<size; t++) 
			System.out.printf("%3d ", a[t]);
	}
		
	public void mergeSort(int a[], int m, int n)	{
		int middle;
		if(m<n){
			middle = (m+n)/2;
			mergeSort(a, m, middle);
			mergeSort(a, middle+1, n);
			merge(a, m, middle, n);
		}
	}		
 }

class Ex11_6{
	public static void main(String args[]){
		int a[] = {69, 10, 30, 2, 16, 8, 31, 22};
		int size = a.length;
		Sort S = new Sort();
		System.out.printf("\n정렬할 원소 : ");
		for(int i=0; i<a.length; i++)
			System.out.printf(" %d", a[i]);
		System.out.println();
		S.mergeSort(a, 0, size-1);
	}
}