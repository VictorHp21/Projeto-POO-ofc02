import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ArmazenadorDados {
    private List<String> listaDados;

    public ArmazenadorDados() {
        listaDados = new ArrayList<>();
    }

    public void adicionarDado(Object dado) {
        listaDados.add(dado.toString());
    }

    public void salvarEmArquivo(String caminhoArquivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo))) {
            for (String dado : listaDados) {
                writer.write(dado);
                writer.newLine(); 
            }
            System.out.println("Dados salvos no arquivo com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar os dados no arquivo: " + e.getMessage());
        }
    }

    public List<String> getListaDados() {
        return listaDados;
    }
}
