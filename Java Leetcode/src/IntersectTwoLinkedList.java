
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}


public class IntersectTwoLinkedList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int m = findLength(headA);
        int n = findLength(headB);

        ListNode fp = headA, sp = headB;

        if(m<n){
            for(int i=0; i< (n-m); i++)
                sp = sp.next;
        }
        else {
            for(int i=0; i<(m-n); i++)
                fp = fp.next;
        }

        return findSameNode(fp, sp);
    }

    private ListNode findSameNode(ListNode fp, ListNode sp) {
        while(fp != null && sp != null){
            if(sp == fp)
                return fp;
            else{
                sp = sp.next;
                fp = fp.next;
            }
        }
        return null;
    }

    private int findLength(ListNode head) {
        ListNode current = head;
        int length = 0;
        while(current != null){
            length++;
            current = current.next;
        }
        return length;
    }

        public static void main(String[] args) {
        IntersectTwoLinkedList solution = new IntersectTwoLinkedList();

        
        ListNode common = new ListNode(8);
        common.next = new ListNode(4);
        common.next.next = new ListNode(5);
        
        // List A
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = common;
        
        // List B
        ListNode headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(1);
        headB.next.next.next = common;
        
        ListNode intersection = solution.getIntersectionNode(headA, headB);
        
        if(intersection != null) {
            System.out.println("Intersection found at node with value: " + intersection.val);
        } else {
            System.out.println("No intersection found");
        }
    }
}

