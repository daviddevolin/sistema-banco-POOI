import java.util.ArrayList;
import java.util.List;
import java.util.stream.*;

public class Agencia
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    private String cod;
    ArrayList<Conta> contas = new ArrayList<Conta>();
    
    /**
     * Construtor para objetos da classe Agencia
     */
    public Agencia()
    {
        // inicializa variáveis de instância
        
    }
    
    public boolean sacar(String codConta, Double valSaque){
        Conta conta;
        conta = (contas.stream().filter(c->c.getCod() == codConta).findFirst().get());
        return conta.sacar(valSaque);
    }
    
    public Double verSaldo(String codConta){
        Conta conta;
        conta = (contas.stream().filter(c->c.getCod() == codConta).findFirst().get());
        return conta.getSaldo();
    }
    
    public Double totalDinheiro(){
     return contas.stream().mapToDouble(c->c.getSaldo()).sum();
    }
     
    
    public boolean transferir(String codOrigin, String codDestino, Double valor){
        Conta origin;
        Conta destino;
        origin = (contas.stream().filter(c->c.getCod() == codOrigin).findFirst().get());
        destino = (contas.stream().filter(c->c.getCod() == codDestino).findFirst().get());
        boolean res = origin.transferir(valor, destino);
        return res;
    }
     
    
    public Conta pesquisarConta(String cod){
        Conta conta;
        conta = (contas.stream().filter(c->c.getCod() == cod).findFirst().get());
        return conta;
    }
    
    public List<Conta> devedores (){
        return contas.stream().filter(c->c.devedor()).collect(Collectors.toList());
        
    }
    
    public void depositar (String cod, Double valor){
        Conta conta;
        conta = (contas.stream().filter(c->c.getCod() == cod).findFirst().get());
        conta.depositar(valor);  
    }
    
    public void render ( Double taxa){
        contas.stream().filter(c->c.getTipo().equals("poupança")).forEach(c->c.render(taxa)); 
    }

    public void manutencao ( Double taxa){
        contas.stream().filter(c->c.getTipo().equals("corrente")).forEach(c->c.manutencao(taxa)); 
    }
    public List<String> getExtrato(String cod){
        Conta conta;
        conta = (contas.stream().filter(c->c.getCod() == cod).findFirst().get());
        return conta.getMovimentacoes();
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public ArrayList<Conta> getContas() {
        return contas;
    }

    public void setContas(ArrayList<Conta> contas) {
        this.contas = contas;
    }


}
