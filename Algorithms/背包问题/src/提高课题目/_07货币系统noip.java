package ��߿���Ŀ;
import java.util.*;
/**
 * ����ϵͳ����һ������ϵͳ��a1,a2,...an�����ҵ�һ����С��m��ʹ����һ�����ϵͳ��b1,b2,...bm)���������ϵͳ�ȼۣ������໥���Ա����
 * ���⣺���(a1,a2,...an)�ļ����޹���Ļ��ĸ���
 * ��ǰ�᣺dp[i][j]��ʾ��ǰi����ѡ����Ϊj�ķ�����
 * ��������a�������������ж�dp[i-1][a[i]]�Ƿ����0��dp[i-1][a[i]]��ʾ��1~i-1��ѡ���ܹ����a[i]�ķ������������0����ô�����޷��������ô����Ҫ�����ģ�
 * @author ZW
 *
 */
public class _07����ϵͳnoip {
	static  int N = 202;
	static int[] dp = new int[30010];
	static int[] arr = new int[N];
	public static void main(String[] ss) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
			int ans=0;
			Arrays.fill(dp,0);//ǰһ���dp����ź���
			int n = sc.nextInt();
			for(int i=1;i<=n;i++) {
				arr[i] = sc.nextInt();
			}
			
			Arrays.sort(arr,1,n+1);
//			System.out.println(Arrays.toString(arr));
			int m = arr[n];
			dp[0]=1;
			for(int i=1;i<=n;i++) {
			    //���dp[i-1][arr[i]]==0��ʾ��ǰi-1����ѡ����Ϊarr[i]�ķ�����Ϊ0����ô�����޷�����ģ���ô��Ҫ����
				if(dp[arr[i]]==0) ans++; 
				for(int j=arr[i];j<=m;j++) {
					dp[j] += dp[j-arr[i]];
				}
			}
			System.out.println(ans);
		}
	}
}
