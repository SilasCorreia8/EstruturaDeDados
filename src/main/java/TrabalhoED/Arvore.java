
package TrabalhoED;

import java.lang.classfile.components.ClassPrinter.Node;
import java.util.ArrayList;
import java.util.List;

public class Arvore {
    
    //Node é uma classe interna que representa um nó em uma árvore binária.
    public Node raiz;
    public List<Pessoa> naoInseridas;
    
    //Construtor da Classe. Ele é chamado quando um novo objeto Arvore é criado.
    public Arvore() {
        //Inicializa a raiz com null. 
        //Inicializa o atributo naoInseridas que deve armazenar uma lista de objetos "Pessoa"
        //que não foram inseridas na arvore.      
        this.raiz = null;
        this.naoInseridas = new ArrayList<>();
    }
    
    private static class Node {
        
        Pessoa pessoa; //Atributo pessoa do tipo Pessoa
        Node esquerda; //Atributo esquerda do tipo Node
        Node direita; //Atributo direita do tipo Node

        //Constructor. É chamado quando um novo objeto Node é criado
        Node(Pessoa pessoa) {
            this.pessoa = pessoa; //Inicializa com o objeto pessoa passado
            this.esquerda = null; //Inicializa com null
            this.direita = null; //Inicializa com null
        }
    }
    
    //Adicionar
    public void adicionar(Pessoa pessoa) {
        
        //Cahamar o metodo buscar
        if(buscar(pessoa.getNome()) != null) {
            naoInseridas.add(pessoa);
            return; //Não insere nomes repetidos
        }
        
        //Chama o metodo adicionarNaArvore
        raiz = adicionarNaArvore(raiz, pessoa);
        
    }
    
    //Adiciona nova pessoa na arvore
    public Node adicionarNaArvore(Node atual, Pessoa pessoa) {
        
        //Se o nó atual for null adiciona a nova pessoa nesse nó
        if(atual == null) {
            return new Node(pessoa); //Cria um novo nó de pessoa
        }
        
        //Verificar idade. Maior para a direita e menor para a esquerda
        if(pessoa.getIdade() < atual.pessoa.getIdade()) {            
            //Adiciona na esquerda. Idade da nova pessoa menor que da pessoa do nó atual
            atual.esquerda = adicionarNaArvore(atual.esquerda, pessoa);
        } else if(pessoa.getIdade() > atual.pessoa.getIdade()) {
            //Adiciona na direita. Idade da nova pessoa maior do que da pessoa do nó atual
            atual.direita = adicionarNaArvore(atual.direita, pessoa);
        }
        
        return atual; //Retorna o nó atual.
        
        /*
        Observação: Essa é uma chamada recursiva, que o metodo chama ele
        proprio para ser verificado e inserido no nó correto.
        
        Ex: atual.esquerda = inserirNaArvore(atual.esquerda, pessoa);

        Será feita todo esse bloco de código novamente, porém verificando
        agora o atual.esquerda, que é a esquerda do atual.       
        */
    }
    
    //Buscar Pessoa
    public Pessoa buscar(String nome) {
        return buscarNaArvore(raiz, nome); //Chama o metodo buscarNaArvore para buscar a pessoa na arvore
    }
       
    //Buscar Pessoa na arvore
    private Pessoa buscarNaArvore(Node atual, String nome) {
        
        //Verifica se o nó atual é null
        if(atual == null) {
            return null; //Não encontrou
        }
        
        //Verifica se o nome da pessoa que está no nó atual é igual ao nome da nova pessoa
        if(nome.equalsIgnoreCase(atual.pessoa.getNome())) {
            return atual.pessoa; //Encontrou
        }
        
        //Pegar esquerda da pessoa atual e colocar dentro da variavel
        //"esquerda" do tipo Pessoa
        Pessoa esquerda = buscarNaArvore(atual.esquerda, nome);
        
        //Verifica se a esquerda é diferente de null
        if(esquerda != null) {
            return esquerda; //Encontrou esquerda
        }
        
        return buscarNaArvore(atual.direita, nome); // Procura na direita
        
    }
    
    // ------- Mostrar em Ordem -------
    public void mostrarEmOrdem() {
        System.out.println("\nÁrvore em ordem (idade crescente):");
        imprimirEmOrdem(raiz);
    }
    
    private void imprimirEmOrdem(Node atual) {
        if (atual != null) {
            imprimirEmOrdem(atual.esquerda); // Mostra a esquerda
            System.out.println(atual.pessoa); // Mostra o nó atual
            imprimirEmOrdem(atual.direita); // Mostra a direita
        }
    }
    
    // ------- Mostrar em Pré-Ordem -------
    public void mostrarPreOrdem() {
        System.out.println("\nÁrvore em pré-ordem:");
        imprimirPreOrdem(raiz);
    }

    private void imprimirPreOrdem(Node atual) {
        if (atual != null) {
            System.out.println(atual.pessoa); // Mostra o nó atual
            imprimirPreOrdem(atual.esquerda); // Mostra a esquerda
            imprimirPreOrdem(atual.direita); // Mostra a direita
        }
    }
    
    // ------- Mostrar Pessoas não inseridas -------
    public void mostrarNaoInseridas() {
        System.out.println("\nPessoas não inseridas (nomes repetidos):");
        //Usando for-each para percorrer a arvore e imprimir cada nó
        for (Pessoa pessoa : naoInseridas) {
            System.out.println(pessoa);
        }
    }
}
