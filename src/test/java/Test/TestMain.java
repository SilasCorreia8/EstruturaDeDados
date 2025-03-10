
package Test;

import TrabalhoED.Arvore;
import TrabalhoED.Pessoa;

public class TestMain {
    public static void main(String[] args) {
        
        
        // ------- Teste da ListaGenerica -------
        
        /*
        
        //Criando Lista
        ListaGenerica<Pessoa> listaPessoas = new ListaGenerica<>();

        // Adicionando pessoas
        Pessoa pessoa1 = new Pessoa("Alice", 25);
        Pessoa pessoa2 = new Pessoa("Bob", 30);
        Pessoa pessoa3 = new Pessoa("Carol", 28);
        Pessoa pessoa4 = new Pessoa("Bob", 35); // Adicionando outro Bob
        Pessoa pessoa5 = new Pessoa("Bob", 40); // Adicionando outro Bob

        listaPessoas.adicionar(pessoa1);
        listaPessoas.adicionar(pessoa2);
        listaPessoas.adicionar(pessoa3);
        listaPessoas.adicionar(pessoa4);
        listaPessoas.adicionar(pessoa5);

        // Exibindo a lista
        System.out.println("Lista de Pessoas:");
        listaPessoas.mostrarLista();

        // Removendo a última ocorrência de Bob
        listaPessoas.removerUltimaOcorrencia("Bob");

        // Exibindo a lista após a remoção
        System.out.println("\nLista de Pessoas após remoção da última ocorrência de Bob:");
        listaPessoas.mostrarLista();

        // Removendo a última ocorrência de Alice
        listaPessoas.removerUltimaOcorrencia("Alice");

        // Exibindo a lista após a remoção
        System.out.println("\nLista de Pessoas após remoção da última ocorrência de Alice:");
        listaPessoas.mostrarLista();

        // Removendo a última ocorrência de David (que não existe)
        listaPessoas.removerUltimaOcorrencia("David");

        // Exibindo a lista após a remoção (de David)
        System.out.println("\nLista de Pessoas após remoção da última ocorrência de David:");
        listaPessoas.mostrarLista();

        */
        
        // ------- Teste da Fila -------
        
        /*
        
        Fila filaPessoas = new Fila();

        // Adicionando pessoas em ordem aleatória
        Pessoa pessoa1 = new Pessoa("Alice", 25);
        Pessoa pessoa2 = new Pessoa("Bob", 30);
        Pessoa pessoa3 = new Pessoa("Carol", 28);
        Pessoa pessoa4 = new Pessoa("David", 35);
        Pessoa pessoa5 = new Pessoa("Eva", 22);

        filaPessoas.adicionar(pessoa1);
        filaPessoas.adicionar(pessoa2);
        filaPessoas.adicionar(pessoa3);
        filaPessoas.adicionar(pessoa4);
        filaPessoas.adicionar(pessoa5);

        // Exibindo a fila ordenada
        System.out.println("\nFila de Pessoas (ordenada por idade):");
        filaPessoas.mostrarFila();
        
        filaPessoas.adicionar(new Pessoa("Otavio", 50));
        
        // Exibindo a fila ordenada
        System.out.println("\nFila de Pessoas (ordenada por idade):");
        filaPessoas.mostrarFila();
        
        filaPessoas.adicionar(new Pessoa("Guilherme", 15));
        
        // Exibindo a fila ordenada
        System.out.println("\nFila de Pessoas (ordenada por idade):");
        filaPessoas.mostrarFila();
        
        */
        
        /*
        
        // ------- Teste da Pilha -------
        
        //Criando Lista
        ListaGenerica<Pessoa> listaPessoas = new ListaGenerica<>();

        // Adicionando pessoas
        Pessoa pessoa1 = new Pessoa("Alice Silva", 25);
        Pessoa pessoa2 = new Pessoa("Bob Matos", 30);
        Pessoa pessoa3 = new Pessoa("Carol Silva", 28);
        Pessoa pessoa4 = new Pessoa("David Matos", 35);
        Pessoa pessoa5 = new Pessoa("Silas Correia", 20);

        listaPessoas.adicionar(pessoa1);
        listaPessoas.adicionar(pessoa2);
        listaPessoas.adicionar(pessoa3);
        listaPessoas.adicionar(pessoa4);
        listaPessoas.adicionar(pessoa5); 
        
        // Criando pilha por segundo nome
        List<Pilha> listaPilha = listaPessoas.pilhaPorSegundoNome();
        
        // Exibindo as pilhas
        System.out.println("\nLista de Pilhas por segundo nome");
        listaPessoas.mostrarListaPilhas(listaPilha);
        
        */
        
        
        
        // ------- Teste da Arvore -------
        
        Arvore arvore = new Arvore();

        // Criando pessoas
        Pessoa pessoa1 = new Pessoa("Alice", 25);
        Pessoa pessoa2 = new Pessoa("Bob", 30);
        Pessoa pessoa3 = new Pessoa("Carol", 28);
        Pessoa pessoa4 = new Pessoa("David", 35);
        Pessoa pessoa5 = new Pessoa("Eva", 22);
        Pessoa pessoa6 = new Pessoa("Alice", 27); // Nome repetido

        // Adicionando pessoas
        arvore.adicionar(pessoa1);
        arvore.adicionar(pessoa2);
        arvore.adicionar(pessoa3);
        arvore.adicionar(pessoa4);
        arvore.adicionar(pessoa5);
        arvore.adicionar(pessoa6);

        // Mostrando a árvore
        arvore.mostrarEmOrdem();
        arvore.mostrarPreOrdem();

        // Mostrando nomes não inseridos
        arvore.mostrarNaoInseridas();
        
    }
}
