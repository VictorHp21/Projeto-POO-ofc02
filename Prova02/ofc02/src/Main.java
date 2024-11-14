import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        List <Disciplina> disciplinas = new ArrayList<>();
        List <Turma> turmas = new ArrayList<>();
        gerenciaAluno gerenciaAlunoInstance = new gerenciaAluno();
        gerenciaProfessor gerenciaProfessorInstance = new gerenciaProfessor();

        boolean tentativa = false;

            //testes
            //endereco teste
            Endereco enderecoteste = new Endereco("avp", 230, "centro");
            //aluno teste
            Aluno alunoTeste = new Aluno("v", "21", 56, enderecoteste, 2, 2001);
           
            //Professor teste
            Professor professorTeste = new Professor("pedro", "2020", 456, enderecoteste, "mat", 0, "emailteste");


            //disciplinateste
            Disciplina disciplinateste = new Disciplina ("teste", 10, 1);
            alunoTeste.adicionarDisciplina(disciplinateste);
            Nota notaTeste = new Nota("teste", 10, "2020");
            alunoTeste.adicionarNota(notaTeste);

            gerenciaAlunoInstance.cadastrarAluno(alunoTeste);
            //turma teste
            Turma turmateste = new Turma(1);
            turmateste.adicionarDisciplina(disciplinateste);
            turmateste.adcAlunoTurma(alunoTeste);
            turmateste.adicionarProfessor(professorTeste);

            turmas.add(turmateste);

            disciplinas.add(disciplinateste);
            
            disciplinateste.adicionarAluno(alunoTeste);

            professorTeste.adicionarTurma(turmateste);
            gerenciaProfessorInstance.cadastrarProfessor(professorTeste);

    int opcao = 0;
        Scanner s = new Scanner(System.in);

    while(opcao != 15){
        menu();
        System.out.println("Escolha uma opção: ");
        opcao = s.nextInt();
        switch(opcao){
                case 1:
                   
                String nome = InputUtils.getValidInput(
                    "Digite o nome do Aluno: ",
                    s::next,
                    input -> !input.matches("-?\\d+(\\.\\d+)?"), 
                    "Erro: Nome inválido. Por favor, digite novamente."
                );

                String dataAluno = InputUtils.getValidInput(
            "Digite a data de nascimento do Aluno: ",
                    s::next,
                    InputUtils::isNumeric,
       "Erro: Data inválida. Por favor, digite novamente."
);
                                                     
                String telefoneAlunoStr = InputUtils.getValidInput(
                    "Digite o telefone do Aluno: ",
                    s::next,
                    input -> input.matches("\\d+") && input.length() >= 8,
                    "Erro: Telefone inválido. Por favor, digite novamente."
                );
                long telefoneAluno = Long.parseLong(telefoneAlunoStr);

                System.out.println("Digite o endereço do Aluno");

                String rua = InputUtils.getValidInput(
                    "Digite a rua do Aluno: ",
                    s::next,
                    input -> !input.matches("-?\\d+(\\.\\d+)?"), 
                    "Erro: Rua inválida. Por favor, digite novamente."
                );
               
                String numeroAlunoStr = InputUtils.getValidInput(
                    "Numero: ",
                    s::next,
                    InputUtils::isNumeric, 
                    "Erro: Número inválido. Por favor, digite novamente."
                );
                int numeroAluno = Integer.parseInt(numeroAlunoStr);
               
                String bairroAluno = InputUtils.getValidInput(
                    "Digite o Bairro do Aluno: ",
                    s::next,
                    input -> !input.matches("-?\\d+(\\.\\d+)?"), 
                    "Erro: Bairro inválido. Por favor, digite novamente."
                );

                Endereco endereco = new Endereco(rua, numeroAluno, bairroAluno);
      
                String MatriculaAlunoStr = InputUtils.getValidInput(
                    "Digite a matricula do Aluno com 4 digitos: ",
                    s::next,
                    input -> input.matches("\\d+") && input.length() >= 4,
                    "Erro: Matricula inválida. Por favor, digite novamente."
                );
                long matriculaAluno = Long.parseLong(MatriculaAlunoStr);

                String anoIngressoStr = InputUtils.getValidInput(
                    "Digite o ano de ingresso do Aluno: ",
                    s::next,
                    input -> input.matches("\\d{4}") && Integer.parseInt(input) >= 1900 && Integer.parseInt(input) <= 2024,
                    "Erro: Ano inválido. Por favor, digite novamente."
                );
                int anoIngresso = Integer.parseInt(anoIngressoStr);

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

                            double valor = InputUtils.getValidInput(
                    "Digite o valor da nota do Aluno nesta disciplina: ",
                    s::nextDouble,
                    input -> input >= 0 && input <= 10, // Validação para garantir que a nota esteja entre 0 e 10
                    "Erro: Valor inválido. Por favor, digite novamente."
                );

                            System.out.println("Digite a data da nota do Aluno nesta disciplina");

                            String dataNota = InputUtils.getValidInput(
                                "Digite a data da nota do Aluno nesta disciplina: ",
                                        s::next,
                                        InputUtils::isNumeric,
                           "Erro: Data inválida. Por favor, digite novamente."
                            );
                         
                            Nota nota = new Nota(DisciplinaNota, valor, dataNota);

                            Aluno aluno = new Aluno (nome, dataAluno, telefoneAluno, endereco, matriculaAluno, anoIngresso);
                            aluno.adicionarNota(nota);

                            aluno.getDisciplinasAluno().add(disciplinas.get(i));

                            disciplinas.get(i).adicionarAluno(aluno);

                            gerenciaAlunoInstance.cadastrarAluno(aluno);
                        } else {
                            System.out.println("Error: Disciplina nao encontrada");
                            
                        }
                }
                break;

            case 2:

                String nomeProfessor = InputUtils.getValidInput(
                    "Digite o nome do Professor: ",
                    s::next,
                    input -> !input.matches("-?\\d+(\\.\\d+)?"), 
                    "Erro: Nome inválido. Por favor, digite novamente."
                );
              
                String dataNascimentoProfessor = InputUtils.getValidInput(
                    "Digite a data de nascimento do Professor: ",
                            s::next,
                            InputUtils::isNumeric,
               "Erro: Data inválida. Por favor, digite novamente."
                );


                String telefoneProfessorStr = InputUtils.getValidInput(
                    "Digite o telefone do Professor: ",
                    s::next,
                    input -> input.matches("\\d+") && input.length() >= 8,
                    "Erro: Telefone inválido. Por favor, digite novamente."
                );
                long telefoneProfessor = Long.parseLong(telefoneProfessorStr);

                System.out.println("Digite o endereço do Professor");
             
                String ruaProfessor = InputUtils.getValidInput(
                    "Digite a rua do Professor: ",
                    s::next,
                    input -> !input.matches("-?\\d+(\\.\\d+)?"), 
                    "Erro: Rua inválida. Por favor, digite novamente."
                );
               
                String numeroProfessorStr = InputUtils.getValidInput(
                    "Numero: ",
                    s::next,
                    InputUtils::isNumeric, 
                    "Erro: Número inválido. Por favor, digite novamente."
                );
                int numeroProfessor = Integer.parseInt(numeroProfessorStr);
               
                String bairroProfessor = InputUtils.getValidInput(
                    "Digite o Bairro do Aluno: ",
                    s::next,
                    input -> !input.matches("-?\\d+(\\.\\d+)?"), 
                    "Erro: Bairro inválido. Por favor, digite novamente."
                );
          
                    

                Endereco enderecoProfessor = new Endereco(ruaProfessor, numeroProfessor, bairroProfessor);

                String areaFormacao = InputUtils.getValidInput(
                    "Digite a area de formacao do Professor: ",
                    s::next,
                    input -> !input.matches("-?\\d+(\\.\\d+)?"), 
                    "Erro: Area inválida. Por favor, digite novamente."
                );
                
  
                String anoAdmissaoStr = InputUtils.getValidInput(
                    "Digite o ano de admissao do Professor: ",
                    s::next,
                    input -> input.matches("\\d{4}") && Integer.parseInt(input) >= 1900 && Integer.parseInt(input) <= 2024,
                    "Erro: Ano inválido. Por favor, digite novamente."
                );
                int anoAdmissao = Integer.parseInt(anoAdmissaoStr);


                String emailProfessor = InputUtils.getValidInput(
                    "Digite o email do Professor: ",
                    s::next,
                    input -> !input.matches("-?\\d+(\\.\\d+)?"), 
                    "Erro: Area inválida. Por favor, digite novamente."
                );

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

                            Professor professor = new Professor (nomeProfessor, dataNascimentoProfessor, telefoneProfessor, enderecoProfessor, areaFormacao, anoAdmissao, emailProfessor);

                            professor.adicionarDisciplina(disciplina);
                            
                            gerenciaProfessorInstance.cadastrarProfessor(professor);
                        } else {
                            System.out.println("Error: Disciplina nao encontrada");
                            
                        }
                }


                break;
            case 3:

                String nomeDisciplina = InputUtils.getValidInput(
                    "Digite o nome da Disciplina que deseja cadastrar: ",
                    s::next,
                    input -> !input.matches("-?\\d+(\\.\\d+)?"), 
                    "Erro: Nome inválido. Por favor, digite novamente."
                );

                String cargaHorariaStr = InputUtils.getValidInput(
                    "Digite a carga horaria da Disciplina: ",
                    s::next,
                    InputUtils::isNumeric, 
                    "Erro: Número inválido. Por favor, digite novamente."
                );
                int cargaHoraria = Integer.parseInt(cargaHorariaStr);

                String codigoStr = InputUtils.getValidInput(
                    "Digite o codigo da Disciplina: ",
                    s::next,
                    InputUtils::isNumeric, 
                    "Erro: Número inválido. Por favor, digite novamente."
                );
                int codigo = Integer.parseInt(codigoStr);

                        Disciplina disciplina = new Disciplina (nomeDisciplina, cargaHoraria, codigo);

                        disciplinas.add(disciplina);

                break;
            case 4:
                String codigoTurmaStr = InputUtils.getValidInput(
                    "Digite o codigo da Turma que deseja cadastrar: ",
                    s::next,
                    InputUtils::isNumeric, 
                    "Erro: Número inválido. Por favor, digite novamente."
                );
                int codigoTurma = Integer.parseInt(codigoTurmaStr);
                  

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

                String nomeDisciplinaturma = InputUtils.getValidInput(
                    "Selecione digite o nome da disciplina para cadastrar a turma: ",
                    s::next,
                    input -> !input.matches("-?\\d+(\\.\\d+)?"), 
                    "Erro: Nome inválido. Por favor, digite novamente."
                );

                
                    
                Disciplina disciplinaT = null; 

                    for(int i = 0; i < disciplinas.size(); i++) {
                        if(nomeDisciplinaturma.equals(disciplinas.get(i).getNomeDisciplina())) {
                            disciplinaT = disciplinas.get(i);
                            turma.adicionarDisciplina(disciplinaT);
                            break; 
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

                        String NomeprofessorTurma = InputUtils.getValidInput(
                            "Selecione digite o nome do professor para cadastrar a turma: ",
                            s::next,
                            input -> !input.matches("-?\\d+(\\.\\d+)?"), 
                            "Erro: Nome inválido. Por favor, digite novamente."
                        );

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

                        String NomealunoTurma = InputUtils.getValidInput(
                            "Digite o nome do aluno para cadastrar a turma: ",
                            s::next,
                            input -> !input.matches("-?\\d+(\\.\\d+)?"), 
                            "Erro: Nome inválido. Por favor, digite novamente."
                        );

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
            //inserir nota

                System.out.println("Qual aluno deseja inserir uma nota?");
                gerenciaAlunoInstance.listarAlunos();

                String NomealunoNota = InputUtils.getValidInput(
                    "Digite o nome do aluno para inserir uma nota: ",
                    s::next,
                    input -> !input.matches("-?\\d+(\\.\\d+)?"), 
                    "Erro: Nome inválido. Por favor, digite novamente."
                );

                    for(int i = 0; i < gerenciaAlunoInstance.getAlunosCadastrados().size(); i++){
                        if(NomealunoNota.equals(gerenciaAlunoInstance.getAlunosCadastrados().get(i).getNome())){
                            System.out.println("Qual disciplina deseja inserir uma nota?");
                            //disciplinas da lista do aluno
                            gerenciaAlunoInstance.getAlunosCadastrados().get(i).ListarDisciplinasAluno();

                            System.out.println("Digite o codigo da disciplina");
                            int codigodisciplina = s.nextInt();

                                for (Disciplina disciplinasAluno : gerenciaAlunoInstance.getAlunosCadastrados().get(i).getDisciplinasAluno()) {
                                    if (disciplinasAluno.getCodigo() == codigodisciplina) {
                                        // código encontrado, faça algo aqui
                                        System.out.println("Digite a nota: ");
                                        double valornotaAluno = 0;
                                            while(true){
                                                try {
                                                    valornotaAluno = s.nextInt();
                                                    break;
                                                } catch (InputMismatchException e) {
                                                    System.out.println("Erro: Valor da nota inválido. Por favor, digite novamente.");
                                                    s.next(); 
                                                }
                                            }

                                        String datanota = InputUtils.getValidInput(
                                            "Digite a data da nota: ",
                                                    s::next,
                                                    InputUtils::isNumeric,
                                       "Erro: Data inválida. Por favor, digite novamente."
                                        );

                                        String DisciplinaNota = disciplinasAluno.getNomeDisciplina();

                                        Nota notaAluno = new Nota(DisciplinaNota, valornotaAluno, datanota);

                                        //adicionar essa nota ao aluno encontrado

                                        gerenciaAlunoInstance.getAlunosCadastrados().get(i).adicionarNota(notaAluno);

                                        
                                        break;
                                    } else {
                                        System.out.println("Disciplina não encontrada para este aluno");
                                        
                                    }
                                }
                            
                            } else {
                                System.out.println("Aluno não encontrado");
                                
                            }

            }


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
                    System.out.println("Codigo da turma: " + turmas.get(i).getCodigoTurma());
                    System.out.println("Professor: " + turmas.get(i).getProfessor().getNomeProfessor());
                    System.out.println("Disciplina: " + turmas.get(i).getDisciplina().getNomeDisciplina());
                    System.out.println(" ---- Alunos Turma ----\n" );
                    turmas.get(i).listarAlunosTurma();
                }

                break;
            case 10:
                gerenciaAlunoInstance.ListarAlunosCompleto();

                break;
            case 11:

                if(gerenciaAlunoInstance.getAlunosCadastrados().isEmpty()){
                    System.out.println("Nenhum aluno cadastrado");
                } else if (gerenciaAlunoInstance.getAlunosCadastrados().size() == 1){
                    System.out.println("Ha apenas um aluno cadastrado");
                } else {
                    System.out.println("Sao:" + gerenciaAlunoInstance.getAlunosCadastrados().size() + " alunos cadastrados");
                }

            

                break;
            case 12:
            // aluno que possui a maior nota
                System.out.println("Aluno com maior nota: " + gerenciaAlunoInstance.EncontrarAlunoMaiorNota().getNome());
            

                break;
            case 13:

                System.out.println("Deseja listar os alunos de qual disciplina? ");

                    if(disciplinas.isEmpty()){
                        System.out.println("***ERRO***Nenhuma disciplina encontrada");
                    } else {
                        //Listar disciplinas
                        for (int i = 0; i < disciplinas.size(); i++) {
                            System.out.println("Nome da disciplina: " + disciplinas.get(i).getNomeDisciplina());
                            System.out.println("Carga horaria: " + disciplinas.get(i).getCargaHoraria());
                            System.out.println("Codigo: " + disciplinas.get(i).getCodigo());

                            }

                            String codigodisciplinaStr = InputUtils.getValidInput(
                                "Digite o codigo da disciplina: ",
                                s::next,
                                InputUtils::isNumeric, 
                                "Erro: Número inválido. Por favor, digite novamente."
                            );
                            int codigodisciplina = Integer.parseInt(codigodisciplinaStr);


                                for (Disciplina disciplinasAluno : disciplinas) {
                                    if (disciplinasAluno.getCodigo() == codigodisciplina) {
                                        System.out.println("Alunos da disciplina: " + disciplinasAluno.getNomeDisciplina());
                                        disciplinasAluno.ListarAlunosDisciplina();
                                    }
                                }
                    }

                break;
            case 14:
                System.out.println("Deseja listar as turmas de qual professor? ");

                        if(gerenciaProfessorInstance.getProfessoresCadastrados().isEmpty()){
                    System.out.println("***ERRO***Nenhum professor encontrado");
                     } else {
                    gerenciaProfessorInstance.listarProfessores();
                            }
      
                        String nomeProfessorturmas = InputUtils.getValidInput(
                            "Digite o nome do professor que deseja que sejam listadas suas turmas: ",
                            s::next,
                            input -> !input.matches("-?\\d+(\\.\\d+)?"), 
                            "Erro: Nome inválido. Por favor, digite novamente."
                        );

                        for (int i = 0; i < gerenciaProfessorInstance.getProfessoresCadastrados().size(); i++) {
                            if (gerenciaProfessorInstance.getProfessoresCadastrados().get(i).getNomeProfessor().equals(nomeProfessorturmas)) {
                                gerenciaProfessorInstance.getProfessoresCadastrados().get(i).ListarTurmasProfessor();
                            }
                    }
                 

                break;
            case 15:
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Opção inválida");
                break;
        }
    }
}

    //funções para auxilio

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
