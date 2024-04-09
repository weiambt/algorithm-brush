/*
    2023/1/23 18:53
    @author ZW
    Project Name:eclipse_worksapce
     
*/
import java.util.*;
public class _04Windy�� {
    static int N = 11;
    //dp[i][j]��ʾ��iλ�������λ��j��Windy���ĸ���
    static int[][] dp = new int[N][10];

    //��ʼ��dp����
    static void init(){
        //һλ���ֶ���Windy��
        for (int i = 0; i < 10; i++) {//Ҫ����0
            dp[1][i] = 1;
        }
        for (int i = 2; i < N; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    if(Math.abs(j-k)>=2)
                        dp[i][j] += dp[i-1][k];
                }
            }
        }
    }
    static int count(int n){
        if(n==0) return 0;
        ArrayList<Integer> nums = new ArrayList<>();
        while(n>0){
            nums.add(n%10);
            n/=10;
        }
        n = nums.size();
        int res = 0;
        int last = -2;
        //ͳ��ǡ����nλ�����
        for (int i = n-1; i >= 0 ; i--) {
            int x = nums.get(i);
            //���λ���У����λ�ų�ǰ��0��
            for (int j = (i==n-1?1:0); j < x; j++) {
                if(Math.abs(j-last)>=2)
                    res += dp[i+1][j];
            }
            if(Math.abs(x-last)<2) break;
            last = x;
            if(i==0) res++;

        }
        //ͳ�Ƶ�nλ�����ֵ����
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < 10; j++) {//jҪ��1��ʼ���ų�ǰ��0
                res += dp[i][j];
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        init();
        System.out.println(count(b)-count(a-1));
    }
}
