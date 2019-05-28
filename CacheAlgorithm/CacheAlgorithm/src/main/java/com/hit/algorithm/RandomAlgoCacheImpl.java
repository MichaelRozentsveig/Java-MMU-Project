package com.hit.algorithm;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

//Random
public class RandomAlgoCacheImpl<K,V> extends AbstractAlgoCache<K,V> {

	private HashMap <K,V> pages;
	private ArrayList<K> randomArray;
	Random rand = new Random();
	
	 public RandomAlgoCacheImpl(int capacity) {
		super(capacity);
		pages = new HashMap<K,V>();
		randomArray = new ArrayList<K>();
	}

	@Override
	public V getElement(K key) { //מחזיר את האלמנט של המפתח
		if(pages.containsKey(key)) {
			int i = randomArray.indexOf(key);
			randomArray.remove(i);
			randomArray.add(0, key);
			return pages.get(key);
		}
		return null;
	}

	@Override
	public V putElement(K key, V value) { //מכניס אלמנט במקום אלמנט שנשלף רנדומלית
		V currentVal = null;
		int i;
		if(randomArray.size() == capacity) { // זיכרון מלא
			i = rand.nextInt(capacity);
			currentVal = pages.get(randomArray.get(i));
			removeElement(randomArray.get(i));
			}
		randomArray.add(0,key);
		pages.put(key, value);
		return currentVal;
	}

	@Override
	public void removeElement(K key) { //הוצרת אלמנט בצורה רנדומלית
		if(pages.containsKey(key)) {
			int i = randomArray.indexOf(key);
			randomArray.remove(i);
			pages.remove(key);
		}
	}
}
