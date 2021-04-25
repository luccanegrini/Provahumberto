
import static javax.swing.JOptionPane.*;

import static java.lang.Integer.*;

public class Reserva implements Pagamento {
    private Cliente cliente;
	 private int pagamento;


	 public Reserva(Cliente cliente, int pagamento){
	        this.cliente = cliente;
	        this.pagamento= pagamento;
	    }
	 
	 public String GetDados() {
	 String aux = "";
	 aux += "pagamento -->" + pagamento +"\n"; 
	 aux += "valor do pagamento -->" + calcularPagamento() +"\n"; 
	 return aux;
}

 public  double calcularPagamento(){
	 double valor = 0;
	 if(pagamento == 1) {
	 valor = 3200 - 320;
	 }
	 else {
		 valor = 3200 + ((3200/100)* 15);
	 }
	 
	 return valor;
 }




}