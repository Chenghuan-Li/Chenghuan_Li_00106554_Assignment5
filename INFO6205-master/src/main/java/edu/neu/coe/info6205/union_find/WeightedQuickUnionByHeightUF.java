package edu.neu.coe.info6205.union_find;

import java.util.Random;

public class WeightedQuickUnionByHeightUF {
    public int[] parent;   // parent[i] = parent of i
    private int[] height;   // height[i] = height of subtree rooted at i
    private int count;  // number of components
    public static double sumheight=0;

    public WeightedQuickUnionByHeightUF(int n) {
        count = n;
        parent = new int[n];
        height = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            height[i] = 1;
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
            throw new IllegalArgumentException("index " + p + " is not between 0 and " + (n-1));
        }
    }

    
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    
    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j)
            return;

        // make shorter root point to taller one
        if      (height[i] < height[j]) parent[i] = j;
        else if (height[i] > height[j]) parent[j] = i;
        else {
            parent[j] = i;
            height[i]++;
        }
        count--;
    }
    
    public static Count_and_class count(int n) {
       	//chenghuan li 001069554
    	WeightedQuickUnionByHeightUF unionf = new WeightedQuickUnionByHeightUF(n);
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
		c.w3=unionf;
		c.count=count;
		return c;
    }

    

}
