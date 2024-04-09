package 搜索;

import java.util.*;
import java.math.*;
import java.io.*;


import java.util.*;
import java.math.*;
import java.io.*;
public class _08魔板 {
	static int INF = 0x3f3f3f3f;
	static int N = 10 , M = 2*N;
	static HashMap<String,Integer> dist = new HashMap<String, Integer>();
	static HashMap<String,PSS> pre = new HashMap<>();
	static Queue<String> q = new LinkedList<String>();
	
	//计算下一个字符串，i代表不同的操作
	static String next(int i,String s) {
		char[] ss = s.toCharArray();
		char[] ans ;
		if(i==1) ans = new char[]{ss[7],ss[6],ss[5],ss[4],ss[3],ss[2],ss[1],ss[0]};
		else if(i==2) ans = new char[]{ss[3],ss[0],ss[1],ss[2],ss[5],ss[6],ss[7],ss[4]};
		else ans = new char[]{ss[0],ss[6],ss[1],ss[3],ss[4],ss[2],ss[5],ss[7]};
//		System.out.println(ans);
		return new String(ans);//不能用ans.toString()
	}

	static int bfs(String start,String end) {
		dist.put(start,0);
		q.add(start);

		while(q.size()>0) {
			String top = q.poll();
			if(top.equals(end)) break;
			String s1,s2,s3; 
			for(int i=0;i<3;i++){
			    s1 = next(i+1,top);
			    if(!dist.containsKey(s1)) {
    				dist.put(s1, dist.get(top)+1);
    				pre.put(s1,new PSS(top,Character.toString((char) ('A'+i))));
    				q.add(s1);
    			}
			}
			
		}
		return dist.get(end);
		
	}


	public static void main(String[] sss) {
		Scanner sc = new Scanner(System.in);
	
		String end="";
		for(int i=0;i<8;i++) {
			end += sc.next();
		}
		String start = "12345678";
		int ans = bfs(start,end);
		System.out.println(ans);
		String path="";
		if(ans>0) {
			while(end!=start) {
				PSS pair = pre.get(end);
				path = pair.op+path;
				end = pair.val;
			}
			System.out.println(path);
		}
		
	}
}
class PSS{
	String val,op;
	public PSS(String x,String y) {
		// TODO Auto-generated constructor stub
		this.val = x;
		this.op = y;
	}
}