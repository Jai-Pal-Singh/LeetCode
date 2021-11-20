package first_bad_version;

// You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.

// Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

// You are given an API bool isBadVersion(version) which returns whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.

public class Solution {
    VersionControl vc;

    public Solution() {
    }

    public Solution(VersionControl vc) {
        this.vc = vc;
    }

    public VersionControl getVc() {
        return this.vc;
    }

    public void setVc(VersionControl vc) {
        this.vc = vc;
    }
   
    public int firstBadVersion(int n) {
        int start = 1;
        return modifiedBinarySearch(start, n);
    }
    
    public int modifiedBinarySearch(int start, int n) {
        if(start<=n){
            int mid = start + (n-start)/2;
            boolean isMidBadVersion = vc.isBadVersion(mid);
            if((isMidBadVersion==true && (mid-1 >= 1) && vc.isBadVersion(mid-1)==false) || (isMidBadVersion==true && mid==1)){
                return mid;
            }
            else if(isMidBadVersion==false){
                return modifiedBinarySearch(mid+1, n);
            }
            else{
                return modifiedBinarySearch(start, mid-1);
            }
        }
        return -1;
    }
}
