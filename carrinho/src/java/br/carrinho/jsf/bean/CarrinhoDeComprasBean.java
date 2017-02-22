
package br.carrinho.jsf.bean;

import br.carrinho.jsf.model.CarrinhoDeCompras;
import br.carrinho.jsf.model.Item;
import br.carrinho.jsf.model.Produto;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Mauricio Menandro
 */
@ManagedBean
@ViewScoped
public class CarrinhoDeComprasBean {

    private CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
    private Item item = new Item();
    private int produtoId;
    @ManagedProperty(value = "#{produtoBean.produtos}")
    private List<Produto> produtos;

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public int getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(int produtoId) {
        this.produtoId = produtoId;
    }

    public CarrinhoDeCompras getCarrinho() {
        return carrinho;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public void gravar() {
        this.item.setProduto(this.produtos.get(produtoId - 1));
        this.carrinho.getItens().add(this.item);
        this.item = new Item();
    }

    public void remover(Item i) {
        System.out.println(i.getProduto().getDecricao());
        this.carrinho.getItens().remove(i);
    }

    public double getTotalCarrinho() {
        double total = 0.0;
        for (Item i : this.carrinho.getItens()) {
            total += i.getValorTotalProduto();
        }
        return total;
    }
    
    public void validaQtdeProdutos (FacesContext fc, UIComponent component, Object value) throws ValidatorException {
        int valor = (int) value;
        if (valor < 1) {
            throw new ValidatorException(new FacesMessage("A quantidade do produto deve ser maior que zero."));
        }
    }

}
