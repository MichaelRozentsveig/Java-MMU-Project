package com.hit.algorithm;

import java.util.ArrayList;
import java.util.HashMap;

//Not Recently Used
public class NRUAlgoCacheImpl<K,V> extends AbstractAlgoCache<K,V> {

	private HashMap<K,V>pages;
	private ArrayList<K> notRecentlyUsed;

	public NRUAlgoCacheImpl(int capacity){ //constructor
		super(capacity);
		pages = new HashMap<K,V>(capacity);
		notRecentlyUsed = new ArrayList<K>(capacity);
	}

	@Override //מחזירה דף מזיכרון אם הוא נמצא שם אחרת תחזיר NULL
	public V getElement(K key){
		if(pages.containsKey(key)) {
			int i = notRecentlyUsed.indexOf(key); //i for index
			notRecentlyUsed.remove(i);
			notRecentlyUsed.add(0,key);
			return pages.get(key);
			}
		return null;
	}

	@Override //משקף את אופן פעילות האלגוריתם
	public V putElement(K key, V value) {
		V currentVal = null;
		if(notRecentlyUsed.size() == capacity){
			currentVal=pages.get(notRecentlyUsed.get(capacity-1));
			removeElement(notRecentlyUsed.get(capacity-1));
		}
		notRecentlyUsed.add(0, key);
		pages.put(key,value);
		return currentVal;
	}

	@Override //הסרת הדף מהזיכרון אם הוא קיים
	public void removeElement(K key){
	if(pages.containsKey(key)){
		int i = notRecentlyUsed.indexOf(key);//i for index
		notRecentlyUsed.remove(i);
		pages.remove(key);
		}
	}

}
