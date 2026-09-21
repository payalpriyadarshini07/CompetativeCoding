class Solution {
    public int maxArea(int[] height) {
        /* Brute force Technique
        int max_water = 0;
        int n = height.length; 
        
        
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){ 
                int w = j - i;
                int h = Math.min(height[i], height[j]);
                int area = w * h;
                max_water = Math.max(area, max_water); // 
            }
        }
        return max_water;*/

        int max_water=0;
        int left=0;
        int right=height.length-1;

        while(left<right){
            int w=right-left;
            int h= Math.min(height[left],height[right]);
            int area= w*h;
            max_water=Math.max(max_water,area);

            if(height[left]<height[right]){
                left++;
            }
            else{
                right--;
            }
        }
        return max_water;

    }
}