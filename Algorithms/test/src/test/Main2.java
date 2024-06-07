package test;



import java.util.Scanner;
// 1:无需package
// 2: 类名必须Main, 不可修改

public class Main2 {
  static int N = 101000;
  static long[] a = new long[N];
  static long[] sum = new long[N];
  static int[] zuid = new int[N],zul = new int[N], zur = new int[N];
  static int zusz, zucnt;
    static int n,m;

    static void init(){
      zusz = (int)Math.sqrt(n) + 1;
      
      for(int i=1;i <= n;i += zusz){
        zucnt += 1;

        for(int j=i;j<=i+zusz-1;j++){
          sum[zucnt] += a[j];
          zuid[j] = zucnt;
          zul[j] = i;
          zur[j] = Math.min(i+zusz-1,n);
        }
      }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        for(int i=1;i<=n;i++)
          a[i] = sc.nextInt();
        init();
        m = sc.nextInt();
        while(m-->0){
          int op = sc.nextInt();
          int x = sc.nextInt();
          int y = sc.nextInt();
          if(op==1){//增加
            a[x] += y;
            sum[zuid[x]] += y;
          }else{//区间求和
            long res = 0;
            for(int i = zuid[x]+1;i < zuid[y];i++)
              res += sum[i];
            for(int i=x;i<=zur[x];i++)
              res += a[i];
            for(int i=zul[y];i<=y;i++)
              res += a[i];
            System.out.println(res);
          }
        }
          

    }
}