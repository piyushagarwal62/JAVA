package collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class MapImplementation {

	public static void implementingHashMap(){
		HashMap<Integer, String> hashmap = new HashMap<>();
		hashmap.put(122, "Hello");
		hashmap.put(32, "This");
		hashmap.put(45, "is");
		hashmap.put(31, "India");
		
		//Using key set
		Set<Integer> keySet = hashmap.keySet();
		Iterator<Integer> keyIterator = keySet.iterator();
		while(keyIterator.hasNext()){
			System.out.println(hashmap.get(keyIterator.next()));
		}
		
		//Using Entry set
		Set<Entry<Integer,String>> entrySet = hashmap.entrySet();
		Iterator<Entry<Integer, String>> iterator = entrySet.iterator();
		while(iterator.hasNext()){
			Entry<Integer, String> next = iterator.next();
			String value = next.getValue();
			Integer key = next.getKey();
			System.out.println(key + " : " + value);
		}
		
		System.out.println("Value found for key 31: " + hashmap.get(31));
		System.out.println("Find value for key 34: "+ hashmap.getOrDefault(34, "No value found"));
	}
	
	public static void main(String[] args) {
		implementingHashMap();
	}

}
