package questions;

import java.util.ArrayList;

/**
 * Created by LZP on 2018/1/7.
 * 输入一个链表，输出该链表中倒数第k个结点。
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

    //两个指针，让他们都指向头指针  然后第一个先走k-1步
    //然后两个同步向后走 当第一个到达最后，第二个j就到了倒数第k个
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

