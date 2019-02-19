package com.basic.Collection;

import java.util.concurrent.ConcurrentHashMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ConcurrentHashMapExample {

	public static void main(String[] args) {
		
		
		//Fail-Safe iterator. Doesn't throw ConcurrentModificationException
		ConcurrentHashMap<String, String> premiumPhone = new ConcurrentHashMap<>();
        premiumPhone.put("Apple", "iPhone6");
        premiumPhone.put("HTC", "HTC one");
        premiumPhone.put("Samsung","S6");
        
        
        Iterator iterator = premiumPhone.keySet().iterator();
        
        while (iterator.hasNext())
        {
            System.out.println(premiumPhone.get(iterator.next()));
            premiumPhone.put("Sony", "Xperia Z");
        }
        
		/*
        //Fail-first iterator. Throws exception when the structure of map changes during iteration
		Map<String,String> premiumPhone = new HashMap<String,String>();
        premiumPhone.put("Apple", "iPhone");
        premiumPhone.put("HTC", "HTC one");
        premiumPhone.put("Samsung","S5");
        
        Iterator iterator = premiumPhone.keySet().iterator();
        
        while (iterator.hasNext())
        {
            System.out.println(premiumPhone.get(iterator.next()));
        
            premiumPhone.put("Sony", "Xperia Z"); //---------------> Exception
          //  premiumPhone.remove("Apple"); 	//-----------------> Exception
          //  iterator.remove();  //-------------------------------> No exception
        }
		*/
	}

}
