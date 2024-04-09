package _01��_�ݹ������;
//AcWing95. �ѽ�Ŀ���
import java.util.*;
public class _04�ѽ�Ŀ��� {
	static int INF = 0x3f3f3f3f;
	static int N = 510;
	static int n,m;
	static int[][] g = new int[7][7],tmp = new int[7][7];
	static int[] dx = {1,0,-1,0,0};
	static int[] dy = {0,1,0,-1,0};
	
	static void turn(int x,int y) {
			for(int i=0;i<5;i++) {//ÿ�ΰ����ؿ��ܻ���������ر�Ӱ��
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(nx>=1 && nx<=5 && ny>=1 && ny<=5) {
					g[nx][ny] ^= 1;
				}
			}

	}
	
	static void solve() {
		int ans = INF;

		//��������g
		for(int i=1;i<=5;i++)
			for(int j=1;j<=5;j++)
				tmp[i][j] = g[i][j];
		//ö�ٵ�һ�е����а���
		for(int k=0;k<32;k++) {//״̬k
			int cnt = 0;
			for(int i=0;i<5;i++)//�ж�ÿһλ�Ƿ�Ҫ��
				if((k>>i&1)==1) {
					cnt++;
					turn(1,i+1);//״̬���Ƕ�Ӧ�ģ����Է���Ҳ��һ����
				}
			//���������������
			for(int i=1;i<=4;i++) {
				for(int j=1;j<=5;j++) {
					if(g[i][j]==0) {
						turn(i+1,j);
						cnt++;
					}
				}
			}
			
			//�ж����һ��
			int flag = 1;
			for(int j=1;j<=5;j++)
				if(g[5][j]==0) {
					flag = 0;
					break;
				}
			if(flag == 1) {
				ans = Math.min(ans, cnt);
			}
			//�ָ�ԭ����g
			for(int a=1;a<=5;a++)
				for(int b=1;b<=5;b++)
					g[a][b] = tmp[a][b];
		}
		if(ans<=6)
			System.out.println(ans);
		else {
			System.out.println(-1);
		}

		
	}
	public static void main(String[] sss) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		while(n-->0) {
			for(int i=1;i<=5;i++) {
				String s = sc.next();
				for(int j=0;j<5;j++)
					g[i][j+1] = s.charAt(j)-'0';
			}
			solve();

		}
	}
}
