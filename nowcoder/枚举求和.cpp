#include<bits/stdc++.h>
using namespace std;
//https://ac.nowcoder.com/acm/contest/9692/E
//思维
//题解：https://ac.nowcoder.com/acm/discuss/blogs?tagId=139763
int main(){
    int t,n,m,k;
    cin>>t;
    while(t--){
        cin>>n>>m>>k;
        
        //gcd(i,j)表示gcd能整除i && gcd也能整除j
        //k能整除gcd(i,j)
        //所以等价于：k整除i && k整除j
        cout<< (long long)n/k * (m/k)<<endl;
    }
    return 0;
}