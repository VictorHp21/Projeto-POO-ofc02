public abstract class Pessoa {
    protected String nome;
    protected String DataNascimento;
    protected long telefone; 
    protected Endereco endereco;

    public Pessoa(String nome, String DataNascimento, long telefone, Endereco endereco) {
        this.nome = nome;
        this.DataNascimento = DataNascimento;
        this.telefone = telefone;
        this.endereco = endereco;
    }


    //metodos getters e setters
    public String getNome() {
        return this.nome;
    }
    public String getDataNascimento() {
        return this.DataNascimento;
    }
    public long getTelefone() {
        return this.telefone;
    }
    public void  getEndereco() {
        System.out.println("Rua: " + this.endereco.getRua() + "\nNumero: " + this.endereco.getNumero() + "\nBairro: " + this.endereco.getBairro());
        
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setDataNascimento(String DataNascimento) {
        this.DataNascimento = DataNascimento;
    }
    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
