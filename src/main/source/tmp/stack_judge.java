package tmp;


import org.junit.Test;

import java.util.PriorityQueue;
import java.util.Stack;

/**
 * Created by LZP on 2018/2/22.
 */
public class stack_judge {
    boolean isPopOrder(int[] array, int[] test){
        if(array==null || test==null || array.length != test.length)
            return false;

        Stack<Integer> stack = new Stack<>();
        boolean flag = false;
        int indexArray=0, indexTest=0;

        while(indexTest < test.length){
            while(indexArray < array.length){
                if(!stack.empty() && stack.peek()==test[indexTest])
                    break;

                stack.push(array[indexArray++]);
            }
            if(stack.peek() != test[indexTest])
                break;

            stack.pop();
            indexTest++;
        }

        if(stack.empty() && indexArray-indexTest==0)
            flag = true;

        return flag;
    }

    public static void main(String[] args) {
        stack_judge stack_judge=new stack_judge();
        int []a={1,2,3,4,5};
        int []b={4,3,5,1,2};
        int []c ={4,5,3,2,1};
        boolean x = stack_judge.isPopOrder(a,b);
        System.out.println(x);
    }
}
