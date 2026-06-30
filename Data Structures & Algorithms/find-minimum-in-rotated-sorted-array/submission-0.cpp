class Solution {
public:
    int findTurningPoint(vector<int> &nums){
        int low = 0 , high = nums.size()-1;

        while(low<high){
            int mid = low + (high - low)/2;
            if(low == high){
                return low;
            }

            if(nums[mid] > nums[high]){
                low = mid+1; //min is on right
            }else{
                high = mid;
            }
        }
        return low;
 
        
    }
    int findMin(vector<int> &nums) {
       auto tp = findTurningPoint(nums);
       return nums[tp];
    }
};
