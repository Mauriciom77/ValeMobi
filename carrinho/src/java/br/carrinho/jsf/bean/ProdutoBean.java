package br.carrinho.jsf.bean;


import br.carrinho.jsf.model.Produto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;



/**
 *
 * @author Mauricio Menandro
 */
@ManagedBean
@ApplicationScoped
public class ProdutoBean implements Serializable{
    
    Produto produto = new Produto();
    List<Produto> produtos = new ArrayList<>();
    int totalDeProdutos = 0;
    public ProdutoBean(){
        Produto p = new Produto();
        p.setDecricao("Street Fighter V");
        p.setMarca("Capcom");
        p.setPreco(180.0);
        totalDeProdutos++;
        p.setId(totalDeProdutos);
        this.produtos.add(p);
        
        p = new Produto();
        p.setDecricao("FIFA 16");
        p.setMarca("EA Sports");
        p.setPreco(200.0);
        totalDeProdutos++;
        p.setId(totalDeProdutos);
        this.produtos.add(p);
        
        p = new Produto();
        p.setDecricao("Need for Speed Rivals");
        p.setMarca("EA Games");
        p.setPreco(140.0);
        totalDeProdutos++;
        p.setId(totalDeProdutos);
        this.produtos.add(p);
    }
    
    public List<Produto> getProdutos(){
        return this.produtos;
    }
    
    public Produto getProduto() {
        return this.produto;
    }
    
    public void salvar(){
        totalDeProdutos++;
        this.produto.setId(totalDeProdutos);
        this.produtos.add(this.produto);
        this.produto = new Produto();
        System.out.println("Produto Salvo! Descricao: " + this.produto.getDecricao());
    }
    
    public void validaPrecoMaiorZero(FacesContext fc, UIComponent component, Object value) throws ValidatorException {
        double valor = Double.parseDouble(value.toString());
        if(valor <= 0){
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Informe um preço maior do que zero (0).", ""));
        }
    }

    
}
