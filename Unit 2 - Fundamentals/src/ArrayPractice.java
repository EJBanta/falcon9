
//ITCS - Array Practice

public class ArrayPractice {

	private static void printArray(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
		System.out.println();
	}
	
	private static void swapFirstLast(int[] nums) {
		int firstnum;
		int lastnum;

		firstnum = nums[0];
		lastnum = nums[nums.length - 1];

		nums[0] = lastnum;
		nums[nums.length - 1] = firstnum;

		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
		System.out.println();
	}
	
	private static double findAverage(int[] nums) {
		int total = 0;
		for (int i = 0; i < nums.length; i++) {
			total += nums[i];
		}
		int average = total / nums.length;
		return average;
	}
	
	private static int findSmallest(int[] nums) {
		int smallest = nums[0];
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < smallest) {
				smallest = nums[i];
			}
		}
		return smallest;
	}
	
	private static boolean isPresent(String[] words, String target) {
		for (int i = 0; i < words.length; i++) {
			if (words[i].equals(target)) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		//Generates a test array of variable size and values. 
		int[] testArray = new int[(int) (Math.random() * 7 + 3)];
		for (int i = 0; i < testArray.length; i++) {
			testArray[i] = (int) (Math.random() * 25);
		}
		//sample array of words
		String[] wordsTest = {"The", "wheels", "go", "round", "and", "round"}; 
		
		printArray(testArray); 
		swapFirstLast(testArray);
		swapFirstLast(testArray); // to reset the array
		System.out.println(findAverage(testArray));
		System.out.println(findSmallest(testArray));
		System.out.println(isPresent(wordsTest, "go"));
		System.out.println(isInOrder(testArray));
	}
	
	/* Optional Extra Challenge. Complete if you finish early. 
	 * Given an array, nums, return true if the elements of the array are in ascending order.
	 * return false otherwise. 
	 * Ex.
	 * {1, 5, 9, 9, 10, 50} -> In order
	 * {9, 3, 5, 10, 50, 25} -> Not In Order
	 * 
	 * Note: you may need to create your own array in main to test this
	 * 		 as the given array will very rarely be in order. 
	 */	
	public static boolean isInOrder(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
		System.out.println();

		for (int i = 1; i < nums.length; i++) {
			if (!(nums[i] >= nums[i - 1])) {
				return false;
			}
		}
		return true; 
	}	

}
