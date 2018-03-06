package questions;

/**
 * Created by LZP on 2017/12/12.
 * 返回斐波那契数列的第n项
 */
public class Lzp7 {
    public int Fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return Fibonacci(n - 1) + Fibonacci(n - 2);
        }
    }
}
