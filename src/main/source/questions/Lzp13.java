package questions;

import java.util.ArrayList;

/**
 * Created by LZP on 2018/1/7.
 * ����һ����������������е�����k����㡣
 */
public class Lzp13 {
    public ListNode FindKthToTail(ListNode head, int k) {
        if (k <= 0) return null;
        if (head == null) return null;
        ArrayList<ListNode> arrayList = new ArrayList<>();
        int count = 0;
        while (head.next != null) {
            count++;
            arrayList.add(head);
            head = head.next;
        }
        count++;
        arrayList.add(head);
        if (count - k < 0) return null;
        return arrayList.get(count - k);
    }

    //����ָ�룬�����Ƕ�ָ��ͷָ��  Ȼ���һ������k-1��
    //Ȼ������ͬ������� ����һ��������󣬵ڶ���j�͵��˵�����k��
    public ListNode FindKthToTail1(ListNode head, int k) {
        if (head == null || k <= 0) {
            return null;
        }
        ListNode pre = head;
        ListNode last = head;
        for (int i = 1; i < k; i++) {
            if (pre.next != null) {
                pre = pre.next;
            } else {
                return null;
            }
        }
        while (pre.next != null) {
            pre = pre.next;
            last = last.next;
        }
        return last;
    }
}

