package com.hit.algorithm;

public interface IAlgoCache<K,V> {

	public abstract  V getElement(K key); //Returns the value to which the specified key is mapped, or null if this cache contains no mapping for the key.
	public abstract  V putElement(K key,V value); //Associates the specified value with the specified key in this cache according to the current algorithm
	public abstract  void removeElement(K key); //Removes the mapping for the specified key from this map if present.
	
}
