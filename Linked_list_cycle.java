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
public class Solution {
    public boolean hasCycle(ListNode head) {
        ArrayList<String> al=new ArrayList<>();
        ListNode temp=head;
        if(head==null)
        {
            return false;
        }
        if(head.next==null)
        {
            return false;
        }
        al.add(String.valueOf(temp));
        while(true)
        {
            if(temp!=null)
            {
                ListNode t=temp.next;
                if((al.contains(String.valueOf(t))))
                {
                    return true;
                }
                temp=temp.next;
                al.add(String.valueOf(temp));
            }
            else{
                return false;
            }
        }
    }
}
