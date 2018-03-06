package questions;

import org.junit.Test;

/**
 * Created by LZP on 2018/1/7.
 * ����һ��������ת�����������������Ԫ�ء�
 */
public class Lzp14 {
    public ListNode ReverseList(ListNode head) {
        if (head == null) return head;
        if (head.next == null) return head;
        ListNode tmp = ReverseList(head.next);//һֱ�ݹ���ã�tmp�����ֵ������ĩβ��ֵ
        //���Լ�д������һ�������һ��
        // tmp.next = head;
        head.next.next = head;//�൱�ڰѺ��������ת��head�ŵ����ȥ������֮ǰ��tmp   �����ں��������ǰ�������������
        head.next = null;
        return tmp;

        //���ϵĵݹ�����
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
            newhead = head.next; //�����һ���ڵ㣬��Ϊ����ʼ�Ľڵ�
            head.next = head.next.next; //�����ոջ�õ��Ǹ��ڵ�
            newhead.next = tmp; //�½ڵ����һ������һ����head��������֮ǰ���½ڵ�
            tmp = newhead;  //��¼��ʼ�ڵ㣬��Ϊ��һ���½ڵ����һ��
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
