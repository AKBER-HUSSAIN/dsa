// class Solution {
//     public int missingInteger(int[] nums) {
//         int sum = nums[0];
//         int i = 1;

//         while (i < nums.length && nums[i] == nums[i - 1] + 1) {
//             sum += nums[i];
//             i++;
//         }

//         HashSet<Integer> set = new HashSet<>();
//         for (int num : nums) {
//             set.add(num);
//         }

//         while (set.contains(sum)) {
//             sum++;
//         }

//         return sum;
//     }
// }


class Solution {
    public int missingInteger(int[] nums) {
        int sum=nums[0];
       for(int i=1;i<nums.length;i++)
       {
          if(nums[i]==nums[i-1]+1)
          {
            sum=sum+nums[i];
          }
          else
          {
            break;
          }
       }
       int j=sum;
       while(true)
       {
        boolean found=false;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==j)
            {
                found=true;
                break;
            }
        }
        if(!found)
        {
            return j;
        }
        j++;
       }
    }
}