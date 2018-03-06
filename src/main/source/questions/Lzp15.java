package questions;

/**
 * Created by LZP on 2018/1/14.
 * 输入两个单调递增的链表
 * 输出两个链表合成后的链表
 * 当然我们需要合成后的链表满足单调不减规则。
 */
public class Lzp15 {
    //我的写法
    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode head;
        if (list1.val > list2.val) {
            head = list2;
            list2 = list2.next;
        } else {
            head = list1;
            list1 = list1.next;
        }
        ListNode tmp = head;
        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                tmp.next = list2;
                list2 = list2.next;
                tmp = tmp.next;
            } else {
                tmp.next = list1;
                list1 = list1.next;
                tmp = tmp.next;
            }
        }
        if (list2 != null) {
            while (list2 != null) {
                tmp.next = list2;
                list2 = list2.next;
                tmp = tmp.next;
            }
        }
        if (list1 != null) {
            while (list1 != null) {
                tmp.next = list1;
                list1 = list1.next;
                tmp = tmp.next;
            }
        }
        return head;
    }

    //网络的递归写法
    public ListNode Merge1(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }
        ListNode pMergeHead = null;
        if (list1.val < list2.val) {
            pMergeHead = list1;
            pMergeHead.next = Merge(list1.next, list2);
        } else {
            pMergeHead = list2;
            pMergeHead.next = Merge(list1, list2.next);
        }
        return pMergeHead;
    }
}
