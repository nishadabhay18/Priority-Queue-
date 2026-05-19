class Solution {
    // TC-> O(nLogn) SC-> O(n)
    public class Pair implements Comparable<Pair>{
        Character ch;
        int freq;
        Pair(Character ch, int freq){
            this.ch = ch;
            this.freq = freq;
        }
        public int compareTo(Pair p){
            // if(this.freq==p.freq)
            return this.freq - p.freq; // return largest frequency
        }
    }
    public HashMap<Character, Integer> makeFreq(String str){
        int n = str.length();
        HashMap<Character, Integer> mp = new HashMap<>();
        for(int i=0; i<n; i++){
            char ch = str.charAt(i);
            if(mp.containsKey(ch)) mp.put(ch, mp.get(ch) + 1);
            else mp.put(ch, 1);
        }
        return mp;
    }
    public String reorganizeString(String str) {
        int n = str.length();
        HashMap<Character,Integer> mp = makeFreq(str);
        int max = 0;
        for(int val : mp.values()){
            if(val > max) max = val;
        }
        if(max>(n+1)/2) return "";
        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(char ch : mp.keySet()){
            pq.add(new Pair(ch, mp.get(ch)));
        }
        StringBuilder sb = new StringBuilder();
        while(pq.size() > 1){
            Pair p1 = pq.poll();
            Pair p2 = pq.poll();
            sb.append(p1.ch);
            sb.append(p2.ch);
            p1.freq--;
            p2.freq--;
            if(p1.freq>0) pq.add(p1);
            if(p2.freq>0) pq.add(p2);
        }
        if(pq.size() != 0) sb.append(pq.poll().ch);
        return sb.toString();
    }
}