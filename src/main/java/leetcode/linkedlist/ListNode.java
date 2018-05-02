package leetcode.linkedlist;

public class ListNode {
    public int val;
    public ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode node = this;
        while (true) {
            if (node.next == null) {
                sb.append(node.val);
                break;
            }
            sb.append(node.val).append(" -> ");
            node = node.next;
        }
        return sb.toString();
    }

    public static ListNode makeList(int... arr){
        if(arr == null || arr.length == 0){
            return null;
        }

        ListNode head = new ListNode(arr[0]);
        ListNode temp = new ListNode(0);
        temp.next = head;
        for (int i = 1; i < arr.length; i++) {
            temp.next.next = new ListNode(arr[i]);
            temp.next = temp.next.next;
        }

        return head;
    }
}
