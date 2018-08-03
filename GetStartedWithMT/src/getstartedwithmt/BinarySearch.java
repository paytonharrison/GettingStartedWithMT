package getstartedwithmt;

import java.util.ArrayList;
import java.util.Collections;
 
public class BinarySearch {

//print statements are commented out to improve test coverage
public static int binarySearch(ArrayList<String> arrayList, String key) {
	
    //First sort an ArrayList using sort method of Collections class
    Collections.sort(arrayList);
    //System.out.println("Sorted ArrayList contains : " + arrayList);

    //search an element using binarySearch method of Collections class
    int index = Collections.binarySearch(arrayList, key);
   
    //System.out.println("Element " + key + " found at index " + index);
    return index;
  }
  
  
  //method to add smallest element to arrayList, used for testing
  public void addSmaller(ArrayList<String> arrayList) {
	  arrayList.add("-1");
  }
  
  //method to add greatest element to arrayList, used for testing
  public void removeSmaller(ArrayList<String> arrayList) {
	  arrayList.remove(0);
  }
}
