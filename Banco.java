import java.util.ArrayList;


public class Banco{
    ArrayList<Agencia> agencias = new ArrayList<Agencia>();

    public Banco(){
        

    }

    public Double totalDinheiro(){
        return agencias.stream().mapToDouble(a->a.totalDinheiro()).sum();
    }

    public void render ( Double taxa){
        agencias.stream().forEach(a->a.render(taxa)); 
    }
   
}
