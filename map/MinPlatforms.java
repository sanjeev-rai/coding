package map;

import java.util.*;
import java.io.*;

public class MinPlatforms {
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int t = Integer.parseInt(br.readLine().trim());
	    while(t-- > 0){
	        int n = Integer.parseInt(br.readLine().trim()); 
	        String line = br.readLine();
            String[] strs = line.trim().split("\\s+");
            Map<String, Integer> arrival = new HashMap<>();
            Map<String, Integer> depart = new HashMap<>();
            for(int i=0;i<n;i++) {
            	if(arrival.containsKey(strs[i]))
            		arrival.put(strs[i], arrival.get(strs[i]) + 1);
            	else
            		arrival.put(strs[i], 1);
            }
              
            line = br.readLine();
            strs = line.trim().split("\\s+");
            for(int i=0;i<n;i++) {
            	if(depart.containsKey(strs[i]))
            		depart.put(strs[i], depart.get(strs[i]) + 1);
            	else
            		depart.put(strs[i], 1);
            }
            Set<String> times = new TreeSet<>();
            times.addAll(arrival.keySet());
            times.addAll(depart.keySet());
            int maxPlat = 0, count = 0;
            for(String time : times) {
            	if(arrival.containsKey(time))
            		count += arrival.get(time);
            	if(count > maxPlat)
            		maxPlat = count;
            	if(depart.containsKey(time))
            		count -= depart.get(time);
            	//System.out.print(time + " ");
            }
            System.out.println(maxPlat);
        }
        br.close();
	}
}
