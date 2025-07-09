public class palindromeLL {
    public boolean isPalindrome(ListNode head) {

        if(head == null || head.next == null) {
            return true;
        }
        int n = findLength(head);
        int arr[] = new int[n];
        int i = 0;
        while(head != null) {
            arr[i] = head.val;
            head = head.next;
            i++;
        }

        int start = 0, end = arr.length - 1;
        while((start < end) && arr[start] == arr[end]) {
            start++;
            end--;
        } 
        return start>=end;
    }

    private int findLength(ListNode head) {
        ListNode curr = head;
        int l = 0;
        while(curr != null) {
            l++;
            curr = curr.next;
        }
        return l;
    }
}
