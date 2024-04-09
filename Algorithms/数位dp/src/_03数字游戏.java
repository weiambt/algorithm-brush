/*
    2023/1/22 22:11
    @author ZW
    Project Name:eclipse_worksapce

    ������Ϸ����λdp
     ĳ��������һ�ֲ��������������ֱ�����������Ҹ�λ���ֳʷ��½���ϵ���� 123��446��
        ���ڴ�Ҿ�����һ����Ϸ��ָ��һ������������ [a,b]��������������ж��ٸ���������

    ʹ�����Թ滮Ԥ����һ������dp��
*/
import java.util.*;
public class _03������Ϸ {
    static int N = 36;
    //dp[i][j]��ʾһ����iλ�������λ��j�Ĳ������ĸ���
    static int[][] dp = new int[N][N];

    static int count(int n){
        if(n==0) return 1;
        ArrayList<Integer> nums = new ArrayList<>();
        while(n>0){
            nums.add(n%10);
            n/=10;
        }
        n = nums.size();
        int res = 0;
        int last = 0;//ǰһλ
        for(int i=n-1;i>=0;i--){
            int x = nums.get(i);
            for (int j = last; j < x; j++) {
                res += dp[i+1][j];
            }
            if(x<last) break;//������������
            last = x;
            if(i==0) res++;

        }
        return res;
    }
    //ʹ�ö�̬�滮��ʼ������
    static void init(){
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i < N ; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = j; k < 10; k++) {
                    dp[i][j] += dp[i-1][k];
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        init();
        while(sc.hasNext()){
            int a = sc.nextInt();
            int b = sc.nextInt();

            System.out.println(count(b)-count(a-1));
        }
    }

}
