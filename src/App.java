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
        new Pessoa("Carlos", LocalDate.of(1988, 3, 3)),
        new Pessoa("Maria", LocalDate.of(1990, 7, 7)),   // mesmo nome
        new Pessoa("Maria", LocalDate.of(1992, 8, 8)),   // mesmo nome
        new Pessoa("Felipe", LocalDate.of(1994, 9, 9)),
        new Pessoa("Bruna", LocalDate.of(1989, 10, 10))
    };
}

    static void mostrarVetorPessoas(Pessoa[] vetor) {
        for (Pessoa p : vetor) {
            System.out.println(p);
        }
        System.out.println("\n");
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
        int tamanho;
        long inicio, fim;
        Scanner leia = new Scanner(System.in);
        Comparator<Pessoa> comparadorData =  (p1, p2) -> p1.getDataNascimento().compareTo(p2.getDataNascimento());
        Comparator<Pessoa> comparadorNomeeDataNascimento =  (p1, p2) -> {
            int cmp = p1.getNome().compareTo(p2.getNome());
            if (cmp == 0) {
                cmp = p1.getDataNascimento().compareTo(p2.getDataNascimento());
            }
            return cmp;
        };

        // Bubble Sort
        Pessoa[] vetorBubble = vetorDePessoas();
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(vetorBubble, comparadorData);
        System.out.println("Vetor ordenado com Bubble Sort pela data de nascimento:");
        mostrarVetorPessoas(vetorBubble);
        bubbleSort.sort(vetorBubble);
        System.out.println("Vetor ordenado com Bubble Sort:");
        mostrarVetorPessoas(vetorBubble);


      /*   // Selection Sort
        Pessoa[] vetorSelection = vetorDePessoas();
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.sort(vetorSelection, comparadorData);
        System.out.println("Vetor ordenado com Selection Sort pela data de nascimento:");
        mostrarVetorPessoas(vetorSelection);
        selectionSort.sort(vetorSelection);
        System.out.println("Vetor ordenado com Selection Sort:");
        mostrarVetorPessoas(vetorSelection);
        */


        Busca<Pessoa> busca = new Busca<>();
        System.out.println("Entre com o nome e data de nascimento a ser buscado:");
        Scanner scanner = new Scanner(System.in);
        String nome = scanner.nextLine();
        LocalDate data = LocalDate.parse(scanner.nextLine());
        Pessoa chave = new Pessoa(nome, data);
        System.out.println("Buscar por nome[1], data de nascimento[2] ou os dois em conjunto[3]?");
        Integer tipoBusca = scanner.nextInt();
        int indice;
        if (tipoBusca==1) {
            indice = busca.binaria(vetorBubble, chave);
        } else if(tipoBusca==2 ){
            indice = busca.binaria(vetorBubble, chave, comparadorData);
        } else {
            indice = busca.binaria(vetorBubble, chave, comparadorNomeeDataNascimento);
        }
        if (indice != -1) {
            System.out.println("Pessoa encontrada: " + vetorBubble[indice] + " no índice " + indice );
        } else {
            System.out.println("Pessoa não encontrada.");
        }

      /*   // Quick Sort
        Integer[] vetor = {7, 2, 9, 4, 8, 3, 6, 1};
        QuickSort<Integer> quickSort = new QuickSort<>();
        System.out.println("Vetor inicial: " + Arrays.toString(vetor));
        quickSort.sort(vetor);
        System.out.println("\nVetor ordenado: " + Arrays.toString(vetor));*/

       /* // Insertion Sort
        Pessoa[] vetorInsertion = vetorDePessoas();
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.setObserver(new SortObserver());
        inicio = System.currentTimeMillis();
        insertionSort.sort(vetorInsertion);
        fim = System.currentTimeMillis();
        System.out.println("Insertion Sort Tempo em ms:"+ (fim-inicio)  );*/
    
    }
}
