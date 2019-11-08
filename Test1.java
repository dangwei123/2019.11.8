//
class Solution {
    public int search(int[] nums, int target) {
        int l=0;
        int r=nums.length-1;
        while(l<=r){
            int mid=(r+l)>>>1;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]>target){
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return -1;
    }
}

//
class Solution {
    public int shipWithinDays(int[] weights, int D) {
       int sum=0;
       int max=weights[0];
        for(int i=0;i<weights.length;i++){
            if(max<weights[i]){
                max=weights[i];
            }
            sum+=weights[i];
        }
        int l=max;
        int r=sum;
        while(l<r){
            int mid=(r+l)>>>1;
            int day=D;
            int tmp=mid;
            for(int i=0;i<weights.length;i++){
                tmp-=weights[i];
                if(tmp<0){
                    day--;
                    tmp=mid-weights[i];
                }
            }
            if(day<=0){
                l=mid+1;
            }else{
                r=mid;
            }
        }
        return l;
    }
}

//
class Solution {
    public int minEatingSpeed(int[] piles, int H) {
        int l=1;
        int r=piles[0];
        for(int i:piles){
            if(r<i){
                r=i;
            }
        }
        while(l<r){
            int mid=(r+l)>>>1;
            if(canEat(piles,H,mid)){
                r=mid;
            }else{
                l=mid+1;
            }
        }
        return l;
    }
    public boolean canEat(int[] piles,int H,int mid){
        int time=0;
        for(int i:piles){
            time+=i/mid;
            if(i%mid!=0){
                time++;
            }
        }
        return time<=H;
    }
}



//
