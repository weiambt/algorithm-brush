package 例题;

import java.util.*;
import java.math.*;
import java.io.*;

public class sort {
		static int INF = 1000000007;
		static int N = 101000 , M = 2*N;
		static int n,m,k;
		static int[] a = new int[N];
		
		public static void main(String[] sss) {
			Scanner sc = new Scanner(System.in);
			n = sc.nextInt();
			for(int i=1;i<=n;i++)
				a[i] = sc.nextInt();
//			mergeSort(a, 1, n);
//			for(int i=1;i<=n;i++)
//				System.out.print(a[i]+" ");
			
			System.out.println(getNixudui(a, 1, n));
			
//			n = sc.nextInt();
//			k = sc.nextInt();
//			for(int i=1;i<=n;i++)
//				a[i] = sc.nextInt();
//			int ans = findTopK(a, 1, n, k);
//			System.out.println(ans);
		}
		static void quickSort(int[] arr,int l,int r) {
			if(l>=r) return ;
			int x = arr[l],i = l-1,j = r+1;
			while(i<j) {
				while(arr[++i] < x);
				while(arr[--j] > x);
				if(i<j) {
					int t = arr[i];
					arr[i] = arr[j];
					arr[j] = t;
				}
			}
			quickSort(arr, l, j);
			quickSort(arr, j+1, r);
		}
		
		static int findTopK(int[] arr,int l,int r,int k) {
			if(l>=r) return arr[l];
			int x = arr[l],i = l-1,j = r+1;
			while(i<j) {
				while(arr[++i] < x);
				while(arr[--j] > x);
				if(i<j) {
					int t = arr[i];
					arr[i] = arr[j];
					arr[j] = t;
				}
			}
			int newK = j-l+1;
			if(k<=newK)
				return findTopK(arr, l, j,k);
			else 
				return findTopK(arr, j+1, r,k-newK);
		}
		static int[] tmp = new int[N];
		static void mergeSort(int[] a,int l,int r) {
			if(l>=r) return;
			int mid = l + r>>1;
			mergeSort(a, l, mid);
			mergeSort(a, mid+1, r);
			int k=0;//临时数组tmp的下标计数
			int i=l,j=mid+1;
			while(i<=mid && j<=r) {
				if(a[i]<=a[j]) tmp[k++] = a[i++];
				else tmp[k++] = a[j++];
			}
			while(i<=mid) tmp[k++] = a[i++];
			while(j<=mid) tmp[k++] = a[j++];
			
			for(i=l,j=0;i<=r && j<k;i++,j++) {
				a[i] = tmp[j];
			}
		}
		
		static long getNixudui(int[] q,int l,int r) {
			if(l>=r) return 0;
			int mid = l+r>>1;
			long res = getNixudui(q, l, mid) + getNixudui(q, mid+1, r);
			
			int i = l, j = mid+1;
			int k = 0;
			while(i<=mid && j<=r) {
				if(q[i]<=q[j]) tmp[k++] = q[i++];
				else {
					res += mid - i +1;//当前j的逆序对的个数
					tmp[k++] = q[j++];
				}
			}
			while(i<=mid) tmp[k++] = q[i++];
			while(j<=r) tmp[k++] = q[j++];
			for(i = l,j = 0;i<=r;i++,j++)
				q[i] = tmp[j];
			return res;
		}
}
