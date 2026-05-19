class Solution {
    // Brute Force TC-> O(n^2logn) SC-> O(n)
     public int lastStoneWeight(int[] arr) {
         List<Integer> ans = new ArrayList<>();
         for(int ele: arr) ans.add(ele);
         while(ans.size()>1){
             Collections.sort(ans);
             int y = ans.remove(ans.size()-1);
             int x = ans.remove(ans.size()-1);
             if(x != y)ans.add(y-x);
         }
         return (ans.size() == 0) ? 0 : ans.get(0);
     }

    // Optimised using Heaps TC-> O(nlogn) SC-> O(n)
    public int lastStoneWeight(int []arr){
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int ele: arr) pq.add(ele);
        while(pq.size()>1){
            int y = pq.remove();
            int x = pq.remove();
            if(x != y) pq.add(y-x);
        }
        return (pq.size() == 0) ? 0 : pq.peek();
    }
}