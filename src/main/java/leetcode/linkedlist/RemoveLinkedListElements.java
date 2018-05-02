package leetcode.linkedlist;


/**
 * Remove all elements from a linked list of integers that have value val.
 * <p>
 * Example
 * Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 * Return: 1 --> 2 --> 3 --> 4 --> 5
 */
public class RemoveLinkedListElements {

    /*
    1. temp node to move as pointer, temp.next is the essential current node
       never do "temp = xx", wrong because temp is only a pointer, and will not change actual result
    2. need a newHead for returning new List
    3. need an extra previousNode to delete what temp is pointing to
    4. handle "removing head"
    */
    public ListNode removeElements(ListNode head, int val) {

        ListNode newHead = head;

        ListNode temp = new ListNode(0);
        ListNode prev = null;

        temp.next = head;
        //  n
        //  1 2 3 4
        //    t
        while(temp.next != null){ // tail element is covered

            if(temp.next.val == val){
                // if node to remove is at head
                if(temp.next == newHead){
                    newHead = newHead.next;
                } else {
                    //use previousNode to remove
                    prev.next = temp.next.next;
                }

            } else {
                prev = temp.next;
            }

            temp.next = temp.next.next;

        }
        return newHead;

    }

    public static void main(String[] args) {
        ListNode list = ListNode.makeList(1, 2, 3, 4);
        System.out.println(list);

        System.out.println(new RemoveLinkedListElements().removeElements(list, 4));
    }

}
