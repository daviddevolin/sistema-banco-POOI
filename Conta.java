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
           movimentacoes.add("Data: " + LocalDateTime.now() + " - Saque: -R$" + valSaque + " Saldo: R$" + saldo);
           return true;

        }
        return false;
        
    }
    
    public boolean transferir (Double valor, Conta destino){
        boolean result = sacar(valor);
        if(result){
            destino.saldo+=valor;
            movimentacoes.add("Data: " + LocalDateTime.now() + " - Transferência Enviada: -R$" + valor + " Saldo: R$" + saldo);
            destino.movimentacoes.add("Data: " + LocalDateTime.now() + " - Transferência Recebida: +R$" + valor + " Saldo: " + saldo);
            return true;
        }   
        return false;
    }
     
    
    public boolean depositar(Double valor){
        Double saldoAnt = saldo;
        saldo+=valor;
        if(saldoAnt != saldo){
            movimentacoes.add("Data: " + LocalDateTime.now() + " - Depósito: R$" + valor + " Saldo: R$" + saldo);
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
        movimentacoes.add("Data: " + LocalDateTime.now() + " - Taxa de Manutenção: -R$" + taxa + " Saldo: R$" + saldo);

    }
    
    public void render (Double taxa){
        Double rendimento= saldo * taxa;
        saldo += rendimento;
        movimentacoes.add("Data: " + LocalDateTime.now() + " - Rendimento: +R$" + taxa + " Saldo: R$" + saldo);
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

    public List<String> getMovimentacoes() {
        return movimentacoes;
    }

    public void setMovimentacoes(List<String> movimentacoes) {
        this.movimentacoes = movimentacoes;
    }
}
