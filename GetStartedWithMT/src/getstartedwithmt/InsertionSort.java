package getstartedwithmt;

//import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Arrays;

public class InsertionSort {

//constructor
public InsertionSort() {
	//empty because it's a static sort method
}


//method to sort the elements
public static int[] insertSort(int array[]) {
	
	int n = array.length;
	for (int i = 1; i < n; i++) {
		int key = array[i];
		int j = i-1;
		
		//move elements of array[0...i-1] that are greater than key
		//to one position ahead of their current position
		
		while (j >= 0 && array[j] > key) {		//changed conditional boundary
			array[j+1] = array[j];			
			j = j-1;
		}
		array[j+1] = key;
	}
	return array;
}

//method to permute the source array; used for testing
public static int[] permute(int[] array) {
	for(int i = 0; i < 2; i++) {		//changed conditional
		for(int j = array.length-1; j > 0; j--) {		 
			int temp = array[j];
			array[j] = array[j-1];
			array[j-1] = temp;
		}
	}
	return array;
}

//method to add minimum element in array, used for testing
public void addMin(int array[]) {
	array[(int)(array.length * Math.random()) ] = -1;		
}

//method to add maximum element in array, used for testing
public void addMax(int array[]) {
	array[(int)(array.length * Math.random()) ] = 101;	
}

}
