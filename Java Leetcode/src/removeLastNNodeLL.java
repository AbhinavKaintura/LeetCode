// Remove the nth node from the end of the list
// Using double pointers to track the nth node as one of the them reaches to the null, then the other one is at n-1th node, so we just move the second node to the next node which is the node to be removed(slow.next).... and then remove the node by skipping the nth node.
public class removeLastNNodeLL {
    public ListNode removeNthFromEnd(ListNode head, int n){
        ListNode slow = head, fast = head;
        for(int i = 0; i < n+1; i++){
            if(fast == null){
                head = head.next;
                return head;
            }
            fast = fast.next;
        }
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next; // Learning point: i was at the n-1 node, so to remove the nth node, i didn't do slow = slow.next.next as it would skip the node after the one to be removed. 

        return head;
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static void main(String[] args) {
        // Example usage:
        removeLastNNodeLL obj = new removeLastNNodeLL();
        ListNode head = obj.new ListNode(1);
        head.next = obj.new ListNode(2);
        head.next.next = obj.new ListNode(3);
        head.next.next.next = obj.new ListNode(4);
        head.next.next.next.next = obj.new ListNode(5);

        int n = 2;
        ListNode modifiedHead = obj.removeNthFromEnd(head, n);

        // Print the modified list
        ListNode current = modifiedHead;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
