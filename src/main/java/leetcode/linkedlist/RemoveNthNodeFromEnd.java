package leetcode.linkedlist;

/*
Given a linked list, remove the nth node from the end of list and return its head.
Note:
Given n will always be valid.
Try to do this in one pass.
*/
public class RemoveNthNodeFromEnd {

    // 2 ponters, after right pointer moves for (n) times, left pointer start following until
    // right pointer reach end, then left pointer is (N-1)th and ready to remove Nth
    // special case:
    // n == 1
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode right = dummy;
        ListNode left = dummy;
        // move right n times
        for (int i = 1; i <= n; i++) {
            right = right.next;
        }
        // Move right to the end, keep the gap
        //   1 2 3 4
        // - * * * -

        while (right.next != null) {
            right = right.next;
            left = left.next;
        }

        // special case left hasn't moved, remove head itself
        if (left == dummy) {
            return dummy.next.next;
        }
        //remove left's next and return head
        left.next = left.next.next;
        return head;

    }

    public static void main(String[] args) {
        ListNode list = ListNode.makeList(1, 2, 3, 4);


        System.out.println(new RemoveNthNodeFromEnd().removeNthFromEnd(list, 4));
    }

}
