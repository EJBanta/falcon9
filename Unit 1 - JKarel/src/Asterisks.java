public class Asterisks {

	public static void main(String[] args) {
		
		partA();	
		partB();
		partC();
		partD();
		partE();
		
	}

	/**
	 * Print the asterisks pattern in Part A
	 */
	private static void partA() {
		System.out.println("Part A\n");
      int num = 1;
      for (int i = 0; i < 10; i++) {
         for (int x = 0; x < num; x++) {
            System.out.print("*");
         }
         System.out.print("\n");
         num++;
      }
		
	}
	
	/**
	 * Print the asterisks pattern in Part B
	 */
	private static void partB() {
		System.out.println("\nPart B\n");
      int num = 10;
      for (int i = 0; i < 10; i++) {
         for (int x = 0; x < num; x++) {
            System.out.print("*");
         }
         System.out.print("\n");
         num--;
      }


	}
	
	/**
	 * Print the asterisks pattern in Part C
	 */
	private static void partC() {
		System.out.println("\nPart C\n");
      int spaceNum = 9;
      int aNum = 1;
      for (int i = 0; i < 10; i++) {
         for (int x = 0; x < spaceNum; x++) {
            System.out.print(" ");
         }
         for (int x = 0; x < aNum; x++) {
            System.out.print("*");
         }
         System.out.print("\n");
         spaceNum--;
         aNum++;
      }
	}

	/**
	 * Print the asterisks pattern in Part D
	 */
	private static void partD() {
		System.out.println("\nPart D\n");
      int spaceNum = 0;
      int aNum = 10;
      for (int i = 0; i < 10; i++) {
         for (int x = 0; x < spaceNum; x++) {
            System.out.print(" ");
         }
         for (int x = 0; x < aNum; x++) {
            System.out.print("*");
         }
         System.out.print("\n");
         spaceNum++;
         aNum--;
      }

	}

	/**
	 * Print the asterisks pattern in Part E
	 */
	private static void partE() {
		System.out.println("\nPart E\n");
      int spaceNum = 6;
      int aNum = 1;
      
      for (int y = 0; y < 6; y++) {
         for (int x = 0; x < spaceNum; x++) {
            System.out.print(" ");
         }
         for (int x = 0; x < aNum; x++) {
            System.out.print("*");
         }
         System.out.print("\n");
         spaceNum--;
         aNum = aNum + 2;
      }
      for (int y = 0; y < 7; y++) {
         for (int x = 0; x < spaceNum; x++) {
            System.out.print(" ");
         }
         for (int x = 0; x < aNum; x++) {
            System.out.print("*");
         }
         System.out.print("\n");
         spaceNum++;
         aNum = aNum - 2;

         }

	}

	

	

}