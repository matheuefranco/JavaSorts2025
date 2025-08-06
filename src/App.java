import java.util.*;
public class App {
    public static void main(String[] args)  {
        Scanner leia = new Scanner(System.in);
        Random rand = new Random();
        System.out.println("Tamanho do vetor:");
        int n = leia.nextInt();
        Integer[] vetor = new Integer[n];
        for (int i=0;i<n;i++)
            vetor[i] = rand.nextInt(100);

        System.out.println("Antes de ordenar:"+ 
                         Arrays.toString(vetor) );    
        BubbleSort<Integer> bsort = new BubbleSort<>();
        Comparator<Integer> comparaInt = (a,b) -> a.compareTo(b);
        bsort.sort(vetor, comparaInt, true);
       
        System.out.println("Depois de ordenar:"+ 
                         Arrays.toString(vetor) ); 
        
    }
}
