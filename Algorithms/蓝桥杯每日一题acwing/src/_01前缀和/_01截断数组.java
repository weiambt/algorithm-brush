package _01ǰ׺��;
import java.util.*;
import java.math.*;
import java.io.*;

public class _01�ض����� {
	static int INF = 0x3f3f3f3f;
	static int N = 101000 , M = 2*N;
	static int[] sum = new int[N];
	static int n,m;

	public static void main(String[] sss) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for(int i=1;i<=n;i++) 
			sum[i]=sum[i-1] + sc.nextInt();
		//���ÿ�������������������ö�����������
//		int ans=0;
//		for(int i=2;i<=n-1;i++) {
//			int s = sum[i-1];
//			int l = i,r = n;
//			while(l<r) {
//				int mid = l+r>>1;
//				if(sum[mid-1]-s >= sum[n] - sum[mid-1])
//					r = mid;
//				else l = mid + 1;
//			}
//			
//			if(sum[l-1]-s == sum[n] - sum[l-1] && sum[l-1]-s == s)
//				ans++;
//		}
		if(sum[n]%3!=0) {
			System.out.println(0);
			return ;
		}
		int avg = sum[n]/3;//��ֵ
		int ans = 0;
		int cnt = 0;//������¼ǰi-1���ж��ٸ�k����sum[1~k] == avg/3;
		for(int i=1;i<=n;i++) {//iö���ҵ�����sum[1~i]==2*avg��;
			if(sum[i] == 2*avg) {
				ans += cnt;
			}
			if(sum[i]==avg) cnt++;
			
		}
		
		
		System.out.println(ans);
	}
}
