
package TrabalhoED;

//Lista Parametrizada - Pode armazenar objetos de qualquer tipo passado

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ListaGenerica<Tipo> implements  Serializable{
    
    //Criação da Lista
    private java.util.LinkedList<Tipo> lista = new java.util.LinkedList<>();
    
    //Construtor da Classe. Ele é chamado quando um novo objeto ListaGenerica é criado.
    public ListaGenerica() {
        //Inicializa o atributo lista com uma nova LinkedList quando um objeto
        //ListaGenerica é criado.
        this.lista = new java.util.LinkedList<>();
    }

    public java.util.LinkedList<Tipo> getLista() {
        return lista;
    }

    public void setLista(java.util.LinkedList<Tipo> lista) {
        this.lista = lista;
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
    
    public void pilhaPorSegundoNome() {
        
        List<Pilha> listaPilha = new ArrayList<>(); // Lista de pilhas
        List<String> listaSegundoNome = new ArrayList<>(); // Lista de segundos nomes já usados
        
        for(Tipo elemento : lista) { //Percorre cada pessoa na lista com for-each
            if(elemento instanceof Pessoa) { //Verificar se é uma pessoa
                Pessoa pessoa = (Pessoa) elemento; //Pega o elemento do tipo Pessoa e coloca em "pessoa"
                //Pegar o segundo nome e colocar dentro da variavel "segundoNome"
                String segundoNome = pegarSegundoNome(pessoa.getNome());
                
                if(segundoNome != null) { //Se tiver segundo nome
                    
                    //Verifica se já existe pilha para esse nome
                    int indice = listaSegundoNome.indexOf(segundoNome); 
                    
                    //Se não existe pilha para esse nome
                    if(indice == -1) {
                        listaSegundoNome.add(segundoNome); //Adiciona o segundo nome na lista
                        Pilha novaPilha = new Pilha(); //Cria uma nova Pilha
                        novaPilha.adicionar(pessoa); //Adiciona a pessoa na nova Pilha
                        listaPilha.add(novaPilha); // Adiciona a pilha na lista de pilhas
                    } else { //Se já existe pilha para esse nome
                        //Adiciona a pessoa na pilha existente
                        listaPilha.get(indice).adicionar(pessoa);
                    }
                    
                }
                
            }
        }
        mostrarListaPilhas(listaPilha); //Chama metodo que imprime as pilhas
        
    } //Fim do pegarPorSegundoNome
    
    
    private String pegarSegundoNome(String nomeCompleto) {       
        String[] nomes = nomeCompleto.split(" "); //Divide o nome em partes
        if(nomes.length >= 2) {
            return nomes[1]; //Retorna a segunda parte da string dividida (Segundo nome)
        }
        return null; //Se não tiver segundo nome;
    }
    
    /*  
        ---- O .split() é usado para percorrer a string e procurar o delimitador
        ---- passado para dividir a string a partir do delimitador.
    */
    
    //Mostrar lista de pilhas
    public void mostrarListaPilhas(List<Pilha> listaPilha) {
        System.out.println("\nPilhas por segundo nome:");
        for(int i = 0; i < listaPilha.size(); i++) {
            
            //Inseri determinada pilha na variavel pilhaAtual
            Pilha pilhaAtual = listaPilha.get(i);
            
            //Verificar se a pillhaAtual não está vazia
            if(!pilhaAtual.pilhaVazia()) {
                
                //Eetorna o nome completo da pessoa que está no topo da pilha
                String segundoNome = pegarSegundoNome(pilhaAtual.getPilha().peek().getNome());
                System.out.println("\nSegundo nome: " + segundoNome); //Imprimir O segundo nome
               pilhaAtual.mostrarPilha();
            }
            
        }

    }


    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        ListaGenerica<?> that = (ListaGenerica<?>) object;
        return Objects.equals(lista, that.lista);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(lista);
    }

    @Override
    public String toString() {
        return "ListaGenerica{" +
                "lista=" + lista +
                '}';
    }
}
