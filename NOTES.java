# MAKE SUBARRAYS OF SIZE K

 for(int i = 0;i < nums.length-k+1; i++){
            int[] subArray = Arrays.copyOfRange(nums, i, i + k); // extract subarray of length k
            subArrays.add(subArray);
 }
