import org.jetbrains.annotations.NotNull;

import java.util.Scanner;
import java.util.Random;

public class SelectionSort {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Random rnd = new Random();

        final int DATA_LENGTH = 1000;

        int[] data = new int[DATA_LENGTH];

        int minVal = -1;
        int minDex = -1;
        int swap = -1;

        for(int x = 0; x < data.length; x++) {
            data[x] = rnd.nextInt(100) + 1;
            System.out.printf("%3d  ", data[x]);
        }


        /*
           Selection sort
           Traverse the array each time picking the min and swapping it back into the array at the sorted position at the front
           As the sort progresses the first part of the array is sorted with the loop continuing to pick the next minimum
           until the entire array is sorted.
         */


        for(int x=0; x < data.length; x++)
        {
            // Find the minimum assume that it is initially the first element of the unsorted region
            minVal = data[x]; // Min is 1st value of unsorted region until we compare and find a new one
            minDex = x; // index of the location of the min value

            // scan for a new min starting at this location NOT at the beginning of the entire array
            // because the portion of the array before x has been sorted already

            for(int s = x; s < data.length; s++) {
                   // Notice how this loop starts at x so it only traverses the remaining unsorted region of the array
                if (data[s] < minVal) {  // if its a new min
                    minVal = data[s];    // remember it
                    minDex = s;          // and it's index
                }
            }  // When this loop completes we have done a traversal to pick the min from the unsorted region
            // now swap the element into place
            swap = data[x];  // this is where the new min will go in the sorted order save whats there already with swap
            data[x] = data[minDex]; // over write it putting the min vlaue found in its proper place in the sort
            data[minDex] = swap;    // put the value that you overwrite back in the location of the found min to complete the swap

        }

        System.out.println("\nSorted Array: ");

        for(int p = 0; p < data.length; p++)
            System.out.printf("%3d  ", data[p]);
    }

    private static void SelectionSort(int @NotNull [] arr)
    {
        int minVal;
        int minDex;
        int swap;

        for(int x=0; x < arr.length; x++)
        {
            // Find the minimum
            minVal = arr[x]; // Min is 1st value until we compare and find a new one
            minDex = x; // index of the lo0cation of the min value

            // scan for a new min starting at this location NOT at the beginning
            // because the portion of the aray before x has been sorted already

            for(int s = x; s < arr.length; s++) {
                if (arr[s] < minVal) {  // if its a new min
                    minVal = arr[s];    // rememner it
                    minDex = s;          // and it's index
                }
            }
            // now swap the element into place
            swap = arr[x];  // this is where the new min will go in the sorted order save whats there already with swap
            arr[x] = arr[minDex]; // over write it putting the min vlaue found in its proper place in the sort
            arr[minDex] = swap;    // put the value that you overwrite back in the location of the found min to complete the swap

        }
    }
}