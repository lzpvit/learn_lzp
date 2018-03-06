package questions;

import java.util.Scanner;

/**
 * Created by LZP on 2017/12/10.
 */
public class Lzp2 {
    public static String replaceSpace(StringBuffer a) {
        int n = a.length();
        String str = "";
        for (int i = 0; i < n; i++) {
            char tmp = a.charAt(i);
            if (tmp == ' ') {
                str = str.concat("%20");
            } else {
                str = str.concat(String.valueOf(tmp));
            }
        }
        return str;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        StringBuffer stringBuffer = new StringBuffer(str);
        String a = Lzp2.replaceSpace(stringBuffer);
        System.out.println(a);
    }
}
