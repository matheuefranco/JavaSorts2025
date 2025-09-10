import java.util.Comparator;
public class Busca<T> {

    public int linear(T[] array, T x){
        for(int i=0;i<array.length;i++){
            if(x.equals(array[i]))
                return i;
        }// fim for
        return -1;        
    }

    public int linear(T[] array, T x, Comparator comparator){
        for(int i=0;i<array.length;i++){
            if(x.equals(array[i])) // mudar e testar no main
                return i;
        }// fim for
        return -1;        
    }

    public int binaria(T[] array, T x, Comparator<T> comparator){
        int inicio = 0;
        int fim = array.length - 1;
        while(inicio <= fim){
            int meio = (inicio + fim) / 2;
            if(comparator.compare(x, array[meio]) == 0)
                return meio;
            else if(comparator.compare(x, array[meio]) < 0)
                fim = meio - 1;
            else
                inicio = meio + 1;            
        }// fim while
        return -1;        
    }

    public int binaria(T[] array, T x){
        return binaria(array, x, (a,b)->((Comparable<T>) a).compareTo(b));
    }


    
}
