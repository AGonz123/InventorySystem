import java.util.ArrayList;
import java.util.List;

/**
 * The Class Dictionary.
 *
 * @param <K> the key type
 * @param <V> the value type
 */
public class Dictionary<K, V> {
	
	/** The entries. */
	private List<Entry<K, V>> entries;

	/**
	 * Instantiates a new dictionary.
	 */
	public Dictionary() {
		entries = new ArrayList<>();
	}
	
	/**
	 * Puts the key and a value.
	 *
	 * @param key the key
	 * @param value the value
	 */
	public void put(K key, V value) {
		boolean contains = false;
		for (Entry<K, V> e: entries) {
			if (e.getKey().equals(key)) {
				e.setValue(value);
				contains = true;
				break;
			}
		}
		if (!contains) {
			entries.add(new Entry<>(key, value));
		}
		
	}
	
	/**
	 * Gets the value by key.
	 *
	 * @param key the key
	 * @return the value
	 */
	public V get(K key) {
		for (Entry<K, V> e: entries) {
			if (e.getKey().equals(key)) {
				return e.getValue();
			}
		}
		return null;
	}
	
	/**
	 * Clears dictionary.
	 */
	public void clear() {
		entries.clear();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Entry<K, V> e: entries) {
			sb.append(e.getKey()).append(":").append(e.getValue()).append("\n");
		}
		return sb.toString();
	}
	
	/**
	 * The Class Entry.
	 *
	 * @param <K> the key type
	 * @param <V> the value type
	 */
	@SuppressWarnings("hiding")
	private class Entry<K, V> {
		
		/**
		 * Instantiates a new entry.
		 *
		 * @param key the key
		 * @param value the value
		 */
		public Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}

		/** The key. */
		private K key;
		
		/** The value. */
		private V value;

		/**
		 * Gets the key.
		 *
		 * @return the key
		 */
		public K getKey() {
			return key;
		}

		/**
		 * Gets the value.
		 *
		 * @return the value
		 */
		public V getValue() {
			return value;
		}

		/**
		 * Sets the value.
		 *
		 * @param value the new value
		 */
		public void setValue(V value) {
			this.value = value;
		}		
	}
	
} // class
