/*
    2023/1/23 21:08
    @author ZW
    Project Name:eclipse_worksapce

    ������Ϸ II ����λdp��

     ĳ����������һ��ȡģ�����������ֱ��������λ����֮�� mod N Ϊ 0��
        ���ڴ����Ҫ����Ϸ�ˣ�ָ��һ������������ [a.b]��������������ж��ٸ�ȡģ����
*/
import java.util.*;
public class _05������ϷII {
    static int mod;
    static int N = 12;
    //dp[i][j][k]��ʾ��iλ�����λ��j����λ֮�͵�������k���͵�ģ��k���ķ�����
    static int[][][] dp = new int[N][10][105];

    static void init(){
        //dp���
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 10; j++) {
                Arrays.fill(dp[i][j],0);
            }
        }

        //����λ����1�����
        for (int i = 0; i < 10; i++) {
            dp[1][i][i%mod] ++;
        }

        //����λ��2~n�����
        for (int i = 2; i < N; i++) {//λ��
            for (int j = 0; j < 10; j++) {//��λ
                for (int k = 0; k < mod; k++) {//�͵�ģ
                    for (int x = 0; x < 10; x++) {//��λ����һλ��x
                        dp[i][j][k] += dp[i-1][x][solveMod(k-j,mod)];
                    }
                }
            }
        }
    }

    static int count(int n){
        if(n==0) return 1;
        ArrayList<Integer> nums = new ArrayList<>();
        while(n>0){
            nums.add(n%10);
            n /= 10;
        }
        n = nums.size();
        int res = 0;
        int last = 0;//ǰ��λ�������ֺ�
        for (int i = n-1; i >= 0 ; i--) {
            int x = nums.get(i);
            //ö�ٵ�ǰλ<x���������
            for (int j = 0; j < x; j++) {
                //abcXdef
                //��Ϊ[last + sum(Xdef) ]%mod = 0
                //���� sum(Xdef)%mod = (-last)%mod
                res += dp[i+1][j][solveMod(-last,mod)];
            }
            last += x;

            if(i==0 && last%mod==0) res++;
        }
        return res;
    }

    //��Ϊjava��c++����������ȡģ֮����������������ȡģ֮���Ǹ�����
    //������Ҫ�����ǵ�������������ģ��֮���ڼ�һ��P��% һ��P == û�в�����
    //�ͱ������
    private static int solveMod(int a, int mod) {
        return (a%mod + mod)%mod;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int a = sc.nextInt();
            int b = sc.nextInt();
            mod = sc.nextInt();
            init();
            System.out.println(count(b)-count(a-1));
        }
    }
}
