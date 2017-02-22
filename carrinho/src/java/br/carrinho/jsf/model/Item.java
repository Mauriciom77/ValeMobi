
package br.carrinho.jsf.model;

/**
 *
 * @author Mauricio Menandro
 */
public class Item {

    private Produto produto;
    private int qtdeProduto;

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQtdeProduto() {
        return qtdeProduto;
    }

    public void setQtdeProduto(int qtdeProduto) {
        this.qtdeProduto = qtdeProduto;
    }

    public double getValorTotalProduto() {
        return this.produto.getPreco() * this.qtdeProduto;
    }
}
