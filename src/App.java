import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;
public class App {

     public static Pessoa[] vetorDePessoas() {
        return new Pessoa[]{
            new Pessoa("João", LocalDate.of(1990, 1, 1)),
            new Pessoa("Ana", LocalDate.of(1992, 2, 2)),
            new Pessoa("Maria", LocalDate.of(1995, 5, 5)),
            new Pessoa("Pedro", LocalDate.of(1993, 4, 4)),
            new Pessoa("Lucas", LocalDate.of(1991, 6, 6)),
            new Pessoa("Carlos", LocalDate.of(1988, 3, 3))
        };
    }

    public static Integer[] carregarArquivo(String nomeArquivo) throws IOException {
        List<String> linhas = Files.readAllLines(Paths.get(nomeArquivo));
        Integer[] numeros = new Integer[linhas.size()];
        for (int i = 0; i < linhas.size(); i++) {
            numeros[i] = Integer.parseInt(linhas.get(i).trim());
        }
        return numeros;
    }
    public static void main(String[] args) throws Exception {
        Scanner leia = new Scanner(System.in);
        Integer[] vetorInteiros = carregarArquivo("numeros.txt");
        System.out.println("Array:"+Arrays.toString(vetorInteiros));

        // Bubble Sort
        Integer[] vetorBubble = vetorInteiros.clone();
        BubbleSort bubbleSort = new BubbleSort();
        SortObserver observador = new SortObserver();
        bubbleSort.setObserver(observador);
        bubbleSort.sort(vetorBubble);


      /*  // Bubble Sort Otimizado
        Integer[] vetorBubbleOtimizado = vetorInteiros.clone();
        bubbleSort.sortOptimized(vetorBubbleOtimizado);
        System.out.println("Bubble Sort Otimizado - Comparações: " + bubbleSort.getContComparacao() + ", Trocas: " + bubbleSort.getContTroca());
        System.out.println("Fases: " + bubbleSort.getContFases());

        // Selection Sort
        Integer[] vetorSelection = vetorInteiros.clone();
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.sort(vetorSelection);
        System.out.println("Selection Sort - Comparações: " + selectionSort.getContComparacao() + ", Trocas: " + selectionSort.getContTroca());
        
        */
    }
}
