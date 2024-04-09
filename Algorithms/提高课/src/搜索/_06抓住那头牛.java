package 搜索;

import java.util.*;
import java.math.*;
import java.io.*;
public class _06抓住那头牛 {
	static int INF = 0x3f3f3f3f;
	static int N = 101000 , M = 2*N;
	static int[] cen = new int[N];
	static int s,e;
	static int bfs() {
		Arrays.fill(cen,INF);
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(s);
		cen[s] = 0;

		while(q.size()>0) {
			Integer top = q.poll();
			if(e==top)
				return cen[e];
			
			

            if(top+1<N && cen[top+1]==INF){
                q.add(top+1);
			    cen[top+1] = cen[top]+1;
            }
			

            if(top-1>=0 && cen[top-1]==INF){
                q.add(top-1);
			    cen[top-1] = cen[top]+1;
            }

            if(2*top<N && cen[2*top]==INF){
                q.add(2*top);
			    cen[2*top] = cen[top]+1;
            }
			

		}
		return cen[e];
				
	}


	public static void main(String[] sss) {
		Scanner sc = new Scanner(System.in);
		s = sc.nextInt();
		e = sc.nextInt();
		
		
		int ans = bfs();
		System.out.println(ans);

	}
}

