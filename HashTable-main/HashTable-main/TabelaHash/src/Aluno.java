public class Aluno {
    private int ra;
    private String nome;
    public Aluno(){
        // para a construcao da hash com o aluno vazio
        ra = -1;
        nome = " ";
    }
    public Aluno(int ra, String nome) {
        this.ra = ra;
        this.nome = nome;
    }
    public int obteRa(){
        return ra;
    }
    public String obterNome() {
        return nome;
    }
}
