package questions;

/**
 * Created by LZP on 2017/12/21.
 * ��2*1��С���κ��Ż�������ȥ���Ǹ���ľ���
 * ������n��2*1��С�������ص��ظ���һ��2*n�Ĵ����
 * �ܹ��ж����ַ�����
 */
public class Lzp9 {
    public int RectCover(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        return RectCover(n - 1) + RectCover(n - 2);
    }
}
