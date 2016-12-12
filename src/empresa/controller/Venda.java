package empresa.controller;

import empresa.model.VendaDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by marci on 07/12/2016.
 */
public class Venda {

    private int numero;
    private Date data;
    private Cliente cliente;
    private Funcionario vendedor;
    private ArrayList<Item> itens;

    private int pk_venda;

    public Venda() {
    }


    public Venda(int numero, Date data, Cliente cliente, Funcionario vendedor) {
        this.numero = numero;
        this.data = data;
        this.cliente = cliente;
        this.vendedor = vendedor;
    }

    public Venda(int pk_venda, int numero, Date data, Cliente cliente, Funcionario vendedor) {
        this.pk_venda = pk_venda;
        this.numero = numero;
        this.data = data;
        this.cliente = cliente;
        this.vendedor = vendedor;
    }

    public Venda(int numero, Date data, Cliente cliente, Funcionario vendedor, ArrayList<Item> itens) {
        this.numero = numero;
        this.data = data;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.itens = itens;
    }

    public Venda(Cliente cliente, Funcionario vendedor, ArrayList<Item> itens) {
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.itens = itens;
    }

    public Venda(int pk_venda, int numero, Date data, Cliente cliente, Funcionario vendedor, ArrayList<Item> itens) {
        this.numero = numero;
        this.data = data;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.itens = itens;
        this.pk_venda = pk_venda;
    }

    @Override
    public String toString() {
        return numero + " | " + data + " | " + cliente;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Funcionario getVendedor() {
        return vendedor;
    }

    public void setVendedor(Funcionario vendedor) {
        this.vendedor = vendedor;
    }

    public ArrayList<Item> getItens() {
        return itens;
    }

    public void setItens(ArrayList<Item> itens) {
        this.itens = itens;
    }

    public int getPk_venda() {
        return pk_venda;
    }

    public void setPk_venda(int pk_venda) {
        this.pk_venda = pk_venda;
    }


    public boolean create() throws Exception {
        return VendaDAO.create(this);
    }

    public boolean delete() throws SQLException {
        return VendaDAO.delete(this);
    }


    public void addItem(Item vi) {
        if (itens == null) {
            itens = new ArrayList<>();
        }
        itens.add(vi);
    }

    public double somaValoresMetodosPagamento(double valorDinheiro, double valorCartao) {
        return valorDinheiro + valorCartao;
    }

    public double voltaTroco(double somaValoresMetodoPagamento, double somaValorTotal) {

        if ((somaValoresMetodoPagamento - somaValorTotal) > 0) {
            return (somaValoresMetodoPagamento - somaValorTotal);
        }
        return 0.00;
    }

    public double somaValorTotal() {
        double retorno = 0.00;
        for (Item item : itens) {
            retorno += item.getValorUnitario() * item.getQtd();
        }
        return retorno;
    }

    public void removerUltimoItem() {
        itens.remove(itens.size() - 1);
    }

}
