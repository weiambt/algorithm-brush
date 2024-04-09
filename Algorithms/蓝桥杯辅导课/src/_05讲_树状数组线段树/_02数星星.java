package _05��_��״�����߶���;

import java.util.*;
import java.io.*;
public class _02������ {
	static int N = 32010;//����������Χ
	static int[] tree = new int[N];
	static int[] level = new int[N];//level[i]=j��¼�ȼ���i�ĸ�����j
	static int n;
	static int lowbit(int x) {
		return x&-x;
	}
	static void add(int x,int v) {
		for(int i=x;i<=N;i+=lowbit(i))//������N����n
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
			x++;//��״����Ҫ���±��1��ʼ
			level[query(x)]++;//��ѯ��ǰ��һ�е�ǰ׺��
			add(x, 1);//��һ�е�ֵ+1
		}
		//��д
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		for (int i = 0; i < n; i++) {//�����n-1��
			out.println(level[i]);
		}
		out.flush();
	}	
	
}
//
//class FastRead {
//    StreamTokenizer streamTokenizer;  //��ȡ����
//    BufferedReader bufferedReader;  //��ȡ�ַ���
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
