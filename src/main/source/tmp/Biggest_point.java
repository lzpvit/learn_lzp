package tmp;

import java.util.*;

/**
 * Created by LZP on 2018/3/7.
 *P为给定的二维平面整数点集。定义 P 中某点x，如果x满足 P 中任意点都不在 x 的右上方区域内（横纵坐标都大于x），则称其为“最大的”。求出所有“最大的”点的集合。（所有点的横坐标和纵坐标都不重复, 坐标轴范围在[0, 1e9) 内）
 如下图：实心点为满足条件的点的集合。请实现代码找到集合 P 中的所有 ”最大“ 点的集合并输出。
 */
public class Biggest_point {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int n = scanner.nextInt();
        HashMap<Integer,Integer> v = new HashMap<Integer,Integer>();
        int []xs = new int[n];
        for (int i=0;i<n;i++){
            xs[i] =scanner.nextInt();
            v.put(xs[i],scanner.nextInt()) ;

        }
        Arrays.sort(xs);
        for(int ii = 0 ;ii<n;ii++){
            boolean stu = true;
            for(int is=ii+1;is<n;is++){
                if(v.get(xs[is])>v.get(xs[ii])){
                    stu = false;
                    break;
                }
            }
            if (stu){
                System.out.print(xs[ii]);
                System.out.print(" ");
                System.out.println(v.get(xs[ii]));
            }
        }
        /*Iterator iterator1  = v.entrySet().iterator();//hashmap遍历
        Iterator iterator2  = v.entrySet().iterator();
        ArrayList<Integer> so = new ArrayList<Integer>();

        while (iterator1.hasNext()){
            boolean status = true;
            Map.Entry entry1 = (Map.Entry) iterator1.next();
            while (iterator2.hasNext()){
                Map.Entry entry2 = (Map.Entry) iterator2.next();
                Integer key1 = (Integer)entry1.getKey();
                Integer key2 = (Integer)entry2.getKey();
                Integer v1 = (Integer)entry1.getValue();
                Integer v2 = (Integer)entry2.getValue();
                if(key2>key1&&v2>v1){
                    status = false;
                }
            }
            if(status){
                so.add((Integer) entry1.getKey());
            }
        }
        int []sorted = new int[so.size()];
        for (int ss=0;ss<so.size();ss++) {
            sorted[ss] = so.get(ss);
        }
        Arrays.sort(sorted);
        for (Object x:sorted) {
            System.out.print(x);
            System.out.print(" ");
            System.out.println(v.get(x));
        }*/
    }
}
