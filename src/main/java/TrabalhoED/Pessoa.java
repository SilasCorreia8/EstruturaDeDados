
package TrabalhoED;


public class Pessoa {
    
    public String nome;
    public int idade;

    //Constructor
    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }
    
    //Gatters and Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
    
    //toString
    public String toString() {
        return "Nome: "+nome+", Idade: "+idade;
    }
    
}
