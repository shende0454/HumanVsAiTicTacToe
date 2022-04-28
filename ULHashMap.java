package henderson_s.p2;

import java.util.LinkedList;
public class ULHashMap<K,V> {
private LinkedList<Mapping<K,V>>[] table;
private int totalNumOfMappings;
private int tableSize;

	@SuppressWarnings("unchecked")
	public ULHashMap() {
		table = new LinkedList[31];
	}
	@SuppressWarnings("unchecked")
	public ULHashMap(int expectedSize) {
		
		if(isPrime(expectedSize) == false )
		{
			expectedSize = nextPrime(expectedSize);
		}
		table = new LinkedList[expectedSize];
	}
	public static class Mapping<K,V> extends Object
	{
		K key;
		V value;
		public Mapping(K key, V value)
		{
			this.key = key;
			this.value = value;
		}
		public K getKey() // methods maybe private
		{
			return key;
		}
		public V getValue()
		{
			return value;
		}
	}
	public void clear()
	{
		for(int i=0; i < table.length; i++)
		{
			table[i] = null;
		}
		totalNumOfMappings = 0;
	}
	public ULHashMap<K,V> clone()
	{
		ULHashMap<K,V> clonedHashMap = new ULHashMap(this.tableSize);
		clonedHashMap.table = this.table;
		return null;
		
	}
	public boolean containsKey(K key)
	{
		int hashCode = Math.abs(key.hashCode() % table.length);
		boolean containsKey = false;
		if(table[hashCode] != null)
		{
			if(table[hashCode].pop().key == key)
			{
				containsKey = true;
			}
		}
		return containsKey;
		
	}
	
	public boolean empty() 
	{
		return table.length == 0 ;
	}
	public boolean equals(Object otherObject)
	{
		boolean isEqual = false;
	
		if(this == otherObject)
		{
			isEqual = true;
		}
			
		return isEqual;
		
	}
	private boolean isPrime(int num )
	{
		if(num <= 1)
		{
			return false;
		}
			for(int i = 2; i < num; i++)
			{
				if(num % i == 0)
				{
					return false;
				}
			}
		return true;
	}
	private int nextPrime(int num )
	{
		if(num % 2 == 0)
		{
			num++;
		}
		while(!isPrime(num))
		{
			num += 2;
		}
		return num;
	}
	public void erase(K key)
	{
		int index = Math.abs(key.hashCode()) % table.length;
		if(table[index].contains(key))
		{
			table[index].remove(key);
			totalNumOfMappings--;
		}
		if(table[index] == null)
		{
			tableSize--;
		}
		
	}
	public void insert(K key, V value)
	{
		int index = Math.abs(key.hashCode()) % table.length;
		if(table[index] == null)
		{
			table[index] = new LinkedList<>();
			table[index].add(new Mapping<K,V>(key,value));
			tableSize++;
		}
		else
		{
			table[index].add(new Mapping<K,V>(key,value));
		}
		totalNumOfMappings++;
	}
	
	public java.util.Iterator<ULHashMap.Mapping<K, V>> iterator()
	{
		return new java.util.Iterator<ULHashMap.Mapping<K, V>>()
		{
		@Override
		public boolean hasNext()
		{
			boolean hasNext= false;
			for(int i = 0; i < table.length; i++)
			{
				if(table[i] != null)
				{
					hasNext = true;
				}
				else 
				{
					hasNext = false;
				}
			}
			return hasNext;
		}

		@Override
		public Mapping<K, V> next()
		{
			boolean isNext = true;
			Mapping<K, V> eachMap = null;
			for(int i = 0; i < table.length; i++)
			{
				if(table[i] != null)
				{
					if(table[i].get(i) != null)
					{
					eachMap = table[i].get(i);
					}
					else if(table[i].get(i) == null)
					{
						isNext = false;
					}
				}
			}
			if( isNext == false)
			{
				throw new java.util.NoSuchElementException();
			}
			return eachMap;
		
		}
		};
	}
	public V lookUp(K key)
	{
		V foundKeyValue = null;
		int index = Math.abs(key.hashCode()) % table.length;
		for(int i = 0 ; i < table[index].size(); i++)
		{
			if(table[index].get(i).equals(key))
			{
				 foundKeyValue = table[index].get(i).value;
			}
		}
		return foundKeyValue;
	}
	public void put(K key, V value) throws Exception
	{
		if(key == null)
		{
			throw new NullPointerException();
		}
		int index = Math.abs(key.hashCode()) % table.length;
		for(int i =0; i < table[index].size();i++)
			{
		if(table[index].get(i).equals(key))
		{
			table[index].get(i).value = value;
		}
		else
		{
			table[index].add(new Mapping<>(key, value));
		}
			}
		
	}
	public int size()
	{
		return totalNumOfMappings;
	}
	public int tableSize()
	{
		for(int i=0; i < table.length; i++)
		{
			if(table[i] != null)
			{
				tableSize++;
			}
		}
		return tableSize;
		

	}
	

}
