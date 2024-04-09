
import java.util.*;
import java.io.*;
import java.math.*;
public class B {
	static int INF = 0x3f3f3f3f;
	static int N = 100100,M = 2*N;
	static int[] arr = new int[N];
	static int n,m;
	static int cnt1=0,cnt2=0,cnt=0;
	static String[] ss = new String[N];
	static String ans = "";
	static void dfs(int x) {
		if(x==cnt1) {
			System.out.print("int");
			return;
		}
		System.out.print("pair<");
		dfs(x+1);
		System.out.print(",int>");
	}
	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		n = sc.nextInt();
		while(sc.hasNext()) {
			String string = sc.next();
			ss[cnt++] = string;
			if(string.equals("pair")) {
				cnt1++;
			}else cnt2++;
		}
		if(cnt1+1!=cnt2) {
			System.out.println("Error occurred");
		}else {
			Stack<String> st = new Stack<String>();
			int intCnt = 0;
			int flag=0;
			for(int i=0;i<cnt;i++) {
				if(ss[i].equals("pair")) {
					st.add("pair");
					continue;
				}
				else {
					String top = st.peek();
					if(top.equals("succ")) {
						ans += "int>";
						ans = "pair<"+ans;
						st.pop();st.pop();
						st.add("succ");
					}
					else if(top.equals("int")) {
						if(flag==1) ans+=",";
						ans+="pair<int,int>";
						st.pop();
						st.pop();
						st.add("succ");
						flag = 1;
					}else 
						st.add("int");
				}
				
				
			}
			if(st.size()>0)
					ans = "pair<"+ans+">";
			System.out.println(ans);
		}
		
	}
}
