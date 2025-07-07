//LC 206 
// Reverse a linked list using recursionq

public class reverseLL {
    private ListNode newHead;
    public ListNode reverseList(ListNode head) {
        if(head == null) 
            return null;
        ListNode last = reverse(head);
        last.next = null;
        return newHead;
    }

    public ListNode reverse(ListNode node) {
        if(node.next == null) {
            newHead = node;
            return node;
        }
        else{
            ListNode last = reverse(node.next);
            last.next = node;
            return node;
        }
    }
}