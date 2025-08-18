import java.util.*;
public class SelectionSort<T> {
    private void troca(T[] array, int i, int j){
            T temp = array[i];
            array[i] = array[j];
            array[j] = temp;
    }   

    private int indiceMenorValorVetor(T[] array, int pos, 
                                Comparator<T> comparator){
         int minIndice = pos;
         for(int i=pos+1;i<array.length;i++){
            if(comparator.compare(array[i],array[minIndice])<0)
                minIndice = i;
         }// fim for         
         return minIndice;          
    }
}
