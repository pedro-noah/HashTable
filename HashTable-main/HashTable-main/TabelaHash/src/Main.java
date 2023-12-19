import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Programa gerador de Hash!");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o tamanho da Hash!");
        int tam_vetor = scanner.nextInt();

        System.out.println("Digite o numero maximo de elementos!");
        int max = scanner.nextInt();
        System.out.println("O fator de carga e: " + (float) max / (float) tam_vetor);

        Hash alunohash = new Hash(tam_vetor, max);
        int opcao;
        int ra;
        String nome;
        boolean busca = false;

        do {
            System.out.println("Digite 0 para parar o algoritmo!");
            System.out.println("Digite 1 para inserir um elemento!");
            System.out.println("Digite 2 para remover um elemento!");
            System.out.println("Digite 3 para busca um elemento!");
            System.out.println("Digite 4 para imprimir a Hash!");
            opcao = scanner.nextInt();

            if (opcao == 1) {
                System.out.println("Qual e a matricula do aluno?");
                ra = scanner.nextInt();
                System.out.println("Qual e o nome do aluno?");
                scanner.nextLine(); // Consume the newline character
                nome = scanner.nextLine();
                Aluno aluno = new Aluno(ra, nome);
                alunohash.inserir(aluno);
            } else if (opcao == 2) {
                System.out.println("Qual e a matricula do aluno a ser removido?");
                ra = scanner.nextInt();
                Aluno aluno = new Aluno(ra, " ");
                alunohash.deletar(aluno);
            } else if (opcao == 3) {
                System.out.println("Qual é a matricula do aluno a ser buscado?");
                ra = scanner.nextInt();
                Aluno alunoEncontrado = alunohash.buscar(ra);
                if (alunoEncontrado != null) {
                    System.out.println("Aluno encontrado: Matricula " + alunoEncontrado.obteRa() + ", Nome " + alunoEncontrado.obterNome());
                } else {
                    System.out.println("Aluno não encontrado.");
                }
            } else if (opcao == 4) {
                alunohash.imprimir();
            }

        } while (opcao != 0);

        scanner.close();
    }
}
