package hard;


class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k==1 || head == null)
            return head;

        ListNode temp = head;
        ListNode next, prev;
        int count = k, newCount = 0;

        while(count > 0 && temp != null) {
            temp = temp.next;
            count--;
            newCount++;
        }
        if (newCount == k)
            prev=reverseKGroup(temp, k);
        else
            return head;

        temp = head;
        count = k;

        while(count > 0 && temp != null) {
            next = temp.next;
            temp.next = prev;

            prev = temp;
            temp = next;
            count--;
        }

        return prev;
    }
    public static void main(String[] args) {
        // https://leetcode.com/problems/reverse-nodes-in-k-group/
    }
}