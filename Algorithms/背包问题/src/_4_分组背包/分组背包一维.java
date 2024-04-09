package _4_���鱳��;
import java.util.*;
/**
 * ���鱳��������һ���Ƚϴ�����⣬ֻ������ѭ���������ر����Ƿ��鱳�������������
 * @author ZW
 *
 */
public class ���鱳��һά {
	static int N = 110;
	static int[][] v = new int[N][N];
	static int[][] w = new int[N][N];
	static int[] count = new int[N];//��i���м���
	static int[] dp = new int[N];
	static int n,m;
	
	public static void main(String[] sss) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		for(int i=1;i<=n;i++) {
			count[i] = sc.nextInt();
			for(int j=1;j<=count[i];j++) {
				v[i][j] = sc.nextInt();
				w[i][j] = sc.nextInt();
			}	
		}
		
		for(int i=1;i<=n;i++) {
			for(int j=m;j>0;j--) {
				for(int k=1;k<=count[i];k++) {
					if(j>=v[i][k])
						dp[j]=Math.max(dp[j], dp[j-v[i][k]]+w[i][k]);
				}
			}
		}
		System.out.println(dp[m]);
			
		
	}
}
