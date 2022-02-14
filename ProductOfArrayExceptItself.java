// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach
/*
	Take a multiplication array from right side.
	Traverse through nums array and take the multiplication
	as you move forward.
	Multiplication at every i will be Product until i-1 and 
	right Multiplication array i+1 value 
*/

class Solution {
    public int[] productExceptSelf(int[] nums) {
      
        int[] ProductFromRight = new int[nums.length];
        
        int product=1;
        for(int i=nums.length-1; i>0; i--){
            product = nums[i] * product;
            ProductFromRight[i] = product;
        }
        
        int prevProd =1;
        for(int i=0; i<nums.length; i++){
            if(i== 0){
                prevProd = nums[i];
                nums[i] = ProductFromRight[i+1];
                
            }else if(i == nums.length-1){
                nums[i] = prevProd;
            }else{ 
                int newProd = prevProd * nums[i];
                nums[i] = prevProd * ProductFromRight[i+1];
                prevProd = newProd;
            } 
        }
        
        return nums;
    }
}

