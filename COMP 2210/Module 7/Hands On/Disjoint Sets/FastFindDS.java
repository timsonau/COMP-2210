public class FastFindDS implements DisjointSet {

    private int[] id;
    private int count;

    //n represents the number of vertices
    public FastFindDS(int N) {
        count = N;
        id = new int[N];
        for(int i = 0; i < id.length; i++) {
            id[i] = i;
        }

    }
    
    @Override
    public void union(int p, int q) {
        //read as id of p
        int pid = id[p];
        int qid = id[q];
        // dont do anything if they are already connected
        if(qid == pid) return;

        //loop through the whole id array and update the compnent id of i if it is in the same component as p with the new qid
        //effectivey updates the old pid's with new qid's combining the two componenets under th qid.
        for(int i = 0; i < id.length; i++) {
            if(id[i] == pid) id[i] = qid;
        }
        //combing two components == -1 of total # of components.
        count--;
    }

    @Override
    public int find(int p) {
        return id[p];
    }

    @Override
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public int count() {
        return count;
    }
    
    
}
