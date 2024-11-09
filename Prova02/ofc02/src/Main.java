import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        List <Disciplina> disciplinas = new ArrayList<>();
        List <Turma> turmas = new ArrayList<>();
        gerenciaAluno gerenciaAlunoInstance = new gerenciaAluno();

        Disciplina disciplinateste = new Disciplina ("teste", 10, 1);

        disciplinas.add(disciplinateste);

        int opcao = 0;
        Scanner s = new Scanner(System.in);

        while(opcao != 15){
            menu();
            System.out.println("Escolha uma opção: ");
            opcao = s.nextInt();
            switch(opcao){
                case 1:
                System.out.println("Digite o nome do Aluno");    
                String nome = s.next();

                System.out.println("Digite a data de nascimento do Aluno");
                String dataNascimento = s.next();

                System.out.println("Digite o telefone do Aluno");
                long telefone = s.nextLong();

                System.out.println("Digite o endereço do Aluno");
                System.out.println("Rua:");
                String rua = s.next();
                System.out.println("Numero:");
                int numero = s.nextInt();
                System.out.println("Bairro:");
                String bairro = s.next();

                Endereco endereco = new Endereco(rua, numero, bairro);


                System.out.println("Digite a matricula do Aluno");
                long matricula = s.nextLong();

                System.out.println("Digite o ano de ingresso do Aluno");
                int anoIngresso = s.nextInt();

                System.out.println("Em quais diciplinas o aluno será cadastrado?");

                //listar disciplinas cadastradas

                if(disciplinas.isEmpty()){
                    System.out.println("Nenhuma disciplina encontrada");
                }else{
                    for(int i = 0; i < disciplinas.size(); i++){
                        System.out.println(disciplinas.get(i).getNomeDisciplina());
                    }
                }

                System.out.println("Selecione digite o nome da disciplina para cadastrar o aluno");
                String NomedisciplinaCadastro = s.next();

                for(int i = 0; i < disciplinas.size(); i++){
                    if(NomedisciplinaCadastro.equals(disciplinas.get(i).getNomeDisciplina())){
            
                        String DisciplinaNota = disciplinas.get(i).getNomeDisciplina();

                        System.out.println("Digite o valor da nota do Aluno nesta disciplina");
                        double valor = s.nextDouble();

                        System.out.println("Digite a data da nota do Aluno nesta disciplina");
                        String data = s.next();

                        Nota nota = new Nota(DisciplinaNota, valor, data);
                        
                        

                        Aluno aluno = new Aluno (nome, dataNascimento, telefone, endereco, matricula, anoIngresso, disciplinas);
                        aluno.adicionarNota(nota);

                        
                        aluno.getDisciplinasAluno().add(disciplinas.get(i));

                       
                       
                        gerenciaAlunoInstance.cadastrarAluno(aluno);
                    }
                }


                
                
                


                
                
                
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                //Listar alunos

                
                gerenciaAlunoInstance.listarAlunos();

                    break;
                case 7:

                    break;
                case 8:

                    break;
                case 9:

                    break;
                case 10:

                    break;
                case 11:

                    break;
                case 12:

                    break;
                case 13:

                    break;
                case 14:

                    break;
                case 15:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
                    menu();
            }
        }
       


    }

    public static void menu(){
        System.out.println("=================================================================================================\n");
        System.out.println("                                         MENU PRINCIPAL               \n"); 
        System.out.println("=================================================================================================\n");
        System.out.println("1 - Cadastrar Aluno\n");
        System.out.println("2 - Cadastrar Professor\n");
        System.out.println("3 - Cadastrar Disciplina\n");
        System.out.println("4 - Cadastrar Turma\n");
        System.out.println("5 - Inserir Nota\n");
        System.out.println("6 - Relatório Alunos\n");
        System.out.println("7 - Relatório Professores\n");
        System.out.println("8 - Relatório Disciplinas\n");
        System.out.println("9 - Relatório Turmas\n");
        System.out.println("10 - Relatório de Aluno x Notas x Média\n");
        System.out.println("11 - Quantidade de Alunos cadastrados\n");
        System.out.println("12 - Nome do Aluno uqe possui maior nota\n");
        System.out.println("13 - Listar alunos de uma determinada disciplina\n");
        System.out.println("14 - Listar as turmas que estão associadas a um determinado professor\n");
        System.out.println("15 - Sair\n");
        System.out.println("=================================================================================================\n");
    }
}
