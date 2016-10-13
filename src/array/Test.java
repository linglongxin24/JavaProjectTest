package array;

import java.util.Arrays;

/**
 * Created by yuandl on 2016-10-13.
 */
public class Test {
    public static void main(String args[]) {
        int arr[] = {23, 32, 45, 45, 54, 67, 8, 9, 976, 65};
        bobuleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void selectSort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }

        }
    }

    public static void bobuleSort(int arr[]) {
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-i-1; j++) {
                if(arr[j]>arr[j+1]){
                    int temp=arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=temp;
                }
            }
        }
    }
}
