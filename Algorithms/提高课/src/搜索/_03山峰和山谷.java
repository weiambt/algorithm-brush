package 搜索;
import java.util.*;
import java.math.*;
import java.io.*;
public class _03山峰和山谷 {
	static int INF = 0x3f3f3f3f;
	static int N = 1010 , M = 2*N;
	static int[][] arr = new int[N][N];
	static int[][] st = new int[N][N];
	static int n,m;
	static long top,bottom;
	
	static void bfs(int sx,int sy) {
		Queue<PII> q = new LinkedList<PII>();
		Queue<PII> next = new LinkedList<PII>();//用来存储当前连通块的所有相邻的不相等邻接块
		q.add(new PII(sx,sy));
		st[sx][sy] = 1;
		
		while(q.size()>0) {
			PII top = q.poll();
			int x = top.x;
			int y = top.y;
			for(int i=x-1;i<=x+1;i++) {
				for(int j=y-1;j<=y+1;j++) {
					if(i==x && j==y) continue;
					if(!(i>=0 &&i<n && j>=0 &&j<n)) continue;
					//统计下一层不相等的区域
					if(arr[i][j]!=arr[x][y]) {
						next.add(new PII(i,j));
						continue;
					}
                    //先统计不相等的位置，再判断是否已经被标记过，因为不相等的邻接块可能已经被标记过了
					if(st[i][j]==1) continue;
//					System.out.println(i+" "+j+" "+arr[i][j]);
					q.add(new PII(i,j));
					st[i][j] = 1;
					
				}
			}
			
		}
		//如果所有格子都有相同的高度
		if(next.size()==0) {
			top=1;bottom=1;
			return;
		}
		int flag = 0;//flag=1表示山顶，flag=2表示山谷
		while(next.size()>0) {
			PII top = next.poll();
//			System.out.print(arr[top.x][top.y]+" ");
			if(flag!=0) {//如果不满足山峰/山谷的条件，就退出
				if(flag==1 && arr[sx][sy]<arr[top.x][top.y])
					return;
				if(flag==2 && arr[sx][sy]>arr[top.x][top.y])
					return;
			}
			if(arr[sx][sy]>arr[top.x][top.y])
				flag = 1;
			else flag = 2;
		}
		if(flag==1) top++;
		else bottom++;
				
	}

	public static void main(String[] sss) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++)
				arr[i][j] = sc.nextInt();
		}
		
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++) {
				if(st[i][j]==0) {
					bfs(i,j);
//					System.out.println();
				}
			}
		System.out.println(top+" "+bottom);

	}
}
//class PII{
//	int x,y;
//	public PII(int x,int y) {
//		// TODO Auto-generated constructor stub
//		this.x = x;
//		this.y = y;
//	}
//}
