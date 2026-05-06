class Solution {
    // TC-> O(n)+O(nlogk)+O(klogk)+O(k) SC-> O(n)+O(k)
    public static class Pair implements Comparable<Pair>{
        String str;
        int freq;
        Pair(String str, int freq){
            this.str = str;
            this.freq = freq;
        }
        public int compareTo(Pair p){
            if(this.freq == p.freq) return p.str.compareTo(this.str);
            return this.freq - p.freq; // ascending order
            // return p.freq - this.freq; // descending order
        }
    }
    public HashMap<String, Integer> makeMap(String[] words){
        int n = words.length;
        HashMap<String, Integer> mp = new HashMap<>();
        for(String word : words){
            if(!mp.containsKey(word)) mp.put(word, 1);
            else mp.put(word, mp.get(word)+1);
        }
        return mp;
    }
    public List<String> topKFrequent(String[] words, int k) {
        int n = words.length;
        HashMap<String, Integer> mp = makeMap(words);
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(String ele : mp.keySet()){
            int freq = mp.get(ele);
            pq.add(new Pair(ele, freq));
            if(pq.size()>k) pq.remove();
        }
        List<String> ans = new ArrayList<>();
        for(int i = 0; i<k; i++){
            Pair p = pq.remove();
            String val = p.str;
            ans.add(val);
        }
        Collections.reverse(ans);
        return ans;
    }
}