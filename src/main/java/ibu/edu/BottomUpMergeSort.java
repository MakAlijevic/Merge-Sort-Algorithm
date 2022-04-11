package ibu.edu;

public class BottomUpMergeSort {
    public static void sort(IPAddress[] elements, sortByName sortByName) {

        IPAddress[] aux = new IPAddress[elements.length];

        for(int width = 1; width < elements.length; width = width * 2){
            for(int i = 0; i < elements.length - width; i = i + width * 2){
                int startPoint = i;
                int mid = i + width - 1;
                int endPoint = Math.min(startPoint + 2 * width - 1, elements.length - 1);

                merge(elements, aux, startPoint, mid, endPoint);
            }
        }
    }
    private static void merge(IPAddress[] elements, IPAddress[] aux, int startPoint, int mid, int endPoint){

        for(int i = startPoint;i <= endPoint;i++) {
            aux[i] = elements[i];
        }

        int i = startPoint;
        int j = mid + 1;

        for (int k = startPoint; k <= endPoint; k++) {
            if (i > mid) {
                elements[k] = aux[j++];
            } else if (j > endPoint) {
                elements[k] = aux[i++];
            } else if (aux[i].compareTo(aux[j])<0) {
                elements[k] = aux[i++];
            } else {
                elements[k] = aux[j++];
            }
        }
    }
}