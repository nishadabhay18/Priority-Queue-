class Solution {
    // TC-> O(nlogk) SC-> O(n)
    public int findKthLargest(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int ele: arr){
            pq.add(ele);
            if(pq.size()> k) pq.remove();
        }
        return pq.peek();
    }
}