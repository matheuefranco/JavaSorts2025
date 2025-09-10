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



    
}
