public class FastUnionDS implements DisjointSet{

    private int[] id; //component id
    private int count; //number of components

    public FastUnionDS(int N) {
        id = new int[N];
        count = N;
        for(int i = 0; i < id.length; i++) {
            //creates singleton disjoint subsets/ componenets
            id[i] = i;
        }
    }

    /**
     * connects two disjoint subsets/components into one
     */
    @Override
    public void union(int p, int q) {
        int pr = find(p);
        int qr = find(q);
        if(pr == qr) return;

        id[pr] = qr;
        count--;
    }

    /**
     * finds the compnenet id of a given vertex w/ path compression
     */
    @Override
    public int find(int p) {
        int root = p;
        
        //will traverse the whole tree to find the root of p
        while(root != id[root]) {
            root = id[root]
        }
        
        while( p != root) {
            int newPID = id[p];
            id[p] = root;
            p = newPID;
        }
    }

    /**
     * checks if two vertecies are in the same component/connected
     */
    @Override
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * returns the number of components.
     */
    @Override
    public int count() {
        return count;
    }
    
}
