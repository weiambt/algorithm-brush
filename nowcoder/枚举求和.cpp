#include<bits/stdc++.h>
using namespace std;
//https://ac.nowcoder.com/acm/contest/9692/E
//˼ά
//��⣺https://ac.nowcoder.com/acm/discuss/blogs?tagId=139763
int main(){
    int t,n,m,k;
    cin>>t;
    while(t--){
        cin>>n>>m>>k;
        
        //gcd(i,j)��ʾgcd������i && gcdҲ������j
        //k������gcd(i,j)
        //���Եȼ��ڣ�k����i && k����j
        cout<< (long long)n/k * (m/k)<<endl;
    }
    return 0;
}