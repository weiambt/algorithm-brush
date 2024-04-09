/*
    2023/1/22 19:49
    @author ZW
    Project Name:eclipse_worksapce

    给定两个整数 a 和 b，求 a 和 b 之间的所有数字中 0?9 的出现次数。
     
*/
import java.util.*;
public class _01计数问题 {
    static ArrayList<Integer> nums = new ArrayList<>();

    /*
    获取数位的值
     */
    static int get(int l,int r){
        int res = 0;
        for (int i = l; i >= r ; i--) {
            res = res * 10 + nums.get(i);
        }
        return res;
    }

    static int power10(int i){
        int res = 1;
        for (int j = 0; j < i; j++) {
            res*=10;
        }
        return res;
    }
    /**
     * 计算1~n中数位x出现的次数
     * @param n
     * @param x
     * @return
     */
    static int count(int n,int x){
        if(n==0) return 0;
        while(n>0){
            nums.add(n%10);
            n/=10;
        }

        int ans=0;
        n = nums.size();
        //对于0,不需要枚举最高位
        for(int i = n-1-(x==0?1:0);i>=0;i--){
            int d = nums.get(i);
            //前缀 乘 10^i
            if(i<n-1){
                ans += get(n-1,i+1) * power10(i);
                if(x==0){
                    ans -= power10(i);
                }
            }

            //判断x与d的关系，计算
            if(d==x){
                ans += get(i-1,0) + 1;
            }else if(d>x){
                ans += power10(i);
            }
        }
        // System.out.print(ans+" ");
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            int a = sc.nextInt();
            int b = sc.nextInt();
            if(a==0 && b==0) break;
            if(a>b){
                int t = a;
                a = b;
                b = t;
            }
            for (int i = 0; i < 10; i++) {
                System.out.print(count(b,i)-count(a,i)+" ");
            }
            System.out.println();
        }
    }
}
