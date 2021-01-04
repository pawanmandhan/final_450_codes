
public class MinMax {
    static class Pair {
        int min;
        int max;

        public Pair() {
        }

        public Pair(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }

    static Pair getMinMax(int arr[], int low, int high) {
        // If there is only one element
        if (low == high) return new Pair(arr[low], arr[low]);

        // If there are more than 2 elements
        int mid = (low + high) / 2;
        Pair mmLeft = getMinMax(arr, low, mid);
        Pair mmRight = getMinMax(arr, mid + 1, high);
        Pair pair = new Pair();

        // compare minimums of two parts
        pair.min = (mmLeft.min < mmRight.min) ? mmLeft.min : mmRight.min;

        // compare maximums of two parts
        pair.max = (mmLeft.max > mmRight.max) ? mmLeft.max : mmRight.max;
        return pair;
    }

    static Pair getMinMax(int arr[], int n) {
        if (n == 1) {
            return new Pair(arr[0], arr[0]);
        }
        Pair pair = new Pair(Integer.MAX_VALUE, Integer.MIN_VALUE);
        for (int i = 0; i < n; i++) {
            if (arr[i] > pair.max) {
                pair.max = arr[i];
            } else if (arr[i] < pair.min) {
                pair.min = arr[i];
            }
        }
        return pair;
    }

    public static void main(String args[]) {
        int arr[] = {3000, 2};
        int arr_size = arr.length;
        Pair minMax = getMinMax(arr, arr_size);
        System.out.println("Minimum element is " + minMax.min);
        System.out.println("Maximum element is " + minMax.max);
    }
}
