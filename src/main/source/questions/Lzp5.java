package questions;

import java.util.Stack;

/**
 * Created by LZP on 2017/12/12.
 * 两个栈实现一个队列
 */
public class Lzp5 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        Integer integer;
        while (!stack1.isEmpty()) {
            integer = stack1.pop();
            stack2.push(integer);
        }
        stack1.push((Integer) node);
        while (!stack2.isEmpty()) {
            integer = stack2.pop();
            stack1.push(integer);
        }
    }

    public int pop() {
        return stack1.pop();
    }
}
