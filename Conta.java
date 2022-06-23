import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Conta
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    private String cod;
    private String tipo;
    private Double saldo;
    private Double limite;
    private List<String> movimentacoes = new ArrayList<>();
    public Conta(String cod, String tipo, Double saldo, Double limite) {
        this.cod = cod;
        this.tipo = tipo;
        this.saldo = saldo;
        this.limite = limite;
    }
    
    public Double verSaldo(){
        return saldo;
    }
    
    public boolean sacar(Double valSaque){
        
        if(valSaque <= (saldo+limite)){
           saldo= saldo- valSaque;
           return true;
        }
        return false;
        
    }
    
    public boolean transferir (Double valor, Conta destino){
        boolean result = sacar(valor);
        if(result){
            destino.depositar(valor);
            return true;
        }   
        return false;
    }
     
    
    public boolean depositar(Double valor){
        Double saldoant = saldo;
        movimentacoes.add("Data: " + LocalDateTime.now() + " - Depósito: R$" + valor + " Saldo: R$" + saldo);
        saldo+=valor;
        if(saldoant != saldo){
            return true;
        }
        return false;
    }
    
    public boolean devedor (){
        if(saldo <0){
            return true;
        }
        return false;
    }
    
    public void manutencao (Double taxa){
        Double desconto= saldo * taxa;
        saldo -= desconto;
    }
    
    public void render (Double taxa){
        Double rendimento= saldo * taxa;
        saldo += rendimento;
    }

    public String getCod() {
        return this.cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getSaldo() {
        return this.saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Double getLimite() {
        return this.limite;
    }

    public void setLimite(Double limite) {
        this.limite = limite;
    }
}
