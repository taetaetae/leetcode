class LRUCache {

	int size;
	LinkedHashMap<Integer, Integer> cache;
	
    public LRUCache(int capacity) {
        this.size = capacity;
        this.cache = new LinkedHashMap(); 
    }
    
    public int get(int key) {
    	if(cache.containsKey(key)) {
    		int value = cache.get(key);
    		cache.remove(key);
    		cache.put(key, value);
    		return value;
    	}
        return -1;
    }
    
    public void put(int key, int value) {
    	if(cache.containsKey(key)) {
    		cache.remove(key);
    	}
    	cache.put(key, value);
    	if(cache.size() > size) {
    		int removeKey = cache.keySet().iterator().next();
    		cache.remove(removeKey);
    	}
    	
    }
}