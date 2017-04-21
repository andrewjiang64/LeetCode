
public class DeleteDuplicates {
	public static void main(String[] args)
	{
		ListNode head = new ListNode(1);
		head.next = new ListNode(1);
		head.next.next = new ListNode(2);
		head.next.next.next = null;
		deleteDuplicates(head);
	}
    public static ListNode deleteDuplicates(ListNode head) {
    	  int pre = 0;
          ListNode current = head;
          ListNode ret = new ListNode(0);
          ret.next = null;
          ListNode l = ret;
          boolean firstcheck = false;
          while(current != null)
          {
              if(current.next != null)
              {
                    if(current.val != current.next.val)
              {
                  if(!firstcheck)
                  {
                       ret.next = new ListNode(current.val);
                      ret = ret.next;
                  }
                  else if(current.val != pre)
                  {
                     ret.next = new ListNode(current.val);
                      ret = ret.next;
                  }
              }
              }
              else
              {
                  if(!firstcheck)
                  {
                       ret.next = new ListNode(current.val);
                      ret = ret.next;
                  }
                  else if(current.val != pre)
                  {
                      ret.next = current;
                      ret = ret.next;
                  }
              }
              pre = current.val;
              current = current.next;
              if(!firstcheck)
                firstcheck = true;
            
          }
          ret.next = null;
          return l.next;
    }
}
