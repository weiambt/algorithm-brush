import java.util.ArrayList;

/*
    2023/1/23 20:10
    @author ZW
    Project Name:eclipse_worksapce
     
*/
public class _00��λdpģ�� {
    static int count(int n){
        if(n==0) return 0;
        ArrayList<Integer> nums = new ArrayList<>();
        while(n>0){
            nums.add(n%10);
            n/=10;
        }
        n = nums.size();
        int res = 0;
        int last = 0;
        for (int i = n-1; i >= 0; i--) {
            int x = nums.get(i);
            //ö�ٵ�ǰλС��x���������
            for (int j = 0; j < x; j++) {
                //���������㹫ʽ

                //������һֱ�ݹ�

                // ���������յ���ܻ��һ�ַ���
                if(i==0) res++;
            }
        }
        return res;
    }
}
