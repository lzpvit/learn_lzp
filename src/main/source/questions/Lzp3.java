package questions;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by LZP on 2017/12/10.
 */
public class Lzp3 {
    ArrayList<Integer> arrayList = new ArrayList<Integer>();

    //’ª µœ÷
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        if (listNode == null) {
            return arrayList;
        }
        Stack<ListNode> stack = new Stack<ListNode>();
        while (listNode.next != null) {
            stack.push(listNode);
            listNode = listNode.next;
        }
        stack.push(listNode);
        ListNode tmp;
        while (!stack.isEmpty()) {
            tmp = stack.pop();
            arrayList.add((Integer) tmp.val);
        }
        return arrayList;
    }

    //µ›πÈ
    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        if (listNode != null) {
            this.printListFromTailToHead1(listNode.next);
            arrayList.add(listNode.val);
        }
        return arrayList;
    }
}
