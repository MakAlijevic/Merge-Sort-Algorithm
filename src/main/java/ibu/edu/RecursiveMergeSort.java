package ibu.edu;

public class RecursiveMergeSort {
    public static void sort(IPAddress[] elements) {
        int elementsLength = elements.length;

        if(elementsLength < 2){
            return;
        }

        int mid = elementsLength / 2;
        IPAddress[] leftArray = new IPAddress[mid];
        IPAddress[] rightArray = new IPAddress[elementsLength-mid];

        for(int i = 0; i < mid; i++){
            leftArray[i] = elements[i];
        }
        for(int j = mid; j < elementsLength;j++){
            rightArray[j-mid] = elements[j];
        }

        sort(leftArray);
        sort(rightArray);

        merge(elements, leftArray, rightArray);
    }
    private static void merge(IPAddress[] elements, IPAddress[] leftArray, IPAddress[] rightArray){
        int leftLength = leftArray.length;
        int rightLength = rightArray.length;

        int a = 0;
        int b = 0;
        int c = 0;

        while(a < leftLength && b < rightLength){
            if(leftArray[a].compareTo(rightArray[b])<=0){
                elements[c] = leftArray[a];
                a++;
            }
            else{
                elements[c] = rightArray[b];
                b++;
            }
            c++;
        }
        while(a < leftLength){
            elements[c] = leftArray[a];
            a++;
            c++;
        }
        while(b < rightLength){
            elements[c] = rightArray[b];
            b++;
            c++;
        }
    }
}
