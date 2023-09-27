class LinearSearch{
    public static void search(int arr[],int val){
        int count=0;
        for(int i=0;i<arr.length;i++){
            count++;
            if(arr[i]==val){
                System.out.println("Found in "+count+" number of traversals");
                return;
            }
        }
        System.out.println("Not found and took "+count+" number of traversals");
    }
}

class BinarySearch{
    public static void search(int arr[],int val){
        int low = 0,high = arr.length-1;
        int mid,count=0;
        while(low<=high){
            count++;
            mid  = low + (high-low)/2;
            if(arr[mid]==val){
                System.out.println("Found in "+count+" number of traversals");
                return;
            }
            else if(arr[mid]<val){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        System.out.println("Not found and took "+count+" number of traversals");
    }
}

public class SearchingDemo {
    public static void main(String args[]){
        int arr[] = {1,2,3,4,5,6,8,9,10};
        LinearSearch.search(arr,8);
        System.out.println("--------");
        BinarySearch.search(arr,8);
        System.out.println("--------");
        LinearSearch.search(arr,7);
        System.out.println("--------");
        BinarySearch.search(arr,7);
    }
}
