package randomWork;

public class bubblesort {
    public static void main(String[] args) {
        int[] zahlenArray = {64, 34, 25, 12, 22, 11, 90};
        
        bubbleSort(zahlenArray);
        printArray(zahlenArray);
    }

    static void bubbleSort(int[] array) {
        int länge = array.length;
        
        for(int i = 0; i < länge - 1; i++) {
        	for(int j = 0; j < länge - i - 1; j++) {
        		if(array[j] < array[j + 1]) {
        			int vertauscher = array[j];
        			array[j] = array[j + 1];
        			array[j + 1] = vertauscher;
        		}
        	}
        }
    }
    
    static void printArray(int[] array) {
        int n = array.length;
        for (int i=0; i < n; ++i) {
            System.out.print(array[i] + " ");
        }
    }
    
}
