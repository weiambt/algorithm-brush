package ����;
import java.util.*;
import java.math.*;
import java.io.*;
public class _03ɽ���ɽ�� {
	static int INF = 0x3f3f3f3f;
	static int N = 1010 , M = 2*N;
	static int[][] arr = new int[N][N];
	static int[][] st = new int[N][N];
	static int n,m;
	static long top,bottom;
	
	static void bfs(int sx,int sy) {
		Queue<PII> q = new LinkedList<PII>();
		Queue<PII> next = new LinkedList<PII>();//�����洢��ǰ��ͨ����������ڵĲ�����ڽӿ�
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
					//ͳ����һ�㲻��ȵ�����
					if(arr[i][j]!=arr[x][y]) {
						next.add(new PII(i,j));
						continue;
					}
                    //��ͳ�Ʋ���ȵ�λ�ã����ж��Ƿ��Ѿ�����ǹ�����Ϊ����ȵ��ڽӿ�����Ѿ�����ǹ���
					if(st[i][j]==1) continue;
//					System.out.println(i+" "+j+" "+arr[i][j]);
					q.add(new PII(i,j));
					st[i][j] = 1;
					
				}
			}
			
		}
		//������и��Ӷ�����ͬ�ĸ߶�
		if(next.size()==0) {
			top=1;bottom=1;
			return;
		}
		int flag = 0;//flag=1��ʾɽ����flag=2��ʾɽ��
		while(next.size()>0) {
			PII top = next.poll();
//			System.out.print(arr[top.x][top.y]+" ");
			if(flag!=0) {//���������ɽ��/ɽ�ȵ����������˳�
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
