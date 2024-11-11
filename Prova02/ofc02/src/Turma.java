import java.util.ArrayList;
import java.util.List;

public class Turma {
    private int codigoTurma;
    private Disciplina disciplina;
    private Professor professor;
    private List<Aluno> alunosTurma;

    public Turma(int codigoTurma) {
        this.codigoTurma = codigoTurma;
        this.alunosTurma = new ArrayList<>();
    }

    public void adcAlunoTurma(Aluno aluno) {
        alunosTurma.add(aluno);
    }

    //metodos getters e setters
    public int getCodigoTurma() {
        return codigoTurma;
    }

    public void setCodigoTurma(int codigoTurma) {
        this.codigoTurma = codigoTurma;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }


    //metodo adiciona disciplina

    public void adicionarDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public void adicionarProfessor(Professor professor) {
        this.professor = professor;
    }

    //metodo listar alunos turma

    public void listarAlunosTurma() {
        int i = 0;
        for (Aluno aluno : alunosTurma) {

            System.out.println("Nome aluno" + (i+1) + ": " + aluno.getNome());
            i++;
        }

    }
}
