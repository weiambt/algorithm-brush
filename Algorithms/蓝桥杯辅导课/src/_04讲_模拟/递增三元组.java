package _04��_ģ��;

import java.util.*;

public class ������Ԫ�� {
	static int INF = 0x3f3f3f3f;
	static int N = 1001000,M = 2*N;
	static int n;
	static int[] a = new int[N];
	static int[] b = new int[N];
	static int[] c = new int[N];
	static long[] sum = new long[N];
	
	//�ҵ���һ��
	static int upperBound(int[] nums,int l,int r,int x) {
		while(l<r) {
			int mid = l+r>>1;
			if(nums[mid]>x) r=mid;
			else l = mid +1;
		}
		return l;
	}
	static int lowerBound(int[] nums,int l,int r,int x) {
		while(l<r) {
			int mid = l+r>>1;
			if(nums[mid]>=x) r=mid;
			else l = mid +1;
		}
		return l;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for(int i=1;i<=n;i++)
			a[i] = sc.nextInt();
		for(int i=1;i<=n;i++)
			b[i] = sc.nextInt();
		for(int i=1;i<=n;i++)
			c[i] = sc.nextInt();
		//˼·��
		//B��C��������
		//1.����ÿһ��Bi����C�б�Bi������ĸ���(����)������ǰ׺�� nlogn
		//2.ö��A������ÿһ��Ai�����ֲ���B�е�һ����Ai��������±�idx���Ӷ�ans += sum[n]-sum[idx-1]
		
		Arrays.sort(b,1,n+1);
		Arrays.sort(c,1,n+1);
		long ans = 0;
		for(int i=1;i<=n;i++) {
			int idx = upperBound(c,1,n,b[i]);
			if(c[idx]>b[i])
				sum[i] = sum[i-1] + n-idx+1;
			else sum[i] = sum[i-1];
		}
		
		for(int i=1;i<=n;i++){
			int idx = upperBound(b, 1, n, a[i]);
			if(b[idx]>a[i])
				ans += sum[n] - sum[idx-1];
		}
		System.out.println(ans);
		
		int lowerBound = lowerBound(a, 1, n, 4);
		System.out.println(lowerBound);
	}
}
