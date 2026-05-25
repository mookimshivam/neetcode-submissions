class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int len = position.length;
        HashMap<Integer, Double> map = new HashMap<>();
        // mapping position with time to reach
        for(int i = 0; i < len; i++){
            double time = (double)(target - position[i]) / speed[i];
            map.put(position[i], time);
        }
        // sorting the times as per  postion of cars
        List<Double> times = map.entrySet().stream().sorted(Comparator.comparingDouble(Map.Entry::getKey)).map(Map.Entry::getValue).toList();
        Stack<Double> track = new Stack<>();

        // collapsing - if slower car ahead it form a fleet
        for(double time: times){
            while(!track.isEmpty() && track.peek() <= time)
                track.pop();
            track.push(time);
        }
        return track.size();
    }
}