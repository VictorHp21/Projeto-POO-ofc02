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
            System.out.println("Endereço: " );
            aluno.getEndereco();
            System.out.println("Telefone: " + aluno.getTelefone());
          
           
            System.out.println("=================================================================================================\n");
        }
        
    }

    public void ListarAlunosCompleto(){
        for (Aluno aluno : alunosCadastrados) {
            System.out.println("Nome: " + aluno.getNome());
            System.out.println("Data de Nascimento: " + aluno.getDataNascimento());

            System.out.println("Notas: " );
            aluno.ListarNotas();

            System.out.println("Média: " );
            aluno.ExibirMedia();


        }
    }

    public List<Aluno> getAlunosCadastrados() {
        return alunosCadastrados;
    }

    //metodo para encontrar aluno com a maior nota
    public Aluno EncontrarAlunoMaiorNota() {
        Aluno alunoMaiorNota = null;
        double maiorNota = 0;
        for (Aluno aluno : alunosCadastrados) {
            if (aluno.getNotas().size() > 0) {
                if (aluno.getNotas().get(0).getValor() > maiorNota) {
                    maiorNota = aluno.getNotas().get(0).getValor();
                    alunoMaiorNota = aluno;
                }
            }
        }
        return alunoMaiorNota;
    }

  


   
    
}
