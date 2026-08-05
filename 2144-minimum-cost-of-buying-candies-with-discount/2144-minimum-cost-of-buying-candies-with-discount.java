// class Solution {
//     public int minimumCost(int[] cost) {
//         Arrays.sort(cost);
//         int ans=0;
//         int c=0;
//         for(int i=cost.length-1;i>=0;i--){
//             c++;
//             if(c==3){
//                 c=0;
//                 continue;
//             }
//             ans+=cost[i];

//         }

//         return ans;
//     }
// }


class Solution {
    public int minimumCost(int[] cost) {
        int freq[]= new int[101];
        int n=cost.length;
        for(int i=0;i<cost.length;i++)
        {
            freq[cost[i]]++;
        }
        int ans=0;
        int bal=2;
        for(int i=100;i>0;i--)
        {
            while(freq[i]>0)// highest element ki freq jb tk 0 na ho jaye 
            {
               freq[i]--;
               if(bal==0)
               {
                 bal=2;// jb balance 0  ho jaye update balance and continue 
                 continue;
               }
            bal--;
            ans+=i;
           }
        }
        return ans;
    }
}