package linkedList;

public class ReverseAlternateAppendLast {
	public static void main(String [] args) {
		ListNode head = ListNode.ADT.createList();
		rearrange(head);
		ListNode.ADT.showList(head);
	}
	public static void rearrange(ListNode odd)
    {
        // add your code here
        if(odd == null || odd.next == null)
            return ;
        ListNode temp = odd,last,record;
        while(temp.next != null){
            temp = temp.next;
        }
        record = last = temp;
        
        temp = odd;
        while(temp.data != record.data || temp.next.data != record.data) {
            ListNode dummy = temp.next;
            temp.next = dummy.next;
            last.next = dummy;
            last = dummy;
            temp = temp.next;
            System.out.println("1st loop");
        }
        if(temp != record){
            temp.next = record.next;
            last.next = record;
            last = record;
            record = temp.next;
        }
        last.next = null;
        temp.next = reverse(record);
        return ;
    }
    
    static ListNode reverse(ListNode head) {
        ListNode current = head,next,prev;
        next = prev = null;
        while(current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            System.out.println("reverse loop");
        }
        return prev;
    }
}
