import java.util.List;

public class Disciplina {
    private String nomeDisciplina;
    private int cargaHoraria;
    private int codigo;
    private List<Professor> professoresDisciplina;


    public Disciplina(String nomeDisciplina, int cargaHoraria, int codigo)
    {
        this.nomeDisciplina = nomeDisciplina;
        this.cargaHoraria = cargaHoraria;
        this.codigo = codigo;
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
