

import java.util.ArrayList;
import java.util.Scanner;

/*
    2023/1/17 14:54
    @author ZW
    Project Name:eclipse_worksapce

     ���⣺�ҵ�[l,r]���������������ĸ�������������n��B��������1�ĸ���ǡ����k�������Ҹ���λ��ֵֻ����0��1
*/
public class _02�ȵ����� {
    static int k,b;
    static int N  = 33;
    static int[][] C = new int[N][N];
    static void init(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                if(j==0) C[i][j] = 1;
                else C[i][j] = C[i-1][j]+C[i-1][j-1];
            }
        }
    }
    static int dp(int n){
        int res = 0;
        int used = 0;

        ArrayList<Integer> nums = new ArrayList<>();
        while(n>0){
            nums.add(n%b);
            n/=b;
        }
        for(int i = nums.size()-1;i>=0;i--){
            int x = nums.get(i);

            //x==0��ʱ��������
            if(x>0){
                res += C[i][k-used];//����iλ��0ʱ�ķ�����
                if(x==1){
                    used++;
                    if(used>k)break;
                }
                else{//x>1ʱ
                    if(k-used-1>=0)
                        res+=C[i][k-used-1];//����iλ��1ʱ�ķ�����
                    //��ʱʣ�µ����������ýڵ��ŵ�x>1����ʱ���治�������������ķ���
                    break;
                }
            }
            //���洦�������������**����**���֧����ʣ�����һ���ҷ�֧�����
            // Ҳ���Ǳ��������1λ����vector�о����±�Ϊ0�ĵط���i==0��
            // �������1λȡ0��������һ�����res++����Ϊ���1λ��Ϊ0�Ļ����Ѿ��������ifelse�����ˡ�
            if(i==0 && used == k) res++;

        }

        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int l = sc.nextInt();
        int r = sc.nextInt();
        k = sc.nextInt();
        b = sc.nextInt();

        init();
        System.out.println(dp(r)-dp(l-1));
    }
}
