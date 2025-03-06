
package TrabalhoED;

import java.util.Stack;

public class Pilha {
    
    //Criação da Pilha
    public Stack<Pessoa> pilha;
    
    //Construtor da Classe. Ele é chamado quando um novo objeto Fila é criado.
    public Pilha() {
        //Inicializa o atributo pilha que deve armazenar uma pilha de objetos "Pessoa"
        //com uma nova Stack quando um objeto Pilha é criado.
        this.pilha = new Stack<>();
    }
    
    //Adicionar
    public void adicionar(Pessoa pessoa) {
        pilha.push(pessoa);
    }

    //Remover
    public Pessoa remover() {
        return pilha.pop();
    }

    //Verificar se a pilha está vazia
    public boolean pilhaVazia() {
        return pilha.isEmpty();
    }

    //Mostrar pilha
    public void mostrarPilha() {
        if (pilha.isEmpty()) {
            System.out.println("Pilha vazia.");
        } else {
            //Usando for-each para percorrer a pilha e imprimir cada elemento
            for (Pessoa pessoa : pilha) {
                System.out.println(pessoa);
            }
        }
    }
    
}
