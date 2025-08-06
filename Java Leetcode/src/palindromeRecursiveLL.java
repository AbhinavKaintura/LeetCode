public class palindromeRecursiveLL {
    ListNode newHead;
    public boolean isPalindrome(ListNode head) {
        
        if(head == null || head.next == null)
            return true;

        int n = findLength(head);
        int reversePoint = n/2;
        if(n%2 != 0)
            reversePoint = n/2 + 1;
        
        ListNode head2 = findNodeAtPosition(head, reversePoint);
        ListNode prev = findNodeAtPosition(head, reversePoint-1);
        reverse(head2, prev);
        
        ListNode first = head;
        ListNode second = prev.next;
        
        while (first != null && second != null) {
            if (first.val != second.val) {
                return false;
            }
            first = first.next;
            second = second.next;
        }
        
        return true;
    }

    int findLength(ListNode head){
        ListNode curr = head;
        int l = 0;
        while(curr != null) {
            l++;
            curr = curr.next;
        }
        return l;
    }

    ListNode findNodeAtPosition(ListNode head, int position){
        ListNode curr = head;
        for(int i = 0; i < position; i++)
            curr = curr.next;
        return curr;
    }

    ListNode reverse(ListNode head) {
        if(head.next == null){
            newHead = head;
            return head;
        }
        else {
            ListNode last = reverse(head.next);
            last.next = head;
            return head;
        }
    }
}
