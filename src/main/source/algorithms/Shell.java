package algorithms;

import java.util.Scanner;

/**
 * Created by LZP on 2017/12/4.
 * œ£∂˚≈≈–Ú   ”–Œ Ã‚
 */
public class Shell {
    public static void sort(Comparable []a){
        int n = a.length;
        int h = 1;
        while(h < n/3){
            h = 3*h+1;
        }
        while (h >= 1){
            for(int i = h;i<n;i++){
                for(int j = i; j >= h && less(a[j],a[j-h]);j -= h){
                    exch( a, j,j-h);
                }
                h = h/3;
            }
        }
    }
    private static boolean less(Comparable v,Comparable w){
        return v.compareTo(w)<0;
    }
    private static void exch(Comparable []a,int i,int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    public  static void show(Comparable[]a){
        for(int i=0; i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
    public static boolean isSorted(Comparable[]a){
        for (int i=1;i<a.length;i++){
            if(less(a[i],a[i-1])){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n =scanner.nextInt();
        String []a =new String[n];
        for(int i=0;i<n;i++){
            a[i]=scanner.next();
        }
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
