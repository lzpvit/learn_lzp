package questions;

import java.util.Scanner;

/**
 * Created by LZP on 2017/12/10.
 * ��һ����ά�����У�ÿһ�ж����մ����ҵ�����˳������ÿһ�ж����մ��ϵ��µ�����˳������
 * �����һ������������������һ����ά�����һ���������ж��������Ƿ��и�������
 */
public class Solution {
    public static boolean find(int target, int[][] array) {
        int n = array.length;
        if (n == 0) return false;
        int m = array[0].length;
        if (m == 0) return false;
        int index1 = 0;
        int index2 = m - 1;
        while (true) {
            if (target > array[index1][index2]) {
                index1 = index1 + 1;
                if (index1 >= n) {
                    break;
                }
            } else if (target < array[index1][index2]) {
                index2 = index2 - 1;
                if (index2 < 0) {
                    break;
                }
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] a = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = scanner.nextInt();
            }
        }
        boolean re = Solution.find(7, a);
        System.out.println(re);
    }
}
