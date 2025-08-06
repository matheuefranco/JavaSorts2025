import java.util.*;
public class BubbleSort<T> {
    private void troca(T[] array, int i, int j){
            T temp = array[i];
            array[i] = array[j];
            array[j] = temp;
    }   
}
