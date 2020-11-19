package edu.neu.coe.info6205.sort.par;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;

/**
 * This code has been fleshed out by Ziyao Qiao. Thanks very much.
 * TODO tidy it up a bit.
 */
class ParSort {

    public static int cutoff = 1000;

    public static void sort(int[] array, int from, int to) {
    	
        if (to - from < cutoff) Arrays.sort(array, from, to);
        else {
            CompletableFuture<int[]> parsort1 = parsort(array, from, from + (to - from) / 2); // TO IMPLEMENT
            CompletableFuture<int[]> parsort2 = parsort(array, from + (to - from) / 2, to); // TO IMPLEMENT
            CompletableFuture<int[]> parsort = parsort1.thenCombine(parsort2, (x1, x2) -> {
                int[] result = new int[x1.length + x2.length];
                // TO IMPLEMENT
                int i = 0, j = 0;
				for (int k = 0; k < result.length; k++) {
					if (i >= x1.length)
					{
				 		result[k] = x2[j++];
				 	} 		
				 	else if(j >= x2.length) {
				 		result[k] = x1[i++];
				 	}
				 	else if (x1[i]<= x2[j]) {
				 		result[k] = x1[i++];
				 	}
				 	else {
				 		result[k] = x2[j++];
				 	}
				}
		        return result;
            });

            parsort.whenComplete((result, throwable) -> System.arraycopy(result, 0, array, from, result.length));
          //  System.out.println("# threads: "+ Main.myPool.getRunningThreadCount());
            parsort.join();
        }
    }

    private static CompletableFuture<int[]> parsort(int[] array, int from, int to) {
        return CompletableFuture.supplyAsync(
                () -> {
                    int[] result = new int[to - from];
                    // TO IMPLEMENT
                    System.arraycopy(array, from, result, 0, result.length);
                    sort(result, 0, to - from);
                    return result;
                },Main.Pool
        );
    }
}