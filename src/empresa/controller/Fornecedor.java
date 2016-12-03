package empresa.controller;

/**
 * Created by Marcio on 01/12/2016.
 */
public class Fornecedor {

    private String nome;
    private String cpf;

    private int pk_fornecedor;

    public Fornecedor() {

    }

    public Fornecedor(int pk_fornecedor, String nome, String cpf) {
        this.pk_fornecedor = pk_fornecedor;
        this.nome = nome;
        this.cpf = cpf;
    }

    public Fornecedor(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public int getPk_fornecedor() {
        return pk_fornecedor;
    }

    public void setPk_fornecedor(int pk_fornecedor) {
        this.pk_fornecedor = pk_fornecedor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}