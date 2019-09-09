package org.cshah.algorithms.leetcode;

public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int[] returnArray = new int[] {Integer.MAX_VALUE, Integer.MIN_VALUE};
        searchItem(0, nums.length-1, nums, target, returnArray );

        if (returnArray[0] == Integer.MAX_VALUE)
            returnArray[0] = -1;

        if (returnArray[1] == Integer.MIN_VALUE)
            returnArray[1] = -1;

        return returnArray;
    }

    public void searchItem(int start, int end, int[] nums, int target, int[] returnArray) {
        if (start > end)
            return;

        int index = start + (end-start/2);

    //    System.out.printf("Start %s, Mid %s, End %s \n" , start, index, end);
        if (nums[index] == target) {
            if (index < returnArray[0])
                returnArray[0] = index;

            if (index > returnArray[1])
                returnArray[1] = index;
        }

        searchItem(start, index-1, nums, target, returnArray);
        searchItem(index+1, end, nums, target, returnArray);

    }

    public static void main(String[] args) {
        SearchRange searchRange = new SearchRange();
        int[] nums = new int[] {5,7,7,8,8,9,10};
        int[] result = null;

        result = searchRange.searchRange(nums,8);
        System.out.printf("Fist position %s , Last Position %s \n ", result[0], result[1]);

        nums = new int[] {1,1,1,2,3,3,5,7,7,8,8,9,10};

        result = searchRange.searchRange(nums,1);
        System.out.printf("Fist position %s , Last Position %s \n ", result[0], result[1]);


        result = searchRange.searchRange(nums,2);
        System.out.printf("Fist position %s , Last Position %s \n ", result[0], result[1]);

        nums = new int[] {1,1,1,2,3,3,5,7,7,8,8,9,10};

        result = searchRange.searchRange(nums,4);
        System.out.printf("Fist position %s , Last Position %s \n ", result[0], result[1]);

    }
}
