class Solution {
public:

    bool check(vector<int>& piles, int h, int rate){
        int hour = 0;
        for(int i=0;i<piles.size();i++){
             hour += ceil((double)piles[i] / rate);
        }

        return hour <=h; //in bound
    }

    int minEatingSpeed(vector<int>& piles, int h) {
        int low = 1;
        int high = *max_element(piles.begin(),piles.end());

        //bs
        int ans = 0 ;
        while(low<=high){
            int mid = low + (high-low)/2;

            if(check(piles,h,mid)){
                high = mid-1;
                ans = mid;
            }else{
                low = mid+1;
            }

        }
        return ans;
    }
};
