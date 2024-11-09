import java.util.List;

public class Professor extends Pessoa{
    private String areaDeFormacao;
    private int AnoAdmissao;
    private String email;
    private List<Disciplina> disciplinas;

    public Professor(String nome, String DataNascimento, long telefone, Endereco endereco, String areaDeFormacao, int anoAdmissao, String email, List<Disciplina> disciplinas) {
        super(nome, DataNascimento, telefone, endereco);
        this.areaDeFormacao = areaDeFormacao;
        this.AnoAdmissao = anoAdmissao;
        this.email = email;
        this.disciplinas = disciplinas;
    }
    


    //metodos getters e setters
    public int getAnoAdmissao(){
        return AnoAdmissao;
    }

    public void setAnoAdmissao(int AnoAdmissao){
        this.AnoAdmissao = AnoAdmissao;
    }

    public String getEmail(){    
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public List<Disciplina> getDisciplinas(){
        return disciplinas;
    }

    public String getAreaDeFormacao() {
        return areaDeFormacao;
    }

    public void setAreaDeFormacao(String areaDeFormacao) {
        this.areaDeFormacao = areaDeFormacao;
    }

    //outros metodos

    public void ListarDisciplinasProfessor(){
        for (Disciplina disciplina : disciplinas) {
            System.out.println("- " + disciplina.getNomeDisciplina() + "\n- " + disciplina.getCodigo() + "\n- " + disciplina.getCargaHoraria() + "\n");
        }
    
    }
    
}
