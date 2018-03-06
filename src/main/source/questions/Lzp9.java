package questions;

/**
 * Created by LZP on 2017/12/21.
 * 用2*1的小矩形横着或者竖着去覆盖更大的矩形
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形
 * 总共有多少种方法？
 */
public class Lzp9 {
    public int RectCover(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        return RectCover(n - 1) + RectCover(n - 2);
    }
}
