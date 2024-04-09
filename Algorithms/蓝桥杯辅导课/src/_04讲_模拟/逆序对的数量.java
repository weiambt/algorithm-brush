package _04讲_模拟;

import java.util.*;

public class 逆序对的数量 {
	static int INF = 0x3f3f3f3f;
	static int N = 101000,M = 2*N;
	static int n,ans;
	static int[] arr = new int[N];
	static int[] tmp = new int[N];
	static void mergeSort(int l,int r) {
		if(l>=r) return ;
		
		int mid = l+r>>1;
		mergeSort(l, mid);
		mergeSort(mid+1, r);
		int i=l,j = mid+1,k=0;
		while(i<=mid && j<=r) {
			if(arr[i]<=arr[j])
				tmp[k++] = arr[i++];
			else {
				ans += mid-i+1;
				tmp[k++] = arr[j++];
			}
		}
		while(i<=mid)
			tmp[k++] = arr[i++];
		while(j<=r)
			tmp[k++] = arr[j++];
		
		for(i=l,j=0;i<=r;i++,j++) {
			arr[i] = tmp[j];
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for(int i=1;i<=n;i++)
			arr[i] = sc.nextInt();
		
		mergeSort(1,n);
		
//		for(int i=1;i<=n;i++)
// 			System.out.print(arr[i]+" ");
		
		System.out.println(ans);
	}
}
