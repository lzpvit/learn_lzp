package algorithms;

import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by LZP on 2017/12/18.
 * øÏ≈≈ µœ÷
 */
public class Quick1 {
    public static int [] swap(int []a,int i,int j){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
        return a;
    }
    public static void quick(int left,int right,int []a) {
     if (right!=left){
        if (right == left + 1) {
            if (a[left] < a[right]) Quick1.swap(a, left, right);
        }
        int i = left + 1;
        int j = right;
        int tmp = a[left];
        while (i < j) {
            if (a[i] > tmp && a[j] <= tmp) {
                a = Quick1.swap(a, i, j);
            }
            while (a[j] > tmp && j > i) j--;
            while (a[i] < tmp && j > i) i++;
            System.out.print(a[i]);
            System.out.println(a[j]);
        }
        a[left] = a[i];
        a[i] = tmp;
        if (i > left) {
            Quick1.quick(left, i-1, a);
        }

     if(right > j){
            if(right==j+1){
                if (a[j]>a[right])Quick1.swap(a,j,right);
                Quick1.quick(j+1,right,a);
            }else {
            Quick1.quick(j+1,right,a);
            }
        }
    }
    }

    @Test
    public  void testAll(){
        int []a ={12,5,8,9,18,25,36,10,6,17};
        Quick1.quick(0,9,a);
        for (int i:a) {
            System.out.print(i);
            System.out.print("  ");
        }
    }
    @Test
    public void testRight(){
        int []a ={12,5,8,9,18,25,36,10,6,17};
        Quick1.quick(0,9,a);
        for (int i:a) {
            System.out.print(i);
            System.out.print("  ");
        }
    }
    public static void main(String[] args) {
        //int []a ={12,5,8,9,18,25,36,10,6,17};
        int []a = {10,5,8,9,6};
        //Quick1.quick(0,9,a);
        Quick1.quick(0,4,a);
        for (int i:a) {
            System.out.print(i);
            System.out.print("  ");
        }
    }
}
