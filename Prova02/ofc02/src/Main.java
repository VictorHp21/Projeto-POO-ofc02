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
                        String nomeAluno = null;
                        System.out.println("Digite o nome do Aluno");    
                        String nome = s.next();

                                while (tentativa == false){
                                        try {
                                            if(!nome.matches("-?\\d+(\\.\\d+)?")) //se não for um número
                                            {
                                                nomeAluno = nome;
                                                tentativa = true;
                                                
                                            } else {
                                                throw new Exception("Erro: Nome invalido");
                                                                                
                                            }
                                        } catch (Exception e) {
                                            System.out.println(e.getMessage());
                                            System.out.println("Digite o nome do Aluno novamente: ");
                                            nome = s.next(); // ler novamente o nome
                                            tentativa = false;
                                        }
                                }
                       
                    String dataAluno = null;
                    System.out.println("Digite a data de nascimento do Aluno");
                    String dataNascimento = s.next();

                                tentativa = false;
                                while (tentativa == false){
                                    try {
                                        if(isNumeric(dataNascimento) == true) //se for numerico
                                        {
                                            dataAluno = dataNascimento;
                                            tentativa = true;

                                        } else {
                                            
                                            throw new Exception("Erro: Data invalida");
                                                                            
                                        }
                                    } catch (Exception e) {
                                        System.out.println(e.getMessage());
                                        System.out.println("Digite a data de nascimento do Aluno novamente: ");
                                        dataNascimento = s.next(); // ler novamente a data
                                        tentativa = false;
                                    }
                                } 
                                    
                                

                               
                    long telefoneAluno = 0;            
                       System.out.println("Digite o telefone do Aluno");
                            while (true) {
                                try {
                                    telefoneAluno = s.nextLong();
                                    break;
                                } catch (InputMismatchException e) {
                                    System.out.println("Erro: Telefone inválido. Por favor, digite novamente.");
                                    s.next(); 
                                }
                            }

                    System.out.println("Digite o endereço do Aluno");

                    System.out.println("Rua:");
                    String rua = s.next();
                    String ruaAluno = null;

                        tentativa = false;
                            while (tentativa == false){
                                try {
                                    if(!rua.matches("-?\\d+(\\.\\d+)?")) //se não for um número
                                    {
                                        ruaAluno = rua;
                                        tentativa = true;
                                        
                                    } else {
                                        throw new Exception("Erro: Rua invalida");
                                                                        
                                    }
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                    System.out.println("Digite a rua do Aluno novamente: ");
                                    rua = s.next(); // ler novamente o nome
                                    tentativa = false;
                                }
                        }

                   
                   
                    int numeroAluno = 0;
                    System.out.println("Numero:");
                        while (true) {
                            try {
                                numeroAluno = s.nextInt();
                                break;
                            } catch (InputMismatchException e) {
                                System.out.println("Erro: Numero inválido. Por favor, digite novamente.");
                                s.next(); // limpar o buffer de entrada
                            }
                        }
                   

                    System.out.println("Bairro:");
                    String bairro = s.next();
                    String bairroAluno = null;

                        while (tentativa == false){
                            try {
                                if(!bairro.matches("-?\\d+(\\.\\d+)?")) //se não for um número
                                {
                                    bairroAluno = bairro;
                                    tentativa = true;
                                    
                                } else {
                                    throw new Exception("Erro: Bairro invalido");
                                                                    
                                }
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                                System.out.println("Digite o bairro do Aluno novamente: ");
                                bairro = s.next(); // ler novamente o nome
                                tentativa = false;
                            }
                    }


                    Endereco endereco = new Endereco(ruaAluno, numeroAluno, bairroAluno);


                    

                    long matriculaAluno = 0;            
                    System.out.println("Digite a matricula do Aluno");
                         while (true) {
                             try {
                                matriculaAluno = s.nextLong();
                                 break;
                             } catch (InputMismatchException e) {
                                 System.out.println("Erro: Matricula inválida. Por favor, digite novamente.");
                                 s.next(); 
                             }
                         }


                    System.out.println("Digite o ano de ingresso do Aluno");
                    int anoIngresso = 0;

                    while (true) {
                        try {
                            anoIngresso = s.nextInt();
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Erro: Ano inválido. Por favor, digite novamente.");
                            s.next(); 
                        }
                    }

                    System.out.println("Em quais diciplinas o aluno será cadastrado?");

                    //listar disciplinas cadastradas

                        if(disciplinas.isEmpty()){
                            System.out.println("Nenhuma disciplina encontrada");
                            menu();
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
                                double valor = 0;
                                        while (true) {
                                            try {
                                                valor = s.nextDouble();
                                                break;
                                            } catch (InputMismatchException e) {
                                                System.out.println("Erro: Valor inválido. Por favor, digite novamente.");
                                                s.next(); 
                                            }
                                        }

                                System.out.println("Digite a data da nota do Aluno nesta disciplina");
                                String data = s.next();
                                String dataNota = null;

                                tentativa = false;
                                while (tentativa == false){
                                    try {
                                        if(isNumeric(dataNascimento) == true) //se for numerico
                                        {
                                            dataNota = data;
                                            tentativa = true;

                                        } else {
                                            
                                            throw new Exception("Erro: Data invalida");
                                                                            
                                        }
                                    } catch (Exception e) {
                                        System.out.println(e.getMessage());
                                        System.out.println("Digite a data da nota do Aluno novamente: ");
                                        data = s.next(); 
                                        tentativa = false;
                                    }
                                } 

                                Nota nota = new Nota(DisciplinaNota, valor, dataNota);
                                
                                

                                Aluno aluno = new Aluno (nomeAluno, dataAluno, telefoneAluno, endereco, matriculaAluno, anoIngresso);
                                aluno.adicionarNota(nota);

                                
                                aluno.getDisciplinasAluno().add(disciplinas.get(i));

                                disciplinas.get(i).adicionarAluno(aluno);

                            
                            
                                gerenciaAlunoInstance.cadastrarAluno(aluno);
                            } else {
                                System.out.println("Error: Disciplina nao encontrada");
                                menu();
                            }
                    }

                    break;

                case 2:
                    String nomeProfessorF = null;
                    System.out.println("Digite o nome do Professor que deseja cadastrar: ");
                    String nomeProfessor = s.next();

                    while (tentativa == false){
                        try {
                            if(!nomeProfessor.matches("-?\\d+(\\.\\d+)?")) //se não for um número
                            {
                                nomeProfessorF = nomeProfessor;
                                tentativa = true;
                                
                            } else {
                                throw new Exception("Erro: Nome invalido");
                                                                
                            }
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            System.out.println("Digite o nome do Professor novamente: ");
                            nomeProfessor = s.next(); 
                            tentativa = false;
                        }
                }
                    String dataNascimentoProfessor = null;
                    System.out.println("Digite a data de nascimento do Professor");
                    String dataNas = s.next();
                    tentativa = false;
                    while (tentativa == false){
                        try {
                            if(isNumeric(dataNas) == true) //se for numerico
                            {
                                dataNascimentoProfessor = dataNas;
                                tentativa = true;

                            } else {
                                
                                throw new Exception("Erro: Data invalida");
                                                                
                            }
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            System.out.println("Digite a data de nascimento do Professor novamente: ");
                            dataNas = s.next(); 
                            tentativa = false;
                        }
                    } 


                    System.out.println("Digite o telefone do Professor");
                    long telefoneProfessor = 0;
                    while (true) {
                        try {
                            telefoneAluno = s.nextLong();
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Erro: Telefone inválido. Por favor, digite novamente.");
                            s.next(); 
                        }
                    }


                    System.out.println("Digite o endereço do Professor");
                    System.out.println("Rua:");
                    String ruaP = s.next();
                        String ruaProfessor = null;

                        tentativa = false;
                            while (tentativa == false){
                                try {
                                    if(!ruaP.matches("-?\\d+(\\.\\d+)?")) //se não for um número
                                    {
                                        ruaProfessor = ruaP;
                                        tentativa = true;
                                        
                                    } else {
                                        throw new Exception("Erro: Rua invalida");
                                                                        
                                    }
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                    System.out.println("Digite a rua do Aluno novamente: ");
                                    ruaP = s.next(); 
                                    tentativa = false;
                                }
                        }

                    System.out.println("Numero:");
                    int numeroProfessor = 0;
                        while(true){
                            try {
                                numeroProfessor = s.nextInt();
                                break;
                            } catch (InputMismatchException e) {
                                System.out.println("Erro: Telefone inválido. Por favor, digite novamente.");
                                s.next(); 
                            }
                        }

                    System.out.println("Bairro:");
                    String bairrop = s.next();
                    String bairroProfessor = null;
                            tentativa = false;
                            while (tentativa == false){
                                try {
                                    if(!bairrop.matches("-?\\d+(\\.\\d+)?")) //se não for um número
                                    {
                                        bairroProfessor = bairrop;
                                        tentativa = true;
                                        
                                    } else {
                                        throw new Exception("Erro: Bairro invalido");
                                                                        
                                    }
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                    System.out.println("Digite o bairro do Aluno novamente: ");
                                    bairrop = s.next(); 
                                    tentativa = false;
                                }
                        }
                        

                    Endereco enderecoProfessor = new Endereco(ruaProfessor, numeroProfessor, bairroProfessor);

                    System.out.println("Digite a area de formacao do Professor");
                    String areap = s.next();
                    String areaFormacao = null;
                            tentativa = false;
                            while (tentativa == false){
                                try {
                                    if(!areap.matches("-?\\d+(\\.\\d+)?"))
                                    {
                                        areaFormacao = areap;
                                        tentativa = true;
                                        
                                    } else {
                                        throw new Exception("Erro: Nome invalido");
                                                                        
                                    }
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                    System.out.println("Digite o nome do Aluno novamente: ");
                                    areap = s.next(); 
                                    tentativa = false;
                                }
                        }
                    
                    System.out.println("Digite o ano de admissao do Professor");
                    int anoAdmissao = 0;   
                        while (true) {
                            try {
                                anoAdmissao = s.nextInt();
                                if (anoAdmissao < 1900 || anoAdmissao > 2024) {
                                    System.out.println("Erro: Ano inválido. Por favor, digite um ano entre 1900 e 2024.");
                                } else {
                                    break; 
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Erro: Ano inválido. Por favor, digite novamente.");
                                s.next(); 
                            }
                        }      

                    System.out.println("Digite o email do Professor");
                    String email = s.next();
                    String emailProfessor = null;
                        tentativa = false;
                        while (tentativa == false){
                            try {
                                if(!email.matches("-?\\d+(\\.\\d+)?")) 
                                {
                                    emailProfessor = email;
                                    tentativa = true;
                                    
                                } else {
                                    throw new Exception("Erro: Nome invalido");
                                                                    
                                }
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                                System.out.println("Digite o nome do Aluno novamente: ");
                                email = s.next(); 
                                tentativa = false;
                            }
                    }

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

                                Professor professor = new Professor (nomeProfessorF, dataNascimentoProfessor, telefoneProfessor, enderecoProfessor, areaFormacao, anoAdmissao, emailProfessor);

                                professor.adicionarDisciplina(disciplina);
                                
                                gerenciaProfessorInstance.cadastrarProfessor(professor);
                            } else {
                                System.out.println("Error: Disciplina nao encontrada");
                                menu();
                            }
                    }


                    break;
                case 3:
                    System.out.println("Digite o nome da Disciplina que deseja cadastrar: ");
                    String nomeDisciplina = null;
                    String nomeD = s.next();
                        tentativa = false;
                        while (tentativa == false){
                            try {
                                if(!nomeD.matches("-?\\d+(\\.\\d+)?")) //se não for um número
                                {
                                    nomeDisciplina = nomeD;
                                    tentativa = true;
                                    
                                } else {
                                    throw new Exception("Erro: Nome invalido");
                                                                    
                                }
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                                System.out.println("Digite o nome do Aluno novamente: ");
                                nomeD = s.next(); // ler novamente o nome
                                tentativa = false;
                            }
                    }

                    System.out.println("Digite a carga horaria da Disciplina");
                    int cargaHoraria = 0;
                        while(true){
                            try {
                                cargaHoraria = s.nextInt();
                                break;
                            } catch (InputMismatchException e) {
                                System.out.println("Erro: Carga Horaria inválida. Por favor, digite novamente.");
                                s.next(); 
                            }
                        }


                    System.out.println("Digite o codigo da Disciplina");
                    int codigo = 0;
                        while(true){
                            try {
                                codigo = s.nextInt();
                                break;
                            } catch (InputMismatchException e) {
                                System.out.println("Erro: Codigo inválido. Por favor, digite novamente.");
                                s.next(); 
                            }
                        }

                    Disciplina disciplina = new Disciplina (nomeDisciplina, cargaHoraria, codigo);

                    disciplinas.add(disciplina);

                    break;
                case 4:
                    System.out.println("Digite o codigo da Turma que deseja cadastrar: ");
                    int codigoTurma = 0;
                    while(true){
                        try {
                            codigoTurma = s.nextInt();
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Erro: Codigo inválido. Por favor, digite novamente.");
                            s.next(); 
                        }
                    }

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
                    String nomeDiscipli = s.next();
                    String nomeDisciplinaturma = null;
                        tentativa = false;
                        while (tentativa == false){
                            try {
                                if(!nomeDiscipli.matches("-?\\d+(\\.\\d+)?")) //se não for um número
                                {
                                    nomeDisciplinaturma = nomeDiscipli;
                                    tentativa = true;
                                    
                                } else {
                                    throw new Exception("Erro: Nome invalido");
                                                                    
                                }
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                                System.out.println("Digite o nome da disciplina novamente: ");
                                nomeDiscipli = s.next(); // ler novamente o nome
                                tentativa = false;
                            }
                    }

                    
                        
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

                        System.out.println("Selecione digite o nome do professor para cadastrar a turma");
                        String NomeprofessorTurma = s.next();

                            for(int i = 0; i < gerenciaProfessorInstance.getProfessoresCadastrados().size(); i++){
                                if(NomeprofessorTurma.equals(gerenciaProfessorInstance.getProfessoresCadastrados().get(i).getNome())){
                                    Professor professorT = gerenciaProfessorInstance.getProfessoresCadastrados().get(i);
                                    turma.adicionarProfessor(professorT);
                                } else {
                                    System.out.println("Error: Professor nao encontrado");
                                    menu();
                                }
                            }
                        System.out.println("Qual aluno deseja inserir na turma?");

                        //listar alunos cadastrados
                        System.out.println("Os alunos ja cadastrados sao: ");
                            if(gerenciaAlunoInstance.getAlunosCadastrados().isEmpty()){
                                System.out.println("Nenhum aluno encontrado");
                                menu();
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
                                    menu();
                                }
                            }

                        

                            turmas.add(turma);

                        

                    break;
                case 5:
                //inserir nota

                    System.out.println("Qual aluno deseja inserir uma nota?");
                    gerenciaAlunoInstance.listarAlunos();

                    System.out.println("Digite o nome do aluno para inserir uma nota");
                    String NomealunoNota = s.next();

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
                                            System.out.println("Digite a data da nota: ");
                                            String dataNot = s.next();
                                            String datanota = null;
                                            tentativa = false;
                                            while (tentativa == false){
                                                try {
                                                    if(isNumeric(dataNot) == true) //se for numerico
                                                    {
                                                        datanota = dataNot;
                                                        tentativa = true;
                        
                                                    } else {
                                                        
                                                        throw new Exception("Erro: Data invalida");
                                                                                        
                                                    }
                                                } catch (Exception e) {
                                                    System.out.println(e.getMessage());
                                                    System.out.println("Digite a data de nascimento do Professor novamente: ");
                                                    dataNot = s.next(); 
                                                    tentativa = false;
                                                }
                                            } 

                                            String DisciplinaNota = disciplinasAluno.getNomeDisciplina();

                                            Nota notaAluno = new Nota(DisciplinaNota, valornotaAluno, datanota);

                                            //adicionar essa nota ao aluno encontrado

                                            gerenciaAlunoInstance.getAlunosCadastrados().get(i).adicionarNota(notaAluno);

                                            
                                            break;
                                        } else {
                                            System.out.println("Disciplina não encontrada para este aluno");
                                            menu();
                                        }
                                    }
                                


                                } else {
                                    System.out.println("Aluno não encontrado");
                                    menu();
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
                                System.out.println("Digite o codigo da disciplina");
                                int codigodisciplina = 0;
                                while(true){
                                    try {
                                        codigodisciplina = s.nextInt();
                                        break;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Erro: Codigo da disciplina inválido. Por favor, digite novamente.");
                                        s.next(); 
                                    }
                                }


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

                            System.out.println("Digite o nome do professor que deseja que sejam listadas suas turmas: ");
                            String nomePr = s.next();
                            String nomeprofessor = null;
                            tentativa = false;

                            while (tentativa == false){
                                try {
                                    if(!nomePr.matches("-?\\d+(\\.\\d+)?")) //se não for um número
                                    {
                                        nomeprofessor = nomePr;
                                        tentativa = true;
                                        
                                    } else {
                                        throw new Exception("Erro: Nome invalido");
                                                                        
                                    }
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                    System.out.println("Digite o nome do Aluno novamente: ");
                                    nomePr = s.next(); // ler novamente o nome
                                    tentativa = false;
                                }
                        }

                            for (int i = 0; i < gerenciaProfessorInstance.getProfessoresCadastrados().size(); i++) {
                                if (gerenciaProfessorInstance.getProfessoresCadastrados().get(i).getNomeProfessor().equals(nomeprofessor)) {
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

    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            //tenta converter a string para inteiro se conseguir é numerico
            return true;
        } catch (NumberFormatException e) {
            return false;
        }

    }
}
