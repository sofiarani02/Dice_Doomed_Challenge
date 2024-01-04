package dice_challenge;

public class dice_partB {
     public static void main(String[] args) {
	// TODO Auto-generated method stub
	int[] Die_A = new int[]{1,2,3,4,5,6};
	int[] Die_B = new int[]{1,2,3,4,5,6};
        int[] New_Die_A;
        int[] New_Die_B;
        int[] result = undoom_dice(Die_A, Die_B);
        New_Die_A = copyRange(result, 0, 6);
        New_Die_B = copyRange(result, 6, 12);
        System.out.println("New_Die_A: " + arrayToString(New_Die_A));
        System.out.println("New_Die_B: " + arrayToString(New_Die_B));
    }

    static int[] copyRange(int[] src, int from, int to) {
        int[] dest = new int[to - from];
        for (int i = from, j = 0; i < to; i++, j++) {
            dest[j] = src[i];
        }
        return dest;
    }

    static String arrayToString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i != arr.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    static int[] undoom_dice(int[] Die_A, int[] Die_B) {
        int[] New_Die_A = new int[6];
        int[] New_Die_B = new int[6];
        do {
            for (int i = 0; i < 6; i++) {
                New_Die_A[i] = (int) (Math.random() * 4) + 1;
            }
            for (int i = 0; i < 6; i++) {
                New_Die_B[i] = (int) (Math.random() * 20) + 1;
            }
        } while (!checkProbabilities(Die_A, Die_B, New_Die_A, New_Die_B));
        return concatArrays(New_Die_A, New_Die_B);
    }

    static boolean checkProbabilities(int[] arr1, int[] arr2, int[] arr3, int[] arr4) {
        for (int i = 2; i <= 12; i++) {
            if (findingProbability(arr1, arr2, i) != findingProbability(arr3, arr4, i)) {
                return false;
            }
        }
        return true;
    }

    static double findingProbability(int[] arr1, int[] arr2, int k) {
        int count = 0;
        for (int i : arr1) {
            for (int j : arr2) {
                int sum = i + j;
                if (sum == k) {
                    count++;
                }
            }
        }
        int ss = arr1.length * arr2.length;
        return (double) count / ss;
    }

    static int[] concatArrays(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        for (int i = 0; i < arr1.length; i++) {
            result[i] = arr1[i];
        }
        for (int i = 0; i < arr2.length; i++) {
            result[arr1.length + i] = arr2[i];
        }
        return result;
    }
}
