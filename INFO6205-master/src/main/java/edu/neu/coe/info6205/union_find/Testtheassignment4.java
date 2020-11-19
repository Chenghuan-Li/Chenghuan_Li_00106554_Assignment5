package edu.neu.coe.info6205.union_find;

import java.util.function.Consumer;
import java.util.function.Supplier;

import edu.neu.coe.info6205.util.Benchmark_Timer;

public class Testtheassignment4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Testtheassignment4.test(2000);
		Testtheassignment4.test(4000);
		Testtheassignment4.test(8000);
		Testtheassignment4.test(16000);
		Testtheassignment4.test(32000);
		Testtheassignment4.test(64000);
		Testtheassignment4.test(128000);

	}
	public static void test(int n)
	{
		Supplier<Integer> sup = ()->n ;
		
		
		Consumer<Integer> con = (pair)->{WQUPC.count(pair);};
		Benchmark_Timer<Integer> bt =new Benchmark_Timer<Integer>("W-QU-PC(twopath)",con);
		double result = bt.runFromSupplier(sup, 500);
		System.out.print("W-QU-PC(twopass) (n="+n+")"+result+"          ");
		Testtheassignment4.dep1(n);
		
		Consumer<Integer> con2 = (pair)->{WQUPChalf.count(pair);};
		Benchmark_Timer<Integer> bt2 =new Benchmark_Timer<Integer>("W-QU-PC(half)",con2);
		double result2 = bt2.runFromSupplier(sup, 500);
		System.out.print("W-QU-PC(half)    (n="+n+")"+result2+"          ");
		Testtheassignment4.dep2(n);
		
		Consumer<Integer> con3 = (pair)->{WeightedQuickUnionByHeightUF.count(pair);};
		Benchmark_Timer<Integer> bt3 =new Benchmark_Timer<Integer>("W-QU(Height)",con3);
		double result3 = bt3.runFromSupplier(sup, 500);
		System.out.print("W-QU(Height)     (n="+n+")"+result3+"          ");
		Testtheassignment4.dep3(n);
		
		Consumer<Integer> con4 = (pair)->{WeightedQuickUnionBySizeUF.count(pair);};
		Benchmark_Timer<Integer> bt4 =new Benchmark_Timer<Integer>("W-QU(Size)",con4);
		double result4 = bt4.runFromSupplier(sup, 500);
		System.out.print("W-QU(Size)       (n="+n+")"+result4+"           ");
		Testtheassignment4.dep4(n);
		System.out.println();
	}
	public static void dep1(int n) {
		double total =0;
		for(int i=0;i<1000;i++)
		{
			WQUPC w =WQUPC.count(n).w;
			int depth =0 ;
			for(int j=0;j<w.parent.length;j++)
			{
				int root = j;
				int tempD=0;
				while(root!=w.parent[root])
				{
					root=w.parent[root];
					tempD++;
				}
				if(tempD >depth)
				{
					depth=tempD;
				}
			}
			total+=depth;
		}
		System.out.println("averageDepth: "+total/1000);	
	}
	public static void dep2(int n) {
		double total =0;
		for(int i=0;i<1000;i++)
		{
			WQUPChalf w =WQUPChalf.count(n).w2;
			int depth =0 ;
			for(int j=0;j<w.parent.length;j++)
			{
				int root = j;
				int tempD=0;
				while(root!=w.parent[root])
				{
					root=w.parent[root];
					tempD++;
				}
				if(tempD >depth)
				{
					depth=tempD;
				}
			}
			total+=depth;
		}
		System.out.println("averageDepth: "+total/1000);	
	}
	public static void dep3(int n) {
		double total =0;
		for(int i=0;i<1000;i++)
		{
			WeightedQuickUnionByHeightUF w =WeightedQuickUnionByHeightUF.count(n).w3;
			int depth =0 ;
			for(int j=0;j<w.parent.length;j++)
			{
				int root = j;
				int tempD=0;
				while(root!=w.parent[root])
				{
					root=w.parent[root];
					tempD++;
				}
				if(tempD >depth)
				{
					depth=tempD;
				}
			}
			total+=depth;
		}
		System.out.println("averageDepth: "+total/1000);	
	}
	public static void dep4(int n) {
		double total =0;
		for(int i=0;i<1000;i++)
		{
			WeightedQuickUnionBySizeUF w =WeightedQuickUnionBySizeUF.count(n).w4;
			int depth =0 ;
			for(int j=0;j<w.parent.length;j++)
			{
				int root = j;
				int tempD=0;
				while(root!=w.parent[root])
				{
					root=w.parent[root];
					tempD++;
				}
				if(tempD >depth)
				{
					depth=tempD;
				}
			}
			total+=depth;
		}
		System.out.println("averageDepth: "+total/1000);	
	}
}
