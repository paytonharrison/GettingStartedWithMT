package testalgorithms;

import static org.junit.jupiter.api.Assertions.*;

//import org.junit.jupiter.api.Test;
import org.junit.Test;

import getstartedwithmt.*;

import java.lang.Object.*;
import java.util.*;

//several tests added to kill targeted mutants
//not metamorphic tests
public class NonMetamorphicTests {

	
	//Insertion Sort Tests
	//instance variables for both sort methods
	int[] array = new int[10];
	
	{	
	//add in elements
	for (int i = 0; i < array.length; i++) {
		array[i] = new Integer((int)(Math.random() * 100));
	}
	}
	
	
	@Test
	//added 7/26
	//test to catch mutants in permute method
	//not metamorphic test
	public void testPermuteSwitchesOrder() {
		InsertionSort src = new InsertionSort();
		BubbleSort followUp = new BubbleSort();
		
		int[] srcArray = src.insertSort(array);
		
		assertFalse(srcArray[0] == src.permute(array)[0]);
	}
	
	@Test
	//added 7/26
	//test to make sure permuted object is not null
	//not metamorphic test
	public void testPermuteReturnObjectNotNull() {
		InsertionSort src = new InsertionSort();
		int[] permute = src.permute(array);
		
		assertNotNull(permute);
	}
	
	
	//Bubble Sort Tests...same as Insertion Sort (denoted with 2 after test call)

	@Test
	//test to make sure permuted object is not null
	//not metamorphic test
	public void testPermuteReturnObjectNotNull2() {
		BubbleSort src = new BubbleSort();
		int[] permute = src.permute(array);
		
		assertNotNull(permute);
	}
	
	@Test
	//added 7/26
	//test to catch mutants in permute method
	//not metamorphic test
	public void testPermuteSwitchesOrder2() {
		BubbleSort src = new BubbleSort();
		BubbleSort followUp = new BubbleSort();
		
		int[] srcArray = src.bubbleSort(array);
		
		assertFalse(srcArray[0] == src.permute(array)[0]);
	}
	
	//Shortest Path Tests
	
	//instance variables for shortest path
    /* Let us create the example graph discussed above */
	 int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
                              {4, 0, 8, 0, 0, 0, 0, 11, 0},
                              {0, 8, 0, 7, 0, 4, 0, 0, 2},
                              {0, 0, 7, 0, 9, 14, 0, 0, 0},
                              {0, 0, 0, 9, 0, 10, 0, 0, 0},
                              {0, 0, 4, 14, 10, 0, 2, 0, 0},
                              {0, 0, 0, 0, 0, 2, 0, 1, 6},
                              {8, 11, 0, 0, 0, 0, 1, 0, 7},
                              {0, 0, 2, 0, 0, 0, 6, 7, 0}
                             };
	@Test
	//added 7/27
	//test to catch mutants in getShortestPathFrom method
	//not metamorphic test
	public void testGetShortestPathResults() {
		ShortestPath src = new ShortestPath();
		src.shortestPath(graph, 0);

		int srcDist = src.getShortestPathFrom(5, 5);
	
		
		assertEquals(srcDist, -1);
	
	}
	
	@Test
	//added 7/27
	//test to catch mutants in getShortestPathFrom method
	//not metamorphic test
	public void testGetShortestPathResults2() {
		ShortestPath src2 = new ShortestPath();
		src2.shortestPath(graph, 0);
		
		int src2Dist = src2.getShortestPathFrom(0, 4);
		
		assertEquals(src2Dist, 21);	
	}
	
	@Test
	//added 7/27
	//test to catch mutants in getShortestPathFrom method
	//not metamorphic test
	public void testGetShortestPathResults3() {

		ShortestPath src3 = new ShortestPath();
		src3.shortestPath(graph, 0);

		int src3Dist = src3.getShortestPathFrom(6, 0);
		

		assertEquals(src3Dist, 9);		
	}

}
