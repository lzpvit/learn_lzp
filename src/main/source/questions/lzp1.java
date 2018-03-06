package questions;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by LZP on 2017/11/17.
 * 长度为n的数组，取出任意一个重复的数字
 */
public class lzp1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);
        for (int x = 0; x < n - 1; x++) {
            if (arr[x] == arr[x + 1]) {
                System.out.println(arr[x]);
            }
        }
        //System.out.println(arr);
    }
}
