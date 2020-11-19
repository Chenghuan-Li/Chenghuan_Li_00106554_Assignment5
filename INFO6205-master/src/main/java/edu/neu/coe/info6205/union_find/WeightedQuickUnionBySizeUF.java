package edu.neu.coe.info6205.union_find;

import java.util.Random;

public class WeightedQuickUnionBySizeUF {
	public final int[] parent;   // parent[i] = parent of i
    private final int[] size;   // size[i] = size of subtree rooted at i
    private int count;  // number of components

    public WeightedQuickUnionBySizeUF(int n) {
        count = n;
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public void show() {
        for (int i = 0; i < parent.length; i++) {
            System.out.printf("%d: %d, %d\n", i, parent[i], size[i]);
        }
    }

    public int count() {
        return count;
    }

    public int find(int p) {
    	 validate(p);
         while (p != parent[p])
             p = parent[p];
         return p;
    }

    private void validate(int p) {
        int n = parent.length;
        if (p < 0 || p >= n) {
            throw new IllegalArgumentException("index " + p + " is not between 0 and " + (n - 1));
        }
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;
        // make smaller root point to larger one
        if (size[rootP] < size[rootQ]) {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        } else {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }
        count--;
    }
    public static Count_and_class count(int n) {
       	//chenghuan li 001069554
    	WeightedQuickUnionBySizeUF unionf = new WeightedQuickUnionBySizeUF(n);
    	Random r =new Random();
		int  count = 0;
		loop:
		while ( unionf.count> 1) 
		{
			int p = r.nextInt(n);
            int q = r.nextInt(n);
            if(p==q) {continue loop;}
			if (!unionf.connected(p, q))
			{
				unionf.union(p, q);			
			}
			count++;
		}
		Count_and_class c=new Count_and_class();
		c.w4=unionf;
		c.count=count;
		return c;
    }
}
