package testalgorithms;

import static org.junit.jupiter.api.Assertions.*;
//import org.junit.jupiter.api.Test;
import org.junit.Test;

import getstartedwithmt.*;

import java.lang.Object.*;
import java.util.*;

//All of the metamorphic tests for the algorithms
public class TestAlgorithms {

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
	//permute array input, check that outputs are same
	public void testPermutate() {
		InsertionSort src = new InsertionSort();
		InsertionSort followUp = src;

		int[] srcArray = src.insertSort(array);	
		src.permute(array);
		int[] followUpArray = followUp.insertSort(array);	
		
		assertArrayEquals(srcArray, followUpArray);	
		assertNotNull(srcArray);
		assertNotNull(followUpArray);	 	
	}
	
	@Test
	//add minimum element, see if it is in first index
	public void testMin() {
		InsertionSort src = new InsertionSort();
		InsertionSort followUp = src;
		
		src.insertSort(array);
		src.addMin(array);
		followUp.insertSort(array);
		assertEquals(array[0], -1);		
	}
	
	@Test
	//add maximum element, see if it is in last index
	public void testMax() {
		InsertionSort src = new InsertionSort();
		InsertionSort followUp = src;
		
		src.insertSort(array);
		src.addMax(array);
		followUp.insertSort(array);
		assertEquals(array[array.length-1], 101);		
	}
	
//Bubble Sort Tests...same as Insertion Sort (denoted with 2 after test call)
	
	@Test
	//permute array input, check that outputs are same
	public void testPermutate2() {
		BubbleSort src = new BubbleSort();
		BubbleSort followUp = src; 

		int[] srcArray = src.bubbleSort(array);
		
		src.permute(array);
		int[] followUpArray = followUp.bubbleSort(array);
		assertArrayEquals(srcArray, followUpArray);
		assertNotNull(srcArray);
		assertNotNull(followUpArray);	
	}
	
	@Test
	//add minimum element, see if it is in first index
	public void testMin2() {
		BubbleSort src = new BubbleSort();
		BubbleSort followUp = src;
		
		src.bubbleSort(array);
		src.addMin(array);
		followUp.bubbleSort(array);
		assertEquals(array[0], -1);	
	}
	
	@Test
	//add maximum element, see if it is in last index
	public void testMax2() {
		BubbleSort src = new BubbleSort();
		BubbleSort followUp = src;
		
		src.bubbleSort(array);
		src.addMax(array);
		followUp.bubbleSort(array);
		assertEquals(array[array.length-1], 101);		
	}
	
	
//Binary Search Tests
	
	//instance variables for binary search
    ArrayList<String> arrayList = new ArrayList<String>();
    {
    //Add elements to arrayList
    arrayList.add("1");
    arrayList.add("4");
    arrayList.add("2");
    arrayList.add("5");
    arrayList.add("3"); 
	}
    
	@Test
	//add element smaller than key, see if key's index increases one
	public void testSmallerKey() {
		BinarySearch src = new BinarySearch();
		BinarySearch followUp = src;
		
		int srcIndex = src.binarySearch(arrayList, "4");
		src.addSmaller(arrayList);
		int followUpIndex = followUp.binarySearch(arrayList, "4");

		assertSame((srcIndex + 1), followUpIndex);
	}
	
	@Test
	//delete smallest element, see if key's index decreases one
	public void testRemoveSmaller() {
		BinarySearch src = new BinarySearch();
		BinarySearch followUp = src;
		
		int srcIndex = src.binarySearch(arrayList, "4");
		src.removeSmaller(arrayList);
		int followUpIndex = followUp.binarySearch(arrayList,  "4");
		
		assertSame(srcIndex, (followUpIndex + 1));
	}
	
	@Test
	//Search for a key, then in the follow up search for a different key and 
	//make sure the indices are NOT the same
	public void twoKeys() {
		BinarySearch src = new BinarySearch();
		BinarySearch followUp = src;
		
		int srcIndex = src.binarySearch(arrayList, "3");
		int followUpIndex = followUp.binarySearch(arrayList, "5");
		
		assertNotEquals(srcIndex, followUpIndex);
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
                     
    //altered so that vertex 0 is no longer connected to vertex 7
    int graph2[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 0, 0},
					        {4, 0, 8, 0, 0, 0, 0, 11, 0},
					        {0, 8, 0, 7, 0, 4, 0, 0, 2},
					        {0, 0, 7, 0, 9, 14, 0, 0, 0},
					        {0, 0, 0, 9, 0, 10, 0, 0, 0},
					        {0, 0, 4, 14, 10, 0, 2, 0, 0},
					        {0, 0, 0, 0, 0, 2, 0, 1, 6},
					        {0, 11, 0, 0, 0, 0, 1, 0, 7},
					        {0, 0, 2, 0, 0, 0, 6, 7, 0}
					       };

    
	@Test
	//see if shortest path a,b is equal to path reversed (b,a)
	public void testSamePath() {
		ShortestPath src = new ShortestPath();
		src.shortestPath(graph, 0);
		int srcDist = src.getShortestPathFrom(1,5);
		
		ShortestPath followUp = src;
		followUp.shortestPath(graph, 0);
		int followUpDist = followUp.getShortestPathFrom(5,1);
		
		assertSame(srcDist, followUpDist);
	}
	
	@Test
	//Pick point between end points in shortest path, make sure a,c + c,b = a,b

	public void testMidpoint() {
		ShortestPath src = new ShortestPath();
		src.shortestPath(graph,0);
		int srcDist = src.getShortestPathFrom(0, 3);
		
		ShortestPath followUp = src;
		followUp.shortestPath(graph, 0);
		int followUpDist1 = followUp.getShortestPathFrom(0, 2);
		int followUpDist2 = followUp.getShortestPathFrom(2, 3);
		int followUpDist = followUpDist1 + followUpDist2;
		
		assertSame(srcDist, followUpDist);	
	}
	
	@Test
	//Find shortest path between two points, change matrix to take out that path, see if shortest path increases
	
	//I manually removed the shortest path
	public void testNewPath() {
		ShortestPath src = new ShortestPath();
		src.shortestPath(graph, 0);
		int srcDist = src.getShortestPathFrom(0, 7);
		
		ShortestPath followUp = src;
		followUp.shortestPath(graph2, 0);
		int followUpDist = followUp.getShortestPathFrom(0, 7);
		
		assertEquals(srcDist, (followUpDist - 7));
	}
	
	@Test
	//test to see if result is right if source = target on getShortestPathFrom
	public void sourceEqualsTarget() {
		ShortestPath src = new ShortestPath();
		src.shortestPath(graph, 0);
		int srcDist = src.getShortestPathFrom(0, 5);
		
		ShortestPath followUp = src;
		followUp.shortestPath(graph, 0);
		int followUpDist = followUp.getShortestPathFrom(5,5);
		
		assertEquals(followUpDist, -1);		
		assertEquals((followUpDist + 12), srcDist);		
	}

}
