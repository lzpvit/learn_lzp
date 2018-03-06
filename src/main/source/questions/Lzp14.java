package questions;

import org.junit.Test;

/**
 * Created by LZP on 2018/1/7.
 * 输入一个链表，反转链表后，输出链表的所有元素。
 */
public class Lzp14 {
    public ListNode ReverseList(ListNode head) {
        if (head == null) return head;
        if (head.next == null) return head;
        ListNode tmp = ReverseList(head.next);//一直递归调用，tmp最初的值是链表末尾的值
        //我自己写的下面一句跟他不一样
        // tmp.next = head;
        head.next.next = head;//相当于把后面的链表翻转后将head放到最后去，而我之前用tmp   则是在后面链表的前面操作，不合理
        head.next = null;
        return tmp;

        //网上的递归例子
    /*   if(head == null || head.next == null)
            return head;
        ListNode newHead = ReverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;*/
    }

    public ListNode ReverseList1(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode newhead = null, tmp = head;
        while (head.next != null) {
            newhead = head.next; //获得下一个节点，作为链表开始的节点
            head.next = head.next.next; //丢弃刚刚获得的那个节点
            newhead.next = tmp; //新节点的下一个，第一次是head，而后是之前的新节点
            tmp = newhead;  //记录开始节点，作为下一次新节点的下一个
        }
        return newhead;

    }

    @Test
    public void test1() {
        ListNode head = new ListNode(1);
        ListNode h2 = new ListNode(2);
        ListNode h3 = new ListNode(3);
        ListNode h4 = new ListNode(4);
        ListNode h5 = new ListNode(5);
        head.next = h2;
        h2.next = h3;
        h3.next = h4;
        h4.next = h5;
        h5.next = null;
        Lzp14 lzp14 = new Lzp14();
        lzp14.ReverseList1(head);
        System.out.println("begin ...");
        head = h5;
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }


    }
}
