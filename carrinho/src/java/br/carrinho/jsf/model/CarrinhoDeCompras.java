
package br.carrinho.jsf.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mauricio Menandro
 */
public class CarrinhoDeCompras {

    private List<Item> itens = new ArrayList<>();

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }
}
