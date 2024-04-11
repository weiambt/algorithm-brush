package _00Ä£°å;

public class MergeSort {
	static int N = 100;
	static int[] arr = new int[N];
	
	static void mergeSort(int l,int r) {
		if(l==r) return;
		int mid = l+r>>1;
		mergeSort(l, mid);
		mergeSort(mid+1, r);
		int i = l,j = mid+1,k=0;
		int[] tmp = new int[N];
		while(i<=mid && j<=r) {
			if(arr[i]<=arr[j]) {
				tmp[k++] = arr[i++];
			}else 
				tmp[k++] = arr[j++];
		}
		while(i<=mid)
			tmp[k++] = arr[i++];
		while(j<=r)
			tmp[k++] = arr[j++];
		for(int ii=l,kk=0;ii<=r;ii++) {
			arr[ii] = tmp[kk++];
		}
	}
	
	static long getNixushu(int l,int r) {
		if(l==r) return 0;
		long s = 0;
		int mid = l+r>>1;
		s += getNixushu(l, mid);
		s += getNixushu(mid+1, r);
		
		int i = l,j = mid+1,k=0;
		int[] tmp = new int[N];
		while(i<=mid && j<=r) {
			if(arr[i]<=arr[j]) {
				tmp[k++] = arr[i++];
			}else {
				tmp[k++] = arr[j++];
				s += mid-i+1;
			}
		}
		while(i<=mid)
			tmp[k++] = arr[i++];
		while(j<=r)
			tmp[k++] = arr[j++];
		for(int ii=l,kk=0;ii<=r;ii++) {
			arr[ii] = tmp[kk++];
		}
		return s;
	}
	public static void main(String[] args) {
		for(int i=1;i<=10;i++)
			arr[i] = 10-i;
		mergeSort(1, 10);
		for(int i=1;i<=10;i++)
			System.out.println(arr[i]);
	}
}
