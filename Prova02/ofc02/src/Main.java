import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        List <Disciplina> disciplinas = new ArrayList<>();
        List <Turma> turmas = new ArrayList<>();
        gerenciaAluno gerenciaAlunoInstance = new gerenciaAluno();
        gerenciaProfessor gerenciaProfessorInstance = new gerenciaProfessor();


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
                        } else {
                            System.out.println("Error: Disciplina nao encontrada");
                        }
                }

                    break;

                case 2:
                System.out.println("Digite o nome do Professor que deseja cadastrar: ");
                String nomeProfessor = s.next();

                System.out.println("Digite a data de nascimento do Professor");
                String dataNascimentoProfessor = s.next();

                System.out.println("Digite o telefone do Professor");
                long telefoneProfessor = s.nextLong();

                System.out.println("Digite o endereço do Professor");
                System.out.println("Rua:");
                String ruaProfessor = s.next();
                System.out.println("Numero:");
                int numeroProfessor = s.nextInt();
                System.out.println("Bairro:");
                String bairroProfessor = s.next();

                Endereco enderecoProfessor = new Endereco(ruaProfessor, numeroProfessor, bairroProfessor);

                System.out.println("Digite a area de formacao do Professor");
                String areaFormacao = s.next();
                
                System.out.println("Digite o ano de admissao do Professor");
                int anoAdmissao = s.nextInt();                

                System.out.println("Digite o email do Professor");
                String email = s.next();

                System.out.println("Quais diciplinas o professor leciona?");

                //listar disciplinas cadastradas
                System.out.println("As diciplinas ja cadstradas sao: ");
                    if(disciplinas.isEmpty()){
                        System.out.println("Nenhuma disciplina encontrada");
                    }else{
                        for(int i = 0; i < disciplinas.size(); i++){
                            System.out.println(disciplinas.get(i).getNomeDisciplina());
                        }
                    }
                System.out.println("Selecione digite o nome da disciplina para cadastrar o professor");
                String NomedisciplinaProf = s.next();

                    for(int i = 0; i < disciplinas.size(); i++){
                        if(NomedisciplinaProf.equals(disciplinas.get(i).getNomeDisciplina())){
                            Disciplina disciplina = disciplinas.get(i);

                            Professor professor = new Professor (nomeProfessor, dataNascimentoProfessor, telefoneProfessor, enderecoProfessor, areaFormacao, anoAdmissao, email);

                            professor.adicionarDisciplina(disciplina);
                            
                            gerenciaProfessorInstance.cadastrarProfessor(professor);
                        } else {
                            System.out.println("Error: Disciplina nao encontrada");
                        }
                }


                    break;
                case 3:
                System.out.println("Digite o nome da Disciplina que deseja cadastrar: ");
                String nomeDisciplina = s.next();

                System.out.println("Digite a carga horaria da Disciplina");
                int cargaHoraria = s.nextInt();

                System.out.println("Digite o codigo da Disciplina");
                int codigo = s.nextInt();

                Disciplina disciplina = new Disciplina (nomeDisciplina, cargaHoraria, codigo);

                disciplinas.add(disciplina);

                    break;
                case 4:
                System.out.println("Digite o codigo da Turma que deseja cadastrar: ");
                int codigoTurma = s.nextInt();

                Turma turma = new Turma (codigoTurma);

                System.out.println("Das disciplinas cadastras qual sera lecionada pela Turma");

                //listar disciplinas cadastradas
                System.out.println("As diciplinas ja cadstradas sao: ");
                    if(disciplinas.isEmpty()){
                        System.out.println("Nenhuma disciplina encontrada");
                    }else{
                        for(int i = 0; i < disciplinas.size(); i++){
                            System.out.println(disciplinas.get(i).getNomeDisciplina());
                        }
                    }

                System.out.println("Selecione digite o nome da disciplina para cadastrar a turma");
                String NomedisciplinaTurma = s.next();

                  
                    
                Disciplina disciplinaT = null; // Declaração fora do loop

                for(int i = 0; i < disciplinas.size(); i++) {
                    if(NomedisciplinaTurma.equals(disciplinas.get(i).getNomeDisciplina())) {
                        disciplinaT = disciplinas.get(i); // Atribui o valor à variável
                        turma.adicionarDisciplina(disciplinaT);
                        break; // Sai do loop assim que encontrar
                    }
                }
                
                if(disciplinaT == null) {
                    System.out.println("Error: Disciplina não encontrada");
                }
                
              

                    System.out.println("Qual professor leciona na Turma?");

                    //listar professores cadastrados
                    System.out.println("Os professores ja cadastrados sao: ");
                        if(gerenciaProfessorInstance.getProfessoresCadastrados().isEmpty()){
                            System.out.println("Nenhum professor encontrado");
                        }else{
                            gerenciaProfessorInstance.listarProfessores();
                        }

                    System.out.println("Selecione digite o nome do professor para cadastrar a turma");
                    String NomeprofessorTurma = s.next();

                        for(int i = 0; i < gerenciaProfessorInstance.getProfessoresCadastrados().size(); i++){
                            if(NomeprofessorTurma.equals(gerenciaProfessorInstance.getProfessoresCadastrados().get(i).getNome())){
                                Professor professorT = gerenciaProfessorInstance.getProfessoresCadastrados().get(i);
                                turma.adicionarProfessor(professorT);
                            } else {
                                System.out.println("Error: Professor nao encontrado");
                            }
                        }
                    System.out.println("Qual aluno deseja inserir na turma?");

                    //listar alunos cadastrados
                    System.out.println("Os alunos ja cadastrados sao: ");
                        if(gerenciaAlunoInstance.getAlunosCadastrados().isEmpty()){
                            System.out.println("Nenhum aluno encontrado");
                        }else{
                            gerenciaAlunoInstance.listarAlunos();
                        }

                    System.out.println("Digite o nome do aluno para cadastrar a turma");
                    String NomealunoTurma = s.next();

                        for(int i = 0; i < gerenciaAlunoInstance.getAlunosCadastrados().size(); i++){
                            if(NomealunoTurma.equals(gerenciaAlunoInstance.getAlunosCadastrados().get(i).getNome())){
                                Aluno alunoT = gerenciaAlunoInstance.getAlunosCadastrados().get(i);
                                turma.adcAlunoTurma(alunoT);
                            } else {
                                System.out.println("Error: Aluno nao encontrado");
                            }
                        }

                       

                        turmas.add(turma);

                        

                    break;
                case 5:

                    break;
                case 6:
                //Listar alunos
                    gerenciaAlunoInstance.listarAlunos();

                    break;
                case 7:
                //Listar professores
                    gerenciaProfessorInstance.listarProfessores();

                    break;
                case 8:
                //Listar disciplinas
                for (int i = 0; i < disciplinas.size(); i++) {
                    System.out.println("Nome da disciplina: " + disciplinas.get(i).getNomeDisciplina());
                    System.out.println("Carga horaria: " + disciplinas.get(i).getCargaHoraria());
                    System.out.println("Codigo: " + disciplinas.get(i).getCodigo());

                }
                    break;
                case 9:
                //listar turmas
                for (int i = 0; i < turmas.size(); i++) {
                    System.out.println("Nome da turma: " + turmas.get(i).getNomeTurma());
                    System.out.println("Professor: " + turmas.get(i).getProfessor());
                    System.out.println("Disciplina: " + turmas.get(i).getDisciplina());
                    System.out.println("Alunos: " + turmas.get(i).getAlunos());
                }

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
