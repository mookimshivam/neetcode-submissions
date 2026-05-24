class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] result = new int[len];
        // tracking via index not temp directly
        Stack<Integer> toProcess = new Stack<>();
        // single pass
        for(int i = 0; i < len; i++){
            // pop until there is un-processed less-temp
            while(!toProcess.isEmpty() && temperatures[toProcess.peek()] < temperatures[i]){
                int atProcess = toProcess.pop();
                result[atProcess] = i - atProcess;
            }
            // puch current temp for processing
            toProcess.push(i);
        }
        // process the remaining days temp
        while(!toProcess.isEmpty())
            result[toProcess.pop()] = 0;

        return result;
    }
}