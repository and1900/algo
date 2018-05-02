package leetcode.linkedlist;

//Reverse a singly linked list.
public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        // n
        // 1->2->3
        //    t
        //       o

        ListNode headOfNew = null;
        ListNode headOfOld = head;

        ListNode temp;

        while(true){
            if(headOfOld.next == null){
                headOfOld.next = headOfNew;
                return headOfOld;
            }
            temp = headOfOld.next;
            headOfOld.next = headOfNew;
            headOfNew = headOfOld;
            headOfOld = temp;
        }

    }

    public static void main(String[] args) {
        ListNode list = ListNode.makeList(1, 2, 3, 4);

        System.out.println(new ReverseLinkedList().reverseList(list));

    }

}
