class Solution {
    // TC-> O(n*n) SC-> O(n)
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                int ele = matrix[i][j];
                pq.add(ele);
                if(pq.size() > k) pq.remove();
            }
        }
        return pq.peek();
    }
}