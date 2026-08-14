public class OddEvenWay2 {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        
        ListNode oddDummy = new ListNode(0);
        ListNode evenDummy = new ListNode(0);
        ListNode oddTail = oddDummy;
        ListNode evenTail = evenDummy;
        
        ListNode curr = head;
        int index = 1;
        
        while (curr != null) {
            if (index % 2 != 0) {
                oddTail.next = new ListNode(curr.val);
                oddTail = oddTail.next;
            } else {
                evenTail.next = new ListNode(curr.val);
                evenTail = evenTail.next;
            }
            curr = curr.next;
            index++;
        }
        
        oddTail.next = evenDummy.next;
        return oddDummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        
        ListNode res = oddEvenList(head);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
}
