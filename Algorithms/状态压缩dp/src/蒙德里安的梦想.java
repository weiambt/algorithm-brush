import java.util.*;

/*
    2023/1/10 19:19
    @author ZW
    Project Name:eclipse_worksapce

   �ɵ��ﰲ�����룺������AC���루δ�Ż���
     
*/
public class �ɵ��ﰲ������ {

    static int N = 12, M= 1<<12;
    static long[][] dp = new long[N][M];// ��һά��ʾ�У� �ڶ�ά��ʾ���ܵ�״̬
    static boolean[] st = new boolean[M];//�洢ÿ��״̬�Ƿ���������������0�����������0����Ч״̬�������ż��������Ϊtrue��

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            int n = sc.nextInt();
            int m = sc.nextInt();
            if(n==0 && m==0) break;

            //1.Ԥ�������кϷ���״̬������0�ĸ�����ż��
            //����ÿ��״̬����Ԥ����ÿ�в�����������������0
            for (int i = 0; i < 1 << n; i++) {//ö��״̬
                int cnt=0;
                boolean flag = true;
                //�жϸ����ܷ�����ŵĳ����Σ��ж���������0�ĸ����Ƿ���ż��
                for (int j = 0; j < n; j++) {//ö�����״̬�����еĶ�����
                    if((i>>j&1)==1){//��һλ��1
                        if(cnt%2==1){//����ǰ�������0�ĸ���
                            flag = false;
                            break;
                        }
                    }else
                        cnt++;
                }
                if(cnt%2==1) //�������һ��Ҫ����
                    flag = false;
                st[i] = flag;
            }
            //2.dp
            for (int i = 0; i < N; i++) {
                Arrays.fill(dp[i],0);// ��Ϊ�ж������ݣ���ֹ��һ�����ݵĸ��ţ���������
            }
            dp[0][0]=1;// ʲô��û��ʱ�򣬿��ű�ʾһ�ַ���

            for (int i = 1; i <= m; i++) {//ö����������i�кϷ���Χ��(0~m-1��)
                for (int j = 0; j < 1<<n; j++) {//��i�е�״̬
                    for (int k = 0; k < 1<<n; k++) {//ö�ٵ�i-1�е�״̬,��������ܻᵼ��ʱ�临�Ӷȸߣ�������ǰ������Ż���
                        //1��j��kû���ཻ��2��i-1�е�0�ĸ����ǲ���ż��
                        if((j&k)==0 && st[j|k])
                            dp[i][j]+=dp[i-1][k];
                    }
                }
            }
            //����dp[m][0]����ʾǰm-1�ж������꣬���ҵ�m-1��û������������з�������
            System.out.println(dp[m][0]);
        }



    }
}
