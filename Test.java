现 int sqrt(int x) 函数。

计算并返回 x 的平方根，其中 x 是非负整数。

由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。


来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/sqrtx
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

class Solution {
    public int mySqrt(int x) {
        long a=x;
        while(a*a>x){
            a=(a+x/a)>>>1;
        }
        return  (int)a;
    }
}


class Solution {
    public int mySqrt(int x) {
        if(x==0){
            return 0;
        }if(1<=x&&x<=3){
            return 1;
        }
        int l=0;
        int r=x>>>1;
        while(l<r){
            int mid=(r+l+1)>>>1;
            if(mid>x/mid){
                r=mid-1;
            }else{
                l=mid;
            }
        }
        return l;
    }
}

给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组
中，返回它将会被按顺序插入的位置。

你可以假设数组中无重复元素。
class Solution {
    public int searchInsert(int[] nums, int target) {
        int l=0;
        int r=nums.length;
        while(l<r){
            int mid=(r+l)>>>1;
            if(nums[mid]<target){
                l=mid+1;
            }else{
                r=mid;
            }
        }
        return l;
    }
}

给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。

函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l=0;
        int r=numbers.length-1;
        while(l<r){
            int mid=numbers[l]+numbers[r];
            if(mid==target){
                break;
            }else if(mid<target){
                l++;
            }else{
                r--;
            }
        }
        return new int[] {l+1,r+1};
    }
}


我们正在玩一个猜数字游戏。 游戏规则如下：
我从 1 到 n 选择一个数字。 你需要猜我选择了哪个数字。
每次你猜错了，我会告诉你这个数字是大了还是小了。
你调用一个预先定义好的接口 guess(int num)，它会返回 3 个可能的结果（-1，1 或 0）：

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/guess-number-higher-or-lower
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int l=1;
        int r=n;
        while(l<=r){
            int mid=(r+l)>>>1;
            if(guess(mid)==0){
                return mid;
            }
            if(guess(mid)>0){
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        return -1;
    }
}


//
class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int res=0;
        int i=0;
        for(int house:houses){
            while(i<heaters.length&&heaters[i]<house){
                i++;
            }
            if(i==0){
                res=Math.max(res,heaters[i]-house);
            }else if(i==heaters.length){
               return res=Math.max(res,houses[houses.length-1]-heaters[i-1]);
            }else{
                 res=Math.max(res,Math.min(heaters[i]-house,house-heaters[i-1]));
            }
        }
        return res;
    }
}