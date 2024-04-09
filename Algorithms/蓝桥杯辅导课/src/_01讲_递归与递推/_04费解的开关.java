package _01讲_递归与递推;
//AcWing95. 费解的开关
import java.util.*;
public class _04费解的开关 {
	static int INF = 0x3f3f3f3f;
	static int N = 510;
	static int n,m;
	static int[][] g = new int[7][7],tmp = new int[7][7];
	static int[] dx = {1,0,-1,0,0};
	static int[] dy = {0,1,0,-1,0};
	
	static void turn(int x,int y) {
			for(int i=0;i<5;i++) {//每次按开关可能会有五个开关被影响
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(nx>=1 && nx<=5 && ny>=1 && ny<=5) {
					g[nx][ny] ^= 1;
				}
			}

	}
	
	static void solve() {
		int ans = INF;

		//拷贝数组g
		for(int i=1;i<=5;i++)
			for(int j=1;j<=5;j++)
				tmp[i][j] = g[i][j];
		//枚举第一行的所有按法
		for(int k=0;k<32;k++) {//状态k
			int cnt = 0;
			for(int i=0;i<5;i++)//判断每一位是否要按
				if((k>>i&1)==1) {
					cnt++;
					turn(1,i+1);//状态不是对应的，所以反着也是一样的
				}
			//递推下面的所有行
			for(int i=1;i<=4;i++) {
				for(int j=1;j<=5;j++) {
					if(g[i][j]==0) {
						turn(i+1,j);
						cnt++;
					}
				}
			}
			
			//判断最后一行
			int flag = 1;
			for(int j=1;j<=5;j++)
				if(g[5][j]==0) {
					flag = 0;
					break;
				}
			if(flag == 1) {
				ans = Math.min(ans, cnt);
			}
			//恢复原数组g
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
