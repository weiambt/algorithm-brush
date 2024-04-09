package ��߿���Ŀ;
import java.util.*;

public class _04������� {
	static int N = 110;
	static int M = 10100;
	static int[] arr = new int[N];
	static int[][] dp = new int[N][M];
	//dp[j]��ʾǰi����ѡ����Ϊj�ķ�����
	//dp[i][j] = dp[i-1][j] + dp[i-1][j-arr[i]]
	static int n,m;
	public static void main(String[] sss) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		for(int i=1;i<=n;i++) 
			arr[i]=sc.nextInt();
		
		//dp��ʼ����ǰi����ѡ��Ϊ0�ķ�������1���൱��arr[i]==jʱans++��
		for(int i=0;i<=n;i++) dp[i][0]=1;
		
		for(int i=1;i<=n;i++) {
			for(int j=0;j<=m;j++) {
				dp[i][j]=dp[i-1][j];
//				if(arr[i]==j)
//					dp[i][j]++;
				if(j>=arr[i])
					dp[i][j]+=dp[i-1][j-arr[i]];
//				System.out.println(i+" "+j+" "+dp[i][j]);
			}
		}

		System.out.println(dp[n][m]);
		
	}
}
