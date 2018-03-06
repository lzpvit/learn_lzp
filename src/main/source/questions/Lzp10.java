package questions;

/**
 * Created by LZP on 2017/12/21.
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示
 */
public class Lzp10 {
    public int Numberof1(int n) {
        String tmp = Integer.toBinaryString(n);
        char[] a = tmp.toCharArray();
        int count = 0;
        for (char x : a) {
            if (x == '1') count++;
        }
        return count;
    }

    public int Numberof1_2(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }
}
