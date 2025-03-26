public class LRUCache extends LinkedHashMap<Integer, Integer> {
    private final int capacity;

    public LRUCache(int capacity) {
        // 파라미터:
        //  - initialCapacity: 해시 초기 용량 (capacity 정도로 두면 됨)
        //  - loadFactor: 해시 테이블 부하율(기본 0.75)
        //  - accessOrder: true -> 접근 순서로 정렬
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        // LinkedHashMap의 getOrDefault 이용
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        // size가 capacity보다 커지면 true -> 가장 오래된 entry 자동 제거
        return this.size() > this.capacity;
    }
}