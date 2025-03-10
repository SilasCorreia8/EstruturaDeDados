
package TrabalhoED;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Queue;

public class Fila implements Serializable {
    
    //Criação da Fila
    private Queue<Pessoa> filaPrincipal;
    
    //Construtor da Classe. Ele é chamado quando um novo objeto Fila é criado.
    public Fila() {
        //Inicializa o atributo fila que deve armazenar uma fila de objetos "Pessoa"
        //com uma nova LinkedList quando um objeto Fila é criado.
        
        //Cria uma nova LinkedList vazia e atribui essa LinkedList vazia ao
        //atributo fila do objeto Fila que está sendo criado.
        this.filaPrincipal = new LinkedList<>();
    }
    
    //Adicionar por prioridade
    public void adicionar(Pessoa pessoa) {
        
        //Se a fila estiver vazia
        if(filaPrincipal.isEmpty()) {
            filaPrincipal.add(pessoa);
        } else { //Se não estiver vazia
            
            //Fila auxiliar
            Queue<Pessoa> filaAuxiliar = new LinkedList<>();
            
            //Variavel auxiliar que inicializa em "false"
            boolean inserido = false;
            
            //Execulta enquanto tiver elemento na fila
            while(!filaPrincipal.isEmpty()) {
                
                //Remove a primeira pessoa da fila original e a armazena em pessoaAtual.
                Pessoa pessoaAtual = filaPrincipal.remove();
                
                //Verifica se a idade da nova pessoa é maior que a idade da pessoa atual.
                if(!inserido && pessoa.getIdade() > pessoaAtual.getIdade()) {
                    filaAuxiliar.add(pessoa); //a nova pessoa é inserida na fila auxiliar antes da pessoa atual.
                    inserido = true; //Inserido agora é "true"
                }
                
                filaAuxiliar.add(pessoaAtual); //Adiciona a pessoa atual à fila auxiliar.
                
            } //Se a filaPrincipal não estiver vazia repete o While
            
            //Se a nova pessoa não foi inserida no loop (ou seja, ela tem a menor idade),
            //ela é adicionada ao final da fila auxiliar.
            if(!inserido) {
                filaAuxiliar.add(pessoa);
            }
            
            //A fila original é substituída pela fila auxiliar, que agora contém as pessoas em ordem de idade
            filaPrincipal = filaAuxiliar;
            
        }
        
    }
    
    //Mostrar fila
    public void mostrarFila() {
        //Verificar se a lista está vazia
        if (filaPrincipal.isEmpty()) {
            System.out.println("A fila está vazia.");
        } else {
            //Usando for-each para percorrer a fila e imprimir cada elemento
            for (Pessoa pessoa : filaPrincipal) {
                System.out.println(pessoa);
            }
        }
    }
    
}
