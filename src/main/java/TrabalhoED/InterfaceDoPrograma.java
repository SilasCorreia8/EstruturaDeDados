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
             
               ____   ____    ___  ____   ___     ____\s
             /    | /    |  /  _]|    \\ |   \\   /    |
            |  o  ||   __| /  [_ |  _  ||    \\ |  o  |
            |     ||  |  ||    _]|  |  ||  D  ||     |
            |  _  ||  |_ ||   [_ |  |  ||     ||  _  |
            |  |  ||     ||     ||  |  ||     ||  |  |
            |__|__||___,_||_____||__|__||_____||__|__| 
             
                    
            -------------------------------------------------------------------------------------------                                                                                                        
            | 1. Adicionar pessoa                                                                      | 
            | 2. Excluir pessoa                                                                        |   
            | 3. Mostrar lista                                                                         | 
            | 4. Inserir lista de pessoas em uma fila                                                  |                                    
            | 5. Pessoas que possuem o mesmo sobrenome                                                 |         
            | 6. Inserir pessoas em uma arvore                                                         | 
            | 7. Salvar lista em arquivo                                                               |
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
                    System.out.println("___________________________________________________________________________________________");
                    System.out.print("Informe o nome da pessoa que deseja adicionar:");
                    String nomeParaAdicionar = scan.nextLine();

                    System.out.print("Por favor, informe a sua idade:");
                    int idade = scan.nextInt();
                    scan.nextLine();

                    Pessoa pessoa = new Pessoa(nomeParaAdicionar, idade);

                    listaNomes.adicionar(pessoa);
                    System.out.println(listaNomes.toString());
                    System.out.println("A pessoa de nome '" + nomeParaAdicionar + "' foi adicionada a lista com sucesso.");
                    System.out.println("___________________________________________________________________________________________");

                    break;

                case 2:
                    scan.nextLine();
                    System.out.println("___________________________________________________________________________________________");
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
                    System.out.println("___________________________________________________________________________________________");

                case 3:
                    System.out.println("___________________________________________________________________________________________");
                    System.out.println("Lista atual: \n");
                    listaNomes.mostrarLista();
                    System.out.println("___________________________________________________________________________________________");
                    break;


                case 4:
                    //Criar submenu para este caso
                    System.out.println("""
                     _____  ____  _       ____\s
                    |     ||    || |     /    |
                    |   __| |  | | |    |  o  |
                    |  |_   |  | | |___ |     |
                    |   _]  |  | |     ||  _  |
                    |  |    |  | |     ||  |  |
                    |__|   |____||_____||__|__|
                    __________________________________________________________________________________________
                    | 1. Adicionar pessoa a fila                                                              |  
                    | 2. Mostrar fila                                                                         |      
                    |_________________________________________________________________________________________|
                    """);
                    System.out.print("\nEntrar com opcao: ");
                    option = scan.nextInt();

                    switch (option){
                        case 1:
                            scan.nextLine();
                            System.out.println("___________________________________________________________________________________________");
                            System.out.print("Informe o nome da pessoa que deseja adicionar:");
                            String nomeParaAdicionar1 = scan.nextLine();

                            System.out.print("Por favor, informe a sua idade:");
                            int idade1 = scan.nextInt();
                            scan.nextLine();

                            Pessoa pessoa1 = new Pessoa(nomeParaAdicionar1, idade1);
                            fila.adicionar(pessoa1);
                            System.out.println("___________________________________________________________________________________________");
                            break;

                        case 2:
                            System.out.println("___________________________________________________________________________________________");
                            System.out.println("\n");
                            fila.mostrarFila();
                            System.out.println("___________________________________________________________________________________________");

                            break;

                        default:
                            System.out.println("Opcao invalida!");
                    }
                    break;

                case 5:
                    scan.nextLine();
                    System.out.println("___________________________________________________________________________________________");
                    System.out.println("Pessoas que possuem o mesmo sobrenome: \n");
                    listaNomes.pilhaPorSegundoNome();
                    System.out.println("___________________________________________________________________________________________");
                    break;

                case 6:

                    System.out.println("""
                       ____  ____  __ __   ___   ____     ___\s
                     /    ||    \\|  |  | /   \\ |    \\   /  _]
                    |  o  ||  D  )  |  ||     ||  D  ) /  [_\s
                    |     ||    /|  |  ||  O  ||    / |    _]
                    |  _  ||    \\|  :  ||     ||    \\ |   [_\s
                    |  |  ||  .  \\\\   / |     ||  .  \\|     |
                    |__|__||__|\\_| \\_/   \\___/ |__|\\_||_____|
                    __________________________________________________________________________________________
                    | 1. Inserir pessoa em arvore                                                             |  
                    | 2. Mostrar arvore em ordem                                                              |  
                    | 3. Mostrar arvore em pre ordem                                                          |      
                    | 4. Mostrar pessoas nao inseridas                                                        |      
                    |_________________________________________________________________________________________|
                    """);
                    System.out.print("\nEntrar com opcao: ");
                    option = scan.nextInt();

                    switch (option) {
                       case 1:
                           scan.nextLine();
                           System.out.println("___________________________________________________________________________________________");
                           System.out.print("Inserir pessoas nas arvores: \n");
                           System.out.print("Informe o nome da pessoa que deseja adicionar:");
                           String nomeParaAdicionar2 = scan.nextLine();

                           System.out.print("Por favor, informe a sua idade:");
                           int idade2 = scan.nextInt();
                           scan.nextLine();

                           Pessoa pessoa2 = new Pessoa(nomeParaAdicionar2, idade2);
                           arvore.adicionar(pessoa2);
                           System.out.println("___________________________________________________________________________________________");
                           break;

                       case 2:
                           scan.nextLine();
                           System.out.println("___________________________________________________________________________________________");
                           System.out.print("Mostrando arvore em ordem: \n");
                           arvore.mostrarEmOrdem();
                           System.out.println("___________________________________________________________________________________________");
                           break;

                       case 3:
                           scan.nextLine();
                           System.out.println("___________________________________________________________________________________________");
                           System.out.print("Mostrando arvore em pre ordem: \n");
                           arvore.mostrarPreOrdem();
                           System.out.println("___________________________________________________________________________________________");
                           break;

                       case 4:
                           scan.nextLine();
                           System.out.println("___________________________________________________________________________________________");
                           System.out.print("Mostrando nao inseridas: \n");
                           arvore.mostrarNaoInseridas();
                           System.out.println("___________________________________________________________________________________________");
                           break;

                       default:
                           scan.nextLine();
                           System.out.print("Opcao invalida!! \n");
                           break;
                    }
                    break;


                case 7:
                    scan.nextLine();
                    System.out.println("___________________________________________________________________________________________");
                    System.out.print("Salvando lista em arquivo... \n");
                    arquivo.gravarListaEmArquivo(listaNomes);
                    System.out.print("A lista foi salva com sucesso!\n");
                    System.out.println("___________________________________________________________________________________________");
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
