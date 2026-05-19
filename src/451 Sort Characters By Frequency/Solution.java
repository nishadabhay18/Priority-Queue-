class Solution {
    // TC-> O(nlogn) SC-> O(n+k)=O(n)
    public static class Pair implements Comparable <Pair>{
        char ch;
        int freq;
        Pair(char ch, int freq){
            this.ch = ch;
            this.freq = freq;
        }
        public int compareTo(Pair p){
            // return this.freq-p.freq; ascending order
            return p.freq-this.freq;
        }
    }
    public HashMap<Character, Integer> makeMap(String str){
        int n = str.length();
        HashMap<Character, Integer> mp = new HashMap<>();
        for(int i = 0; i<n; i++){
            char ch = str.charAt(i);
            if(mp.containsKey(ch)) mp.put(ch, mp.get(ch) + 1);
            else mp.put(ch, 1);
        }
        return mp;
    }
    public String frequencySort(String str) {
        int n = str.length();
        HashMap<Character, Integer> mp = makeMap(str);
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(char ch : mp.keySet()){
            int freq = mp.get(ch);
            pq.add(new Pair(ch, freq));
        }
        StringBuilder sb = new StringBuilder();
        while(pq.size() != 0){
            Pair p = pq.remove();
            char ch = p.ch;
            int freq = p.freq;
            sb.append(String.valueOf(ch).repeat(freq));
        }
        return sb.toString();
    }
}