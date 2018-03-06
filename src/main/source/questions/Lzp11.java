package questions;

/**
 * Created by LZP on 2018/1/7.
 * 给定一个double类型的浮点数base和int类型的整数exponent。
 * 求base的exponent次方。
 */
public class Lzp11 {
    public double Power(double base, int exponent) {
        double sum = 1.0;
        if (exponent == 0) return 1;
        int count = Math.abs(exponent);
        for (int i = 0; i < count; i++) {
            sum = sum * base;
        }
        if (exponent < 0) sum = 1 / sum;
        return sum;
    }
}
