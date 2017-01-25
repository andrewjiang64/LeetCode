
public class RotateRight {
	public static void main(String[] args)
	{
		int[] nums = new int[] {1,2};
		ListNode head = new ListNode(nums[0]);
		head.next = null;
		ListNode node = head;
		for(int i = 1; i< nums.length; i++)
		{
			ListNode tmp = new ListNode(nums[i]);
			tmp.next = null;
			head.next =tmp;
			head= head.next;
		}
		ListNode ret = rotateRight(node,2);
		if(ret != null)
		{
			while(ret.next != null)
			{
				System.out.println(ret.val + "->" + ret.next.val);
				ret = ret.next;
			}
		}
	}
    public static ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null)
            return head;
          int totallength = 0;
          int rotateIndex = 0;
          int needstep = 0;
          ListNode tmp = new ListNode(0);
          tmp.next = head;
          ListNode fast = tmp;
          ListNode slow = tmp;
          while(fast.next != null)
          {
              totallength++;
              fast = fast.next;
          }
          needstep = totallength - k%totallength;
          while(rotateIndex < needstep)
          {
              slow = slow.next;
              rotateIndex++;
          }
          fast.next = tmp.next;
          tmp.next = slow.next;
          slow.next = null;
          return tmp.next;
      }
}
class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }