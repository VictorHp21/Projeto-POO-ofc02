import java.util.ArrayList;
import java.util.List;

public class gerenciaProfessor implements igerenciadorCadastroProfessor {
    
    private List<Professor> professoresCadastrados = new ArrayList<>();

    @Override
    public void cadastrarProfessor(Professor professor) {
        
            System.out.println("Cadastrando Aluno...");
            professoresCadastrados.add(professor);
        
    }

    @Override
    public void listarProfessores() {
       System.out.println("Os professores cadastrados foram:");
        for (Professor professor : professoresCadastrados) {
            System.out.println("Nome: " + professor.getNome());
            System.out.println("Data de Nascimento: " + professor.getDataNascimento());
            System.out.println("Telefone: " + professor.getTelefone());
            System.out.println("Endereço: ");
            professor.getEndereco();

            System.out.println("Area de formacao: " + professor.getAreaDeFormacao());
            System.out.println("Ano de Admissao: " + professor.getAnoAdmissao());
            System.out.println("Email: " + professor.getEmail());
            System.out.println("Disciplinas: ");
            professor.ListarDisciplinasProfessor();

            System.out.println("=================================================================================================\n");
        }

    
    }

}
