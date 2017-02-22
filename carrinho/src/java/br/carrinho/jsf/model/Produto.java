package br.carrinho.jsf.model;

/**
 *
 * @author Mauricio Menandro
 */
public class Produto {

    private long id;
    private String decricao;
    private double preco;
    private String marca;

    public String getDecricao() {
        return decricao;
    }

    public void setDecricao(String decricao) {
        this.decricao = decricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Object getIdProduto() throws Exception{
        String m = marca;
        return m;
    }
}
