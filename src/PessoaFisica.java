import java.util.List;

public final class PessoaFisica extends Cliente {

    private String cpf;
    private List<PessoaFisica> dependentes;
    private PessoaJuridica empresa;

    public PessoaFisica(String nome, String cpf) {
        super(nome);
        this.cpf = cpf;
    }
 
    public String getCpf() {
        return cpf;
    }
    @Override
    public String toString() {
        return "PessoaFisica{"+
                "' cpf='" + cpf + "-" +
                "' nome='" + super.getNome()+
                '}';
    }
}