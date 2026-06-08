class TimeMap {
    Map<String, TreeMap<Integer, String>> map;

    public TimeMap() {
        this.map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        TreeMap<Integer, String> time;
        if(map.containsKey(key))
            time = map.get(key);
        else 
            time = new TreeMap<Integer, String>();
        time.put(timestamp, value);
        map.put(key, time);
    }
    
    public String get(String key, int timestamp) {
        TreeMap<Integer, String> time;
        if(!map.containsKey(key))
            return "";
        
        time = map.get(key);
        Integer tKey = time.floorKey(timestamp);
        if(tKey != null)
            return time.get(tKey);

        return "";
    }
}
