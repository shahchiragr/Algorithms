package org.cshah.algorithms.array;

public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2)
            return  nums.length;

        int currentValue = nums[nums.length-1];
        int index = nums.length-1;
        int count = 0;
        int totalCount = 0;

       while (index >= 0) {
           if ( (nums[index] == currentValue)) {
               count++;
           } else {
               if (count <= 2) {
                   totalCount += count;
                   count=1;
                   currentValue = nums[index];
               } else {
                   totalCount +=2;
                   int position = index +3;//+ count-1;
                   int findMovingPointer = Integer.MAX_VALUE;

                   for (int i = position; i < nums.length; i++) {
                       if (nums[i] != currentValue) {
                           findMovingPointer = i;
                           break;
                       }
                   }
                 while (findMovingPointer < nums.length) {
                       nums[position++] = nums[findMovingPointer++];
                   }
                   while (position < nums.length) {
                       nums[position++] = Integer.MIN_VALUE;
                   }

                   count=1;
                   currentValue = nums[index];
               }
           }

           if (index == 0 && count > 2) {
               totalCount += 2;
               int findMovingPointer = Integer.MAX_VALUE;
               int position = 2;

               for (int i = position; i < nums.length; i++) {
                   if (nums[i] != currentValue) {
                       findMovingPointer = i;
                       break;
                   }
               }
               while (findMovingPointer < nums.length) {
                   nums[position++] = nums[findMovingPointer++];
               }
               while (position < nums.length) {
                   nums[position++] = Integer.MIN_VALUE;
               }

           } else if (index ==0 && count <=2) {
               totalCount+=count;
           }
            index--;
       }
       return  totalCount;
    }

    public void removeDuplicate(int[] nums) {
        System.out.println("Original Value");
        for (int i : nums ) {
            System.out.print( i + " ,");
        }
        System.out.println("");

        int count = removeDuplicates(nums);

        System.out.println("Total counter " + count);

        for (int i : nums ) {
            System.out.print( i + " ,");
        }
        System.out.println("");

    }

    public static void printArray(int[] nums) {
        for (int i : nums ) {
            System.out.print( i + " ,");
        }
        System.out.println("");
    }

    public int removeDuplicate_Algo2(int[] nums) {
        printArray(nums);
        int counter =0;
        int pointer =1;
        while (pointer < nums.length ) {
            if ( nums[counter] != nums[pointer]) {
                    counter++;
                    nums[counter] = nums[pointer];
            }
            pointer++;
        }

        int negValueIndex = counter+1;
        while (negValueIndex < nums.length) {
            nums[negValueIndex++] = Integer.MIN_VALUE;
        }

        printArray(nums);

        return counter;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray removeDuplicatesFromSortedArray = new RemoveDuplicatesFromSortedArray();
        int[] data = new int[] {1,1,1,2,2,3};
        removeDuplicatesFromSortedArray.removeDuplicate_Algo2(data);

        data = new int[] {0,0,1,1,1,1,2,3,3};
        removeDuplicatesFromSortedArray.removeDuplicate_Algo2(data);


        data = new int[] {0,0,1,1,2,3,3,3};
        removeDuplicatesFromSortedArray.removeDuplicate_Algo2(data);

        data = new int[] {1,2,2,2,3};
        removeDuplicatesFromSortedArray.removeDuplicate_Algo2(data);

        data = new int[] {1,1,1,1,1,1,2,2,2,2,2,2,2,2,2,2,2,3};
        removeDuplicatesFromSortedArray.removeDuplicate_Algo2(data);

        data = new int[] {1,1,1,1,1,1};
        removeDuplicatesFromSortedArray.removeDuplicate_Algo2(data);

    }
}
