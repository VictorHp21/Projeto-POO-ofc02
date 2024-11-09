import java.util.List;

public class Turma {
    private int codigoTurma;
    private Disciplina disciplina;
    private Professor professor;
    private List<Aluno> alunosTurma;

    public Turma(int codigoTurma, Disciplina disciplina, Professor professor, List<Aluno> alunosTurma) {
        this.codigoTurma = codigoTurma;
        this.disciplina = disciplina;
        this.professor = professor;
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
}
