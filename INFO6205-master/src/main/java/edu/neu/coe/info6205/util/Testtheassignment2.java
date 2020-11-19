package edu.neu.coe.info6205.util;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Supplier;


import edu.neu.coe.info6205.sort.simple.InsertionSort;
//Chenghuan Li 001069554
public class Testtheassignment2 {

	public static void main(String[] args) {//1:Reverse 2:Order 3,Random 4,partially-ordered 
		Testtheassignment2.testthemethod(1,100);
		Testtheassignment2.testthemethod(1,200);
		Testtheassignment2.testthemethod(1,400);
		Testtheassignment2.testthemethod(1,800);
		Testtheassignment2.testthemethod(1,1600);
		Testtheassignment2.testthemethod(1,3200);
		System.out.println();
		Testtheassignment2.testthemethod(2,100);
		Testtheassignment2.testthemethod(2,200);
		Testtheassignment2.testthemethod(2,400);
		Testtheassignment2.testthemethod(2,800);
		Testtheassignment2.testthemethod(2,1600);
		Testtheassignment2.testthemethod(2,3200);
		Testtheassignment2.testthemethod(2,6400);
		Testtheassignment2.testthemethod(2,12800);
		Testtheassignment2.testthemethod(2,25600);
		Testtheassignment2.testthemethod(2,51200);
		System.out.println();
		Testtheassignment2.testthemethod(3,100);
		Testtheassignment2.testthemethod(3,200);
		Testtheassignment2.testthemethod(3,400);
		Testtheassignment2.testthemethod(3,800);
		Testtheassignment2.testthemethod(3,1600);
		Testtheassignment2.testthemethod(3,3200);
		System.out.println();
		Testtheassignment2.testthemethod(4,100);
		Testtheassignment2.testthemethod(4,200);
		Testtheassignment2.testthemethod(4,400);
		Testtheassignment2.testthemethod(4,800);
		Testtheassignment2.testthemethod(4,1600);
		Testtheassignment2.testthemethod(4,3200);
	}
	public static void testthemethod(int Kind,int n) {
		// TODO Auto-generated method stub
		InsertionSort<Integer> so = new InsertionSort<Integer>(); 
		Supplier<Integer[]> sup1 = () -> iniReInteger(n);
		Supplier<Integer[]> sup2 = () -> iniOrInteger(n);
		Supplier<Integer[]> sup3 = () -> iniRaInteger(n);
		Supplier<Integer[]> sup4 = () -> iniPaInteger(n);
		
		Consumer<Integer[]> con1 = (t)->{so.sort(t, 0,t.length);};
		Supplier<Integer[]> sup = sup1;
		if(Kind==1)
		{
			sup=sup1;
		}else if(Kind==2)
		{
			sup=sup2;
		}else if(Kind==3)
		{
			sup=sup3;
		}else if(Kind==4)
		{
			sup=sup4;
		}
		Benchmark_Timer<Integer[]> bt =new Benchmark_Timer<Integer[]>("InsertionSort",con1);
		double meantime =bt.runFromSupplier(sup, 1000);
		System.out.println("meanTime(n="+n+")"+meantime);
					
	}
	public static Integer[] iniReInteger(int n) 
	{
		Integer[] in = new Integer[n];
		int count =1;
		for(int i=0;i<n;i++)
		{
			in[i]=n+2-count;
			count++;
		}
		return in;	
	}
	public static Integer[] iniOrInteger(int n)
	{
		Integer[] in = new Integer[n];
		for(int i=0;i<n;i++)
		{
			in[i]=i+1;
		}
		return in;	
	}
	public static Integer[] iniRaInteger(int n)
	{
		Random r= new Random();
		Integer[] in = new Integer[n];
		for(int i=0;i<n;i++)
		{
			in[i]=r.nextInt(n);
		}
		return in;	
	}
	public static Integer[] iniPaInteger(int n)
	{
		Random r= new Random();
		Integer[] in = new Integer[n];
		for(int i=0;i<n/4;i++)
		{
			in[i]=i+1;
		}
		for(int i=n/4;i<n*3/4;i++)
		{
			in[i]=r.nextInt(n);
		}
		for(int i=n*3/4;i<n;i++)
		{
			in[i]=i+1;
		}
		return in;	
	}

}
