import algorithms.Selection;
import org.junit.Test;

import java.util.Scanner;

/**
 * Created by LZP on 2017/12/3.
 */
public class test_selection {
    @Test
    public void test_selection(){
        Scanner scanner = new Scanner(System.in);
        int n =scanner.nextInt();
        String []a =new String[n];
        for(int i=0;i<n;i++){
            a[i]=scanner.nextLine();
        }
        Selection.sort(a);
        assert Selection.isSorted(a);
        Selection.show(a);
    }
}
