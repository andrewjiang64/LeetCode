
public class OddEvenList {
	public static void main(String[] args)
	{
		
	}
	public static ListNode1 oddEvenList(ListNode1 head) {
        ListNode1 oddnode = new ListNode1(0);
        ListNode1 evennode = new ListNode1(0);
        ListNode1 oddnodehead = oddnode;
        ListNode1 evennodehead = evennode;
        int index = 1;
        while(head != null)
        {
            if(index % 2 != 0)
            {
                ListNode1 tmp = new ListNode1(head.val);
                tmp.next = null;
                oddnode.next = tmp;
                oddnode = oddnode.next;
            }
            else
            {
                 ListNode1 tmp = new ListNode1(head.val);
                tmp.next = null;
                evennode.next = tmp;
                evennode = evennode.next;
            }
            index++;
            head = head.next;
        }
        oddnode.next = evennodehead.next;
        return oddnodehead.next;
    }
}
class ListNode1 {
    int val;
    ListNode1 next;
    ListNode1(int x) { val = x; }
}