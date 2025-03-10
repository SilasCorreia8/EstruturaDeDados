package TrabalhoED;

import java.io.*;

public class ManipularArquivo implements Serializable {


    public void gravarListaEmArquivo(ListaGenerica<Pessoa> objeto){
        try{
            File arquivo = new File("src/main/java/TrabalhoED/arquivos/Lista.txt");

            //Vincula objeto de gravacao no arquivo
            ObjectOutputStream gravar = new ObjectOutputStream(new FileOutputStream(arquivo));
            gravar.writeObject(objeto); // Efetuar gravacao
            gravar.close();

        } catch (IOException e){
            e.printStackTrace();
        }
    }


    public ListaGenerica<Pessoa> lerListaEmArquivo() {
        File arquivo = new File("src/main/java/TrabalhoED/arquivos/Lista.txt");

        if (!arquivo.exists()) {
            return new ListaGenerica<>(); // Retorna lista vazia se o arquivo não existir
        }

        try (ObjectInputStream lerArquivo = new ObjectInputStream(new FileInputStream(arquivo))) {
            return (ListaGenerica<Pessoa>) lerArquivo.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return new ListaGenerica<>(); // Retorna lista vazia em caso de erro
    }
}
