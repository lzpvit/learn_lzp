package questions;

/**
 * Created by LZP on 2017/12/12.
 * 递增数列   前n个数后置，求最小元素
 */
public class Lzp6 {
    public int minNumberInRotateArray(int[] array) {
        int index = array.length / 2;
        int min = 0;
        int max = array.length - 1;
        if (array.length == 0) {
            return 0;
        }
        if (array.length == 1) {
            return array[0];
        }
        while (true) {
            if (array[index] < array[index + 1] && array[index] >= array[0]) {
                min = index + 1;
                index = (min + max) / 2;
            } else if (array[index] < array[index + 1] && array[index] < array[0]) {
                max = index - 1;
                index = (min + max) / 2;
            } else {
                return array[index + 1];
            }
        }
    }

    public int minNumInRotateArray(int[] array) {
        int max = array.length - 1;
        if (array.length == 0) {
            return 0;
        }
        if (array.length == 1) {
            return array[0];
        }
        for (int i = 0; i < max; i++) {
            if (array[i] > array[i + 1]) {
                return array[i + 1];
            }
        }
        return array[max];
    }
}
