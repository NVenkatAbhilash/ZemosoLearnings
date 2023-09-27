class DifferentSorts {
    public static void swap(int arr[], int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    public static void selectionSort(int arr[]) {
        int len = arr.length, count = 0;
        for (int i = 0; i < len - 1; i++) {
            int ind = i;
            for (int j = i + 1; j < len; j++) {
                count++;
                if (arr[ind] > arr[j])
                    ind = j;
            }
            swap(arr, i, ind);
        }
    }


    public static void insertionSort(int arr[]) {
        int len = arr.length, count = 0;
        for (int i = 1; i < len; i++) {
            int j = i;
            while (j > 0 && arr[j] < arr[j - 1]) {
                count++;
                swap(arr, j, j - 1);
                j--;
            }
        }
    }
}

class MergeSort extends DifferentSorts {
    public static void sort(int arr[], int low, int high) {
        if (high <= low)
            return;
        int mid = low + (high - low) / 2;
        sort(arr, low, mid);
        sort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }

    public static void merge(int arr[], int low, int mid, int high) {
        int size1 = mid - low + 1;
        int size2 = high - mid;

        int left[] = new int[size1];
        int right[] = new int[size2];

        for (int i = 0; i < size1; i++) {
            left[i] = arr[low + i];
        }

        for (int i = 0; i < size2; i++) {
            right[i] = arr[mid + i + 1];
        }

        int leftInd = 0, rightInd = 0;
        int index = low;

        while (leftInd < size1 && rightInd < size2) {
            if (left[leftInd] < right[rightInd]) {
                arr[index] = left[leftInd];
                leftInd++;
            } else {
                arr[index] = right[rightInd];
                rightInd++;
            }
            index++;
        }

        while (leftInd < size1) {
            arr[index] = left[leftInd];
            leftInd++;
            index++;
        }

        while (rightInd < size2) {
            arr[index] = right[rightInd];
            rightInd++;
            index++;
        }
    }
}


public class BenchMarkingDemo {
    public static void main(String args[]) {
        long startTime, endTime;
        double estimateTime;

        int arr[] = {6, 4, 17, 2, 18, 5, 11, 9, 0};
        startTime = System.nanoTime();
        DifferentSorts.insertionSort(arr);
        endTime = System.nanoTime();
        estimateTime = (endTime - startTime) / 100000000.0;
        System.out.println("Insertion Sort time taken is " + estimateTime + "\n");

        int arr2[] = {6, 4, 17, 2, 18, 5, 11, 9, 0};
        startTime = System.nanoTime();
        MergeSort.sort(arr2, 0, arr2.length - 1);
        endTime = System.nanoTime();
        estimateTime = (endTime - startTime) / 100000000.0;
        System.out.println("Merge Sort time taken is " + estimateTime + "\n");

        int arr1[] = {6, 4, 17, 2, 18, 5, 11, 9, 0};
        startTime = System.nanoTime();
        DifferentSorts.selectionSort(arr1);
        endTime = System.nanoTime();
        estimateTime = (endTime - startTime) / 100000000.0;
        System.out.println("Selection Sort time taken is " + estimateTime + "\n");


    }
}
