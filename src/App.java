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
    public static void main(String[] args)  {
        Scanner leia = new Scanner(System.in);
        Pessoa[] vetorPessoas = vetorDePessoas(); 
        System.out.println("Pessoas antes de ordenar:"+
              Arrays.toString(vetorPessoas));
        SelectionSort<Pessoa> selectionSortPessoa = new SelectionSort<>();
        //Criar comparator por data de nascimento
        Comparator<Pessoa> comparadorData = (a,b) ->  
                b.getDataNascimento().compareTo(a.getDataNascimento());
        selectionSortPessoa.sort(vetorPessoas,comparadorData);
        System.out.println("Pessoas depois de ordenar:"+
              Arrays.toString(vetorPessoas)); 
    }
}
