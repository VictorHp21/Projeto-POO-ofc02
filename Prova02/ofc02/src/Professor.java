import java.util.ArrayList;
import java.util.List;

public class Professor extends Pessoa{
    private String areaDeFormacao;
    private int AnoAdmissao;
    private String email;
    private List<Disciplina> disciplinasProfessor;
    private List<Turma> turmasProfessor;

    public Professor(String nome, String DataNascimento, long telefone, Endereco endereco, String areaDeFormacao, int anoAdmissao, String email) {
        super(nome, DataNascimento, telefone, endereco);
        this.areaDeFormacao = areaDeFormacao;
        this.AnoAdmissao = anoAdmissao;
        this.email = email;
        this.disciplinasProfessor = new ArrayList<>();
        this.turmasProfessor = new ArrayList<>();
       
    }

    //metodo adicionar turma
    public void adicionarTurma(Turma turma){
        turmasProfessor.add(turma);
    }

    //metodo listar turmas prof
    public void ListarTurmasProfessor(){
        int i = 0;
        for (Turma turma : turmasProfessor) {
            System.out.println("-Turma" + (i+1) + ": " + turma.getCodigoTurma() + "\n- "  + " Alunos nesta turma: " + "\n");
            turma.listarAlunosTurma();
            System.out.println("\nDisciplina");
            turma.mostrarNomeDisciplina();
            i++;
        }
    }
    


    //metodos getters e setters
    public String getNomeProfessor(){
        return getNome();
    }
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
        return disciplinasProfessor;
    }

    public String getAreaDeFormacao() {
        return areaDeFormacao;
    }

    public void setAreaDeFormacao(String areaDeFormacao) {
        this.areaDeFormacao = areaDeFormacao;
    }

    //outros metodos

    public void ListarDisciplinasProfessor(){
        int i = 0;
        for (Disciplina disciplina : disciplinasProfessor) {
            System.out.println("-Disciplina" + (i+1) + ": " + disciplina.getNomeDisciplina() + "\n- " + disciplina.getCodigo() + "\n- " + disciplina.getCargaHoraria() + "\n");
            i++;
        }
    
    }

    public void adicionarDisciplina(Disciplina disciplina){
        this.disciplinasProfessor.add(disciplina);
    }
    
}
