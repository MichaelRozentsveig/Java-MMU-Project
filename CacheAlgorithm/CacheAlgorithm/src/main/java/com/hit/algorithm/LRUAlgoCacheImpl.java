package com.hit.algorithm;
import java.util.ArrayList;
import java.util.HashMap;

// Least Recently Used
//מוציאים את מי שהיה אחרון בשימוש
public class LRUAlgoCacheImpl<K,V> extends AbstractAlgoCache<K,V> {
	
	private HashMap<K,V>pages;
	private ArrayList<K> leastUsed;

	public LRUAlgoCacheImpl(int capacity){ //constructor
		super(capacity);
		pages = new HashMap<K,V>(capacity);
		leastUsed = new ArrayList<K>(capacity);
	}

	@Override //מחזירה דף מזיכרון אם הוא נמצא שם אחרת תחזיר NULL
	public V getElement(K key){
		if(pages.containsKey(key)) {
			int i = leastUsed.indexOf(key);//i for index
			leastUsed.remove(i);
			leastUsed.add(0,key);
			return pages.get(key);
			}
		return null;
	}

	@Override //משקף את אופן פעילות האלגוריתם
	public V putElement(K key, V value) {
		V currentVal = null;
		if(leastUsed.size() == capacity){
			currentVal=pages.get(leastUsed.get(capacity-1));
			removeElement(leastUsed.get(capacity-1));
		}
		leastUsed.add(0, key);
		pages.put(key,value);
		return currentVal;
	}

	@Override //הסרת הדף מהזיכרון אם הוא קיים
	public void removeElement(K key){
	if(pages.containsKey(key)){
		int i = leastUsed.indexOf(key);//i for index
		leastUsed.remove(i);
		pages.remove(key);
		}
	}
}

