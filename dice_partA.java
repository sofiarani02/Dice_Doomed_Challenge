package dice_challenge;

public class dice_partA {
	static void findingProbability(int[] arr1, int[] arr2, int k) {
		int count=0;
		System.out.println("For sum = " +k );
		for(int i=0; i<arr1.length; i++) {
			for(int j=0; j<arr2.length; j++) {
				int sum = arr1[i]+arr2[j];
				//System.out.println(sum);
				if(sum==k) {
					count++;
				}
			}
		}
		System.out.println("Combinations: " + count);
		int ss = arr1.length * arr2.length;
		float p = (float)count/ss;
		System.out.println("Probability: " + p);
		System.out.println();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 = new int[] {1,2,3,4,5,6};
		int[] arr2 = new int[] {1,2,3,4,5,6};
		System.out.println(arr1.length * arr2.length + " Combinations are possible\n");	
		
		System.out.println("Printing the distribution of all possible combinations...");
		System.out.println("{");
		for(int i=0; i<arr1.length; i++) {
			for(int j=0; j<arr2.length; j++) {
				System.out.print("(" + arr1[i] + "," + arr2[j] + ")");
			}
			System.out.println();
		}
		System.out.println("}");
		System.out.println();
		
		for(int k=2; k<=12; k++) {
			findingProbability(arr1, arr2, k);
		}
	}
}
