class Solution {
    // TC-> O(nlogk) SC-> O(n)
    public static class Pair implements Comparable<Pair>{
        int ele;
        int freq;
        Pair(int ele, int freq){
            this.ele = ele;
            this.freq = freq;
        }
        public int compareTo(Pair p){
            return this.freq - p.freq;
        }
    }
    public int[] topKFrequent(int[] arr, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int ele: arr){
            if(map.containsKey(ele)) map.put(ele, map.get(ele) + 1);
            else map.put(ele, 1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int ele: map.keySet()){
            int freq = map.get(ele);
            pq.add(new Pair(ele, freq));
            if(pq.size() > k) pq.remove();
        }
        int[] ans = new int[k];
        for(int i=0; i<k; i++){
            Pair p = pq.remove();
            ans[i] = p.ele;
        }
        return ans;
    }
}