package algorithms;

import org.junit.Test;

/**
 * Created by LZP on 2017/12/20.
 */
public class Quick2 {
    public static int partition(int []array,int lo,int hi){
        //固定的切分方式
        int key=array[lo];
        while(lo<hi){
            while(array[hi]>=key&&hi>lo){//从后半部分向前扫描
                hi--;
            }
            array[lo]=array[hi];
            while(array[lo]<=key&&hi>lo){//从前半部分向后扫描
                lo++;
            }
            array[hi]=array[lo];
        }
        array[hi]=key;
        return hi;
    }

    public static void sort(int[] array,int lo ,int hi){
        if(lo>=hi){
            return ;
        }
        int index=partition(array,lo,hi);
        sort(array,lo,index-1);
        sort(array,index+1,hi);
    }
    @Test
    public void test1(){
        int []a={12,15,3,5,8,16,25,10,9,27};
        Quick2.sort(a,0,9);
        for (int x:a) {
            System.out.print(x);
            System.out.print("  ");
        }
    }
}
