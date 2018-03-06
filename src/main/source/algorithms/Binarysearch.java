package algorithms;

/**
 * Created by LZP on 2017/11/30.
 */
public class Binarysearch {
    //循环   二分查找
public static int serach(int key , int []a){
    int lo = 0;
    int hi = a.length-1;
    while(lo<= hi){
        int mid =(hi +lo) /2;
        if(a[mid] <key){
            System.out.print(lo);
            System.out.print(" ");
            System.out.print(mid);
            System.out.print(" ");
            System.out.println(hi);
            lo =mid+1;//加1的必要性，
        }else if (a[mid]>key){
            System.out.print(lo);
            System.out.print(" ");
            System.out.print(mid);
            System.out.print(" ");
            System.out.println(hi);

            hi = mid-1;

        }else {
            return mid;
        }
    }
    return -1;
}
public static void main(String[] args) {
    int []a={10,20 ,30, 40 ,50 ,60 ,70, 80};
    int index = Binarysearch.serach(35,a);
   // System.out.println(index);
    }
}
