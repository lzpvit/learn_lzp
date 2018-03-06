package questions;

import java.util.function.DoubleToIntFunction;

/**
 * Created by LZP on 2017/12/13.
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法
 */
public class Lzp8 {
    public static double Factoria(double n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            double count = 1;
            double sum = 1;
            while (count <= n) {
                sum = sum * count;
                count++;
            }
            return sum;
        }
    }

    public int JumpFloor(int target) {
        if (target == 0) {
            return 0;
        }
        if (target == 1) {
            return 1;
        }
        double sum = 0;
        double count;
        double num2 = 0;
        double num1 = 0;
        while (num2 * 2 <= target) {
            num1 = target - 2 * num2;
            count = num1 + num2;
            double tmp;
            if (num2 != 0 && num1 != 0) {
                tmp = Lzp8.Factoria(count) / Lzp8.Factoria(num2);
                System.out.print(Lzp8.Factoria(count));
                System.out.print("  ");
                System.out.print(Lzp8.Factoria(num2));

                tmp = tmp / Lzp8.Factoria(num1);
                sum = sum + tmp;
                System.out.println(Lzp8.Factoria(num2));
            } else {
                sum = sum + 1;

            }
            // System.out.println(num1);
            num2++;
        }

        return new Double(sum).intValue();
    }

    public static void main(String[] args) {
        Lzp8 lzp8 = new Lzp8();
        int i = lzp8.JumpFloor(29);
        System.out.println(i);
    }
}
