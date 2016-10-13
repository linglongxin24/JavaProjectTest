package array;

import java.util.Arrays;

/**
 * Created by yuandl on 2016-10-09.
 */
public class ArrayTest {
    public static void main(String[] args) {

        int arr[] = {5, 4, 56, 41, 4, 585, 415, 1};
        System.out.println("排序前" + Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println("冒泡排序后" + Arrays.toString(arr));
        int arrb[] = {5, 4, 56, 41, 4, 585, 415, 1};
        selectSort(arrb);
        System.out.println("选择排序后" + Arrays.toString(arrb));

        int arrc[] = {5, 4, 56, 41, 4, 585, 415, 1};
        Arrays.sort(arrc);
        System.out.println(" Arrays.sort()排序后" + Arrays.toString(arrc));

        System.out.println("最大值" + getMax(arr));
    }


    /**
     * 冒泡排序
     *
     * @param array
     * @return
     */
    public static void bubbleSort(int array[]) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 选择排序
     */
    private static void  selectSort(int arr[]) {
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

    /**
     * 获取数组最值
     */
    private static int getMax(int arr[]) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}
