package leetcode.linkedlist;

/*
You are given two non-empty linked lists representing two non-negative integers.
The digits are stored in reverse order and each of their nodes contain a single digit.
Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {


        //get the first node of result
        int sum = 0;
        int value = 0;
        int carryon = 0;

        ListNode resultPointer = new ListNode(-1);

        //start iteration
        ListNode temp = resultPointer;
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        while (true) {

            if (temp1 == null && temp2 == null) {
                break;
            }

            temp.next = new ListNode(0);
            temp = temp.next;

            //reset sum every time
            sum = 0;
            if (temp1 != null) {
                sum = sum + temp1.val;
                temp1 = temp1.next;
            }

            if (temp2 != null) {
                sum = sum + temp2.val;
                temp2 = temp2.next;
            }

            sum = sum + carryon;
            value = sum % 10;
            carryon = sum / 10;

            temp.val = value;


        }

        if (carryon > 0) {
            temp.next = new ListNode(carryon);
        }

        return resultPointer.next;
    }


    public static void main(String[] args) {
        ListNode l1 = ListNode.makeList(1, 2);
        ListNode l2 = ListNode.makeList(1, 2, 3);
        ListNode res = new AddTwoNumbers().addTwoNumbers(l1, l2);
        System.out.println(res);
    }
}
