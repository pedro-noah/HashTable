public class Hash {
    private int max_posicoes;
    private int qtd_itens;
    private Aluno[] alunos;
    public Hash(int tam_vetor, int max) {
        this.max_posicoes = tam_vetor;
        this.alunos = new Aluno[tam_vetor];
    }
    public boolean estaCheio() {
        return this.qtd_itens == this.max_posicoes;
    }
    public int obterTamanhoAtual() {
        return this.qtd_itens;
    }
    public void inserir(Aluno aluno) {
        int local = FuncaoHash(aluno);
        if (this.alunos[local] != null) {
            while (this.alunos[local] != null && this.alunos[local].obteRa() > 0) {
                local = (local + 1) % this.max_posicoes;
            }
        }
        this.alunos[local] = aluno;
        this.qtd_itens++;
    }
    public void deletar(Aluno aluno) {
        int local = FuncaoHash(aluno);
        boolean teste = false;

        if (this.alunos[local] != null) {
            while (this.alunos[local] != null && this.alunos[local].obteRa() != -1) {
                if (this.alunos[local].obteRa() == aluno.obteRa()) {
                    System.out.println("Elemento Removido!");
                    Aluno alunoRemovido = new Aluno(-2, " ");
                    this.alunos[local] = alunoRemovido;
                    this.qtd_itens--;
                    teste = true;
                    break;
                }
                local = (local + 1) % this.max_posicoes;
            }
        }
        if (!teste) {
            System.out.println("O elemento não foi encontrado!");
            System.out.println("Nenhum elemento foi removido!");
        }
    }
    public Aluno buscar(int ra) {
        int local = FuncaoHash(new Aluno(ra, ""));
        Aluno alunoEncontrado = null;

        while (this.alunos[local] != null && this.alunos[local].obteRa() != -1) {
            if (this.alunos[local].obteRa() == ra) {
                alunoEncontrado = this.alunos[local];
                break;
            }
            local = (local + 1) % this.max_posicoes;
        }
        return alunoEncontrado;
    }
    public void imprimir() {
        System.out.println("Tabela Hash:");
        for (int i = 0; i < this.max_posicoes; i++) {
            if (this.alunos[i] != null && this.alunos[i].obteRa() > 0) {
                System.out.println("" + i + ":" + this.alunos[i].obteRa() + " " + this.alunos[i].obterNome());
            }
        }
    }

    private int FuncaoHash(Aluno aluno) {
        return aluno.obteRa() % this.max_posicoes;
    }

}