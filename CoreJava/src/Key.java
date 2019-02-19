import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Key {
	String key;

	public Key(String key){
		this.key = key;
	}
	
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	
	
	public static void main(String[] args){
		Map<Key,String> map = new HashMap<Key, String>();
		int i = 0;
		while(i<1000){
			map.put(new Key("key"), String.valueOf(i));
			i++;
		}
		System.out.println("Map size : "+map.size());
		
		Set<Key> set = new HashSet<Key>();
		while(i<2000){
			set.add(new Key("key"));
			i++;
		}
		System.out.println("Set size : "+set.size());
	}
}
