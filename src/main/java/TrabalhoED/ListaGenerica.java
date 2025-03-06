
package TrabalhoED;

//Lista Parametrizada - Pode armazenar objetos de qualquer tipo passado

import java.util.LinkedList;

public class ListaGenerica<Tipo> {
    
    //Criação da Lista
    public LinkedList<Tipo> lista;
    
    //Construtor da Classe. Ele é chamado quando um novo objeto ListaGenerica é criado.
    public ListaGenerica() {
        //Inicializa o atributo lista com uma nova LinkedList quando um objeto
        //ListaGenerica é criado.
        this.lista = new LinkedList<>();
    }
    
    //Adicionar
    public void adicionar(Tipo elemento) {
        lista.add(elemento);
    }
    
    //Remover
    public void remover(Tipo elemento) {
        lista.remove(elemento);
    }
    
    //Mostrar lista
    public void mostrarLista() {
        //Verificar se a lista está vazia
        if (lista.isEmpty()) {
            System.out.println("A lista está vazia.");
        } else {
            //Usando for-each para percorrer a lista e imprimir cada elemento
            for (Tipo elemento : lista) {
                System.out.println(elemento);
            }
        }
    }
    
    public void removerUltimaOcorrencia(String nome) {
        int indiceUltimaOcorrencia = -1; // Começamos com -1, indicando que não encontramos nada

        // Primeiro, vamos encontrar o índice da última ocorrência
        for (int i = 0; i < lista.size(); i++) {
            Tipo elemento = lista.get(i);
            if (elemento instanceof Pessoa) { // Verificamos se o elemento é uma instância da classe Pessoa. Se não for, pulamos para o próximo elemento.
                // Converte o elemento para o tipo Pessoa, e armazena na variável verificarPessoa
                Pessoa verificarPessoa = (Pessoa) elemento;
                if (verificarPessoa.getNome().equals(nome)) {
                    indiceUltimaOcorrencia = i; // Guardamos o índice da última ocorrência encontrada
                }
            }
        }

        // Agora, vamos remover a pessoa se encontramos uma ocorrência
        if (indiceUltimaOcorrencia != -1) {
            lista.remove(indiceUltimaOcorrencia);
        }
    }
    
}
