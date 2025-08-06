/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class cycleLL {
    public ListNode detectCycle(ListNode head) {
        
        if(head == null || head.next == null)
            return null;
        
        ListNode slow = head, fast = head;
        while(true){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == null || fast == null || fast.next == null)
                return null;
            if(slow == fast){
                //Sure that we have a cycle
                ListNode pos = head;
                while(pos!=null){
                    if(pos == fast){
                        return pos;
                    }
                    pos = pos.next;
                    fast = fast.next;
                }
            }
        }
    }
}