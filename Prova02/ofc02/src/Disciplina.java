import java.util.ArrayList;
import java.util.List;

public class Disciplina {
    private String nomeDisciplina;
    private int cargaHoraria;
    private int codigo;
    private List<Professor> professoresDisciplina;
    private List<Aluno> alunoscadastradosDisciplina;


    public Disciplina(String nomeDisciplina, int cargaHoraria, int codigo)
    {
        this.nomeDisciplina = nomeDisciplina;
        this.cargaHoraria = cargaHoraria;
        this.codigo = codigo;
        this.professoresDisciplina = new ArrayList<>();
        this.alunoscadastradosDisciplina = new ArrayList<>();
    }

    //metodo adicionar professor
    public void adicionarProfessor(Professor professor) {
        professoresDisciplina.add(professor);
    }

    //metodo adicionar aluno
    public void adicionarAluno(Aluno aluno) {
        alunoscadastradosDisciplina.add(aluno);
    }

    //listar alunos da dsiciplina
    public void ListarAlunosDisciplina() {
        for (Aluno aluno : alunoscadastradosDisciplina) {
            System.out.println("Nome: " + aluno.getNome() + "\n");
        }
    }

    
    //metodos getters e setters

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }
    public int getCargaHoraria() {
        return cargaHoraria;
    }
    public int getCodigo() {
        return codigo;
    }
    public List<Professor> getProfessoresDisciplina() {
        return professoresDisciplina;
    }

    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }
    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
   
    

    
}
