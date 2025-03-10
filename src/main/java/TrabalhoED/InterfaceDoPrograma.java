package TrabalhoED;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class InterfaceDoPrograma implements Serializable {
    public static void main(String[] args) {
        ListaGenerica<Pessoa> listaNomes = new ListaGenerica<Pessoa>();
        Fila fila = new Fila();
        Arvore arvore = new Arvore();

        ManipularArquivo arquivo = new ManipularArquivo();
        ListaGenerica<Pessoa> validarLista = arquivo.lerListaEmArquivo();
        listaNomes.setLista(validarLista.getLista());

        int option = 0;
        do {
            Scanner scan = new Scanner(System.in);




            System.out.println("""
             _      ____ _____ ______   ____      ___      ___      ____    ___   ___ ___    ___  _____
            | |    |    / ___/|      | /    |    |   \\    /  _]    |    \\  /   \\ |   |   |  /  _]/ ___/       
            | |     |  (   \\_ |      ||  o  |    |    \\  /  [_     |  _  ||     || _   _ | /  [_(   \\_         
            | |___  |  |\\__  ||_|  |_||     |    |  D  ||    _]    |  |  ||  O  ||  \\_/  ||    _]\\__  |        
            |     | |  |/  \\ |  |  |  |  _  |    |     ||   [_     |  |  ||     ||   |   ||   [_ /  \\ |         
            |     | |  |\\    |  |  |  |  |  |    |     ||     |    |  |  ||     ||   |   ||     |\\    |         
            |_____||____|\\___|  |__|  |__|__|    |_____||_____|    |__|__| \\___/ |___|___||_____| \\___|         
                    
            -------------------------------------------------------------------------------------------                                                                                                        
            | 1. Adicionar nome                                                                        | 
            | 2. Deletar nome                                                                          |   
            | 3. Mostrar lista                                                                         | 
            | 4. Inserir lista de nomes em uma fila                                                    |                                    
            | 5. Pessoas que possuem o mesmo sobrenome                                                 |         
            | 6. Inserir nomes de pessoas em uma arvore                                                | 
            | 7. Salvar lista                                                                          |
            | 0. Encerrar programa                                                                     |                           
            |__________________________________________________________________________________________|  
            """);



            System.out.print("\nEntrar com opcao: ");
            option = scan.nextInt();

            //LinkedList<Pessoa> listaRecuperada = (validarLista != null) ? validarLista.getLista() : new LinkedList<>();
            //if(listaRecuperada!= null) listaNomes.setLista(listaRecuperada);

            switch (option) {
                case 1:
                    scan.nextLine();
                    System.out.print("Informe o nome da pessoa que deseja adicionar:");
                    String nomeParaAdicionar = scan.nextLine();

                    System.out.print("Por favor, informe a sua idade:");
                    int idade = scan.nextInt();
                    scan.nextLine();

                    Pessoa pessoa = new Pessoa(nomeParaAdicionar, idade);

                    listaNomes.adicionar(pessoa);
                    System.out.println(listaNomes.toString());
                    System.out.println("A pessoa de nome '" + nomeParaAdicionar + "' foi adicionada a lista com sucesso.");
                    break;

                case 2:
                    scan.nextLine();
                    System.out.println("Digite o nome da pessoa  que deseja apagar da lista:");
                    String nomeParaDeletar = scan.nextLine();

                    boolean removido = false;
                    Iterator<Pessoa> iterator = listaNomes.getLista().iterator();
                    while (iterator.hasNext()) {
                        Pessoa pessoaParaDeletar = iterator.next();
                        if (pessoaParaDeletar.getNome().equalsIgnoreCase(nomeParaDeletar)) {
                            iterator.remove();
                            removido = true;
                            System.out.println("Pessoa removida com sucesso!");
                            break;
                        }
                    }
                    if (!removido) {
                        System.out.println("Pessoa nao encontrada na lista");
                        break;
                    }

                case 3:

                    System.out.println("Lista atual: \n");
                    listaNomes.mostrarLista();
                    break;


                case 4:
                    //Criar submenu para este caso

                    scan.nextLine();
                    System.out.print("Informe o nome da pessoa que deseja adicionar:");
                    String nomeParaAdicionar1 = scan.nextLine();

                    System.out.print("Por favor, informe a sua idade:");
                    int idade1 = scan.nextInt();
                    scan.nextLine();

                    Pessoa pessoa1 = new Pessoa(nomeParaAdicionar1, idade1);
                    fila.adicionar(pessoa1);
                    fila.mostrarFila();
                    break;

                case 5:
                    scan.nextLine();
                    System.out.println("Pessoas que possuem o mesmo sobrenome: \n");
                    listaNomes.pilhaPorSegundoNome();
                    break;

                case 6:
                    //Criar submenu para este caso
                    scan.nextLine();
                    System.out.print("Inserir pessoas nas arvores: \n");
                    System.out.print("Informe o nome da pessoa que deseja adicionar:");
                    String nomeParaAdicionar2 = scan.nextLine();

                    System.out.print("Por favor, informe a sua idade:");
                    int idade2 = scan.nextInt();
                    scan.nextLine();

                    Pessoa pessoa2 = new Pessoa(nomeParaAdicionar2, idade2);
                    arvore.adicionar(pessoa2);
                    arvore.mostrarEmOrdem();
                    arvore.mostrarPreOrdem();
                    arvore.mostrarNaoInseridas();
                    break;

                case 7:
                    scan.nextLine();
                    System.out.print("Salvando lista em arquivo... \n");
                    arquivo.gravarListaEmArquivo(listaNomes);
                    System.out.print("A lista foi salva com sucesso!\n");
                    break;

                case 0:
                    System.out.println("Encerrando programa...");
                    break;

                default:
                    System.out.println("Entrada invalida! Encerrando programa...");
                    break;
            }
        }while(option != 0);
    }
}
