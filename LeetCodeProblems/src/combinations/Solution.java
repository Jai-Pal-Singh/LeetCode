package combinations;

import java.util.ArrayList;
import java.util.List;

/* 
Given two integers n and k,return all possible combinations of k numbers out of the range[1,n].

You may return the answer in any order.

Example 1:

Input:n=4,k=2 Output:[[2,4],[3,4],[2,3],[1,2],[1,3],[1,4],]Example 2:

Input:n=1,k=1 Output:[[1]]

Constraints:

1<=n<=20 1<=k<=n
 */
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        combine(n, k, res, new ArrayList<>(), 1);
        return res;
    }

    public void combine(int n, int k, List<List<Integer>> res, List<Integer> list, int start) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
        } else {
            for (int i = start; i <= n; i++) {
                if (list.contains(i))
                    continue;
                list.add(i);
                combine(n, k, res, list, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }
}
