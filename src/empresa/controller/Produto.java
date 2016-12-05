package empresa.controller;

import empresa.model.DAO;

import java.sql.SQLException;

/**
 * Created by Marcio on 01/12/2016.
 */
public class Produto {

    private String nome;

    private int pk_produto;
    private int estoque_minimo;
    private int qtd_estoque;

    public Produto(){

    }

    public Produto(String nome, int estoque_minimo, int qtd_estoque){
        this.nome = nome;
        this.estoque_minimo = estoque_minimo;
        this.qtd_estoque = qtd_estoque;
    }

    public Produto(int pk_produto, String nome, int estoque_minimo, int qtd_estoque){
        this.pk_produto = pk_produto;
        this.nome = nome;
        this.estoque_minimo = estoque_minimo;
        this.qtd_estoque = qtd_estoque;
    }

    public int getPk_produto() {
        return pk_produto;
    }

    public void setPk_produto(int pk_produto) {
        this.pk_produto = pk_produto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getEstoque_minimo() {
        return estoque_minimo;
    }

    public void setEstoque_minimo(int estoque_minimo) {
        this.estoque_minimo = estoque_minimo;
    }

    public int getQtd_estoque() {
        return qtd_estoque;
    }

    public void setQtd_estoque(int qtd_estoque) {
        this.qtd_estoque = qtd_estoque;
    }

    public int contar() throws SQLException {
        return DAO.contar("produtos","");
    }
}
