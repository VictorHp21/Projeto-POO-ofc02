public class Nota {
    private String DisciplinaNota;
    private double valor;
    private String data;

    public Nota (String DisciplinaNota, double valor, String data)
    {
        this.DisciplinaNota = DisciplinaNota;
        this.valor = valor;
        this.data = data;
    }


    //metodos getters e setters
    public double getValor()
    {
        return valor;
    }

    public void setValor(double valor)
    {
        this.valor = valor;
    }

    public String getData()
    {
        return data;
    }

    public void setData(String data)
    {
        this.data = data;
    }
}
