package br.carrinho.jsf.banco;


import br.carrinho.jsf.model.Produto;
import javax.persistence.EntityManager;

/**
 *
 * @author Mauricio Menandro
 */
public class ProdutoDAO {
    
    private EntityManager em;
    
    public ProdutoDAO (EntityManager em){
        this.em=em;
    }
    
    public Produto salvar(Produto p) throws Exception{
        if(p.getIdProduto()==null){
            em.persist(p);
        } else {
            em.merge(p);
        }
        return p;
    }
    
    public void excluir (Long id){
        Produto p = consultarPorId(id);
        em.remove(p);
    }
    
    public Produto consultarPorId(Long id){
        Produto p = null;
        em.find(Produto.class, id);
        return p;
    }
    
}
