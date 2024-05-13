package randomWork;

public class BinarySearch {

	public static void main(String[] args) {
		int[] zahlenArray = {1, 2, 5, 7, 8, 9, 10, 22, 68, 98};
		int target = 22;
		
		BinärSuchen(zahlenArray, target);
	}
	
	public static int BinärSuchen(int[] array, int target) {
		int low = 0;
		int high = array.length -1;
		
		while(low <= high) {
			int middle = (low + high) / 2;
			int middleNumber = array[middle];
			
			if(middleNumber < target) {
				low = middle + 1;
			}
			else if(middleNumber == target) {
				System.out.println(middle);
				return middle;
				
			} else {
				high = middle - 1;
			}
		}
		return -1;
	}
}
