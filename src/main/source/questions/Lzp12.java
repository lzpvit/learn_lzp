package questions;

import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by LZP on 2018/1/7.
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class Lzp12 {
    public static boolean chargeNum(int n) {
        int tmp = n / 2;
        if (n == 2 * tmp)
            return true;
        else
            return false;
    }

    public static int[] swap(int[] array, int x, int y) {
        int tmp = array[x];
        array[x] = array[y];
        array[y] = tmp;
        return array;
    }

    public void reOrderArray(int[] array) {
        int n = array.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                int jj = j + 1;
                if (Lzp12.chargeNum(array[j]) == true && Lzp12.chargeNum(array[jj]) == false) {
                    array = Lzp12.swap(array, j, jj);
                }
            }
        }

    }

    public void reOrderArray1(int[] array) {
        int len = array.length;
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        ArrayList<Integer> arrayList1 = new ArrayList<Integer>();
        for (int x : array) {
            int tmp = x / 2;
            if (x == 2 * tmp) arrayList.add((Integer) x);
            else arrayList1.add((Integer) x);
        }
        int n = arrayList1.size();
        for (int i = 0; i < n; i++) {
            array[i] = arrayList1.get(i);
        }
        for (int j = 0; j < arrayList.size(); j++) {
            array[j + n] = arrayList.get(j);
        }
    }

    public void reOrderArray2(int[] array) {
        int n = array.length;
        int countSwap = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                int jj = j + 1;
                if (Lzp12.chargeNum(array[j]) == true && Lzp12.chargeNum(array[jj]) == false) {
                    array = Lzp12.swap(array, j, jj);
                    countSwap++;
                }
            }
            if (countSwap == 0) break;
        }

    }

    //类似冒泡算法的交换奇偶数
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int[] a = {1, 2, 3, 4, 5, 6, 7};
        Lzp12 lzp12 = new Lzp12();
        lzp12.reOrderArray(a);
        long endTime = System.nanoTime();
        System.out.println(endTime - startTime);
    }

    //改进版冒泡实现
    @Test
    public void test2() {
        long startTime = System.nanoTime();
        int[] a = {1, 2, 3, 4, 5, 6, 7};
        Lzp12 lzp12 = new Lzp12();
        lzp12.reOrderArray2(a);
        long endTime = System.nanoTime();
        System.out.println(endTime - startTime);
    }

    //直接两个数组分离奇偶数然后合并
    @Test
    public void test1() {
        long startTime = System.nanoTime();
        int[] a = {1, 2, 3, 4, 5, 6, 7};
        Lzp12 lzp12 = new Lzp12();
        lzp12.reOrderArray1(a);
        long endTime = System.nanoTime();
        System.out.println(endTime - startTime);
    }
}
