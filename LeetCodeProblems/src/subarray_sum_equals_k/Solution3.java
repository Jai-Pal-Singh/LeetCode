package subarray_sum_equals_k;

import java.util.HashMap;
import java.util.Map;

public class Solution3 {
    public int subarraySum(int[] nums, int k) {
        for(int i = 1; i<nums.length; i++) nums[i]+=nums[i-1];
        int ans = 0;
        Map<Integer, Integer> it = new HashMap<>();
        it.put(0, 1);
        for(int i: nums){
            Integer get = it.get(i-k);
            if(get != null) ans+=get;
            get = it.get(i);
            if(get == null) it.put(i, 1); else it.put(i, get+1);
        }
        return ans;
    }
}
