package linkedList;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class LRU {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0) {
			int cap = Integer.parseInt(br.readLine());
			LRUCache cache = new LRUCache(cap);
			StringBuilder sb = new StringBuilder();
			int n = Integer.parseInt(br.readLine());
			String [] query = br.readLine().trim().split(" ");
			for(int i=0,itr = 0;i<n;i++) {
				if("GET".equals(query[itr++])) {
					int x = cache.get(Integer.parseInt(query[itr++]));
					sb.append(x + " ");
				}else {
					int key = Integer.parseInt(query[itr++]);
					int value = Integer.parseInt(query[itr++]);
					cache.set(key, value);
				}
			}
			System.out.println(sb.toString());
		}
	}	
}

class Page
{
    int key, value;
    Page next, pre;

    Page(int key, int value)
    {
        this.key = key;
        this.value = value;
        next = pre = null;
    }
}


class LRUCache
{
    private Map<Integer, Page> hsmap;
    private int capacity, count;
    private Page head, tail;

    LRUCache(int cap)
    {
        // Intialize the cache capacity with the given 
        // cap
        this.count = 0;
        this.capacity = cap;
        this.hsmap = new HashMap<>();
        this.head = tail = null;
        
    }

    // This method works in O(1)
    public int get(int key)
    {
        // your code here
        if(hsmap.containsKey(key)){
            Page page =  hsmap.get(key);
            if(page.pre != null){
            	page.pre.next = page.next;
                if(tail==page)
                    tail = page.pre;
                page.pre = null;
                page.next = head;
                head.pre = page;
                head = page;
            }
            System.out.println(page);
            return page.value;
        }
        else
            return -1;
    }

    // This method works in O(1)
    public void set(int key, int value)
    {
        // your code here
        if(capacity == count){
            if(tail == head)
                tail = head = new Page(key, value);
            else {
                hsmap.remove(tail.key);
                tail = tail.pre;
                tail.next = null;
                Page temp = new Page(key, value);
                temp.next = head;
                head = temp;
                hsmap.put(key,temp);
            }
        }else {
            Page temp = new Page(key, value);
            temp.next = head;
            if(head != null)
                head.pre = temp;
            head = temp;
            hsmap.put(key,temp);
            count++;
            if(count == 1)
                tail = temp;
        }
    }
}
//SET 1 2 SET 2 3 GET 1 SET 3 4 SET 4 5 GET 3