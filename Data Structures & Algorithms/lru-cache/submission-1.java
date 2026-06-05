class Node{
    public int key;
    public int value;
    public Node prev;
    public Node next;
    public Node(int key, int value){
        this.key = key;
        this.value = value;
    }  
}

class LRUCache {
    public HashMap<Integer, Node> cache;
    public int capacity;
    public Node left;
    public Node right;

    // all nodes between left and right
    // left-> least accessed
    // right-> recent accessed
    public LRUCache(int capacity) {
        this.cache = new HashMap<>();
        this.capacity = capacity;
        this.left = new Node(0,0);
        this.right = new Node(0,0);
        left.prev = null;
        left.next = right;
        right.prev = left;
        right.next = null;
    }
    
    // can add only at the end
    // just before right
    public void add(Node node){
        right.prev.next = node;
        node.prev = right.prev;
        node.next = right;
        right.prev = node;
    }

    // can remove from any position 
    public void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // if exist-> move node to last(recent accessed) 
    public int get(int key) {
        if(!cache.containsKey(key))
            return -1;
        Node node = cache.get(key);
        remove(node);
        add(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        // existing-> remove from both list and cache
        if(cache.containsKey(key)){
            remove(cache.get(key));
            cache.remove(key);
        }
        // make new entry 
        Node node = new Node(key, value);
        add(node);
        cache.put(key, node);
        // size going over capacity
        // evict the least accessed(left most node after left) from both cache and list
        if(cache.size() > this.capacity){
            Node evict = left.next;
            cache.remove(evict.key);
            remove(evict);
        }
    }
}
