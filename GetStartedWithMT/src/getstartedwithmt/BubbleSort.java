package getstartedwithmt;

public class BubbleSort {

//constructor
public BubbleSort() {
	//empty because it's a static sort method
}


//method to sort the elements
public static int[] bubbleSort(int array[]) {
	
	for(int i = 0; i < array.length; i++) {	 	
		for(int j = 1; j < (array.length - i); j++) {		
			if (array[j-1] > array[j]) {		
				//swap elements
				int temp = array[j-1];
				array[j-1] = array[j];
				array[j] = temp;
			}
		}
	}
	return array;
}


//method to permute the source array; used for testing
public static int[] permute(int[] array) {
	for(int i = 0; i < 2; i++) {		
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
