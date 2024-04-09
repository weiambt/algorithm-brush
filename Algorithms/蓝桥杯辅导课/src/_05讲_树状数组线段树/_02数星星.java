package _05讲_树状数组线段树;

import java.util.*;
import java.io.*;
public class _02数星星 {
	static int N = 32010;//横坐标的最大范围
	static int[] tree = new int[N];
	static int[] level = new int[N];//level[i]=j记录等级是i的个数是j
	static int n;
	static int lowbit(int x) {
		return x&-x;
	}
	static void add(int x,int v) {
		for(int i=x;i<=N;i+=lowbit(i))//这里是N不是n
			tree[i]+=v;
	}
	static int query(int x) {
		int res= 0 ;
		for(int i=x;i>0;i-=lowbit(i))
			res+=tree[i];
		return res;
	}
	public static void main(String args[]) throws IOException{
		FastRead in = new FastRead();
		n = in.gtInt();
		for (int i = 1; i <= n; i++) {
			int x = in.gtInt();
			int y = in.gtInt();
			x++;//树状数组要求下标从1开始
			level[query(x)]++;//查询当前这一行的前缀和
			add(x, 1);//这一行的值+1
		}
		//快写
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		for (int i = 0; i < n; i++) {//最大是n-1级
			out.println(level[i]);
		}
		out.flush();
	}	
	
}
//
//class FastRead {
//    StreamTokenizer streamTokenizer;  //读取数字
//    BufferedReader bufferedReader;  //读取字符串
//
//    public FastRead() {
//        streamTokenizer = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
//        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//    }
//
//    int gtInt() throws IOException {
//        streamTokenizer.nextToken();
//        int x = (int) streamTokenizer.nval;
//        return x;
//    }
//
//    long gtLong() throws IOException {
//        streamTokenizer.nextToken();
//        long l = (long) streamTokenizer.nval;
//        return l;
//    }
//
//    double gtDouble() throws IOException {
//        streamTokenizer.nextToken();
//        double x = streamTokenizer.nval;
//        return x;
//    }
//
//    String gtString() throws IOException {
//        String s = bufferedReader.readLine();
//        return s;
//    }
//}
//
