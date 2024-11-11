import java.util.ArrayList;
import java.util.List;

public class Aluno extends Pessoa {
    private long matricula;
    private int anoIngresso;
    private List<Nota> notas;
    private List<Disciplina> disciplinasAluno;

    public Aluno(String nome, String DataNascimento, long telefone, Endereco endereco, long matricula, int anoIngresso) {
        super(nome, DataNascimento, telefone, endereco);
        this.matricula = matricula;
        this.anoIngresso = anoIngresso;
         this.notas = new ArrayList<>();
         this.disciplinasAluno = new ArrayList<>();
        
    }

    //metodo adcionar disciplina

    public void adicionarDisciplina(Disciplina disciplina) {
        this.disciplinasAluno.add(disciplina);
    }

    //metodo adicionar nota

    public void adicionarNota(Nota nota){

        this.notas.add(nota);
    }


    //metodos getters e setters

    public String getNome() {
        return super.getNome();
    }

    public String getDataNascimento() {
        return super.getDataNascimento();
    }
    public long getTelefone() {
        return super.getTelefone();
    }
    public long getMatricula() {
        return matricula;
    }

    public int getAnoIngresso() {
        return anoIngresso;
    }

    public List<Nota> getNotas() {
        return this.notas;
    }

    public void setMatricula(long matricula) {
        this.matricula = matricula;
    }

    public void setAnoIngresso(int anoIngresso) {    
        this.anoIngresso = anoIngresso;
    }

    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }  

    public List<Disciplina> getDisciplinasAluno() {
        return this.disciplinasAluno;
    }

    //outros metodos

    //calcular média

    public double calcularMedia(){
        double media = 0;
        for(Nota nota : this.notas){
            media += nota.getValor();
        }
        media /= this.notas.size();
        return media;
    }

    public void ListarDisciplinasAluno(){
        int i = 0;
        for (Disciplina disciplina : disciplinasAluno) {
            System.out.println("-Disciplina" + (i+1) + ": " + disciplina.getNomeDisciplina() + "\n- " + disciplina.getCodigo() + "\n- " + disciplina.getCargaHoraria() + "\n");
            i++;
        }
    
    }

    public void ListarNotas(){
        for (Nota nota : notas) {
            System.out.println("-Disciplina: " + nota.getDisciplinaNota() + "\n- " + nota.getValor() + "\n");
        }
    }
    
}
