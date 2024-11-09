import java.util.ArrayList;
import java.util.List;



public  class gerenciaAluno implements igerenciadorCadastroAluno{
    private List<Aluno> alunosCadastrados = new ArrayList<>();

    @Override
    public void cadastrarAluno(Aluno aluno) {
        System.out.println("Cadastrando Aluno...");
        alunosCadastrados.add(aluno);
    }

    @Override
    public void listarAlunos() {
        System.out.println("Os alunos cadastrados foram:");
        for (Aluno aluno : alunosCadastrados) {
            System.out.println("Nome: " + aluno.getNome());
            System.out.println("Matricula: " + aluno.getMatricula());
            System.out.println("Data de Nascimento: " + aluno.getDataNascimento());
            System.out.println("Ano de ingresso: " + aluno.getAnoIngresso());
            System.out.println("Disciplinas: ");
            aluno.ListarDisciplinasAluno();
          
            System.out.println("Notas: " );
            aluno.ListarNotas();
            System.out.println("Telefone: " + aluno.getTelefone());
            System.out.println("Endereço: " );
            aluno.getEndereco();
            System.out.println("=================================================================================================\n");
        }
        
    }

    public List<Aluno> getAlunosCadastrados() {
        return alunosCadastrados;
    }


   
    
}
