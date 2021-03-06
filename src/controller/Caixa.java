package controller;
// Generated 04/10/2017 16:18:01 by Hibernate Tools 4.3.1

import dao.DAOSistema;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Query;
import java.util.List;
import java.util.Iterator;

import java.util.HashSet;
import java.util.Set;

/**
 * Caixa generated by hbm2java
 */
public class Caixa  implements java.io.Serializable {


     private Integer caixaId;
     private Usuario usuario;
     private Date dataInicio;
     private Date dataFim;
     private float saldoInicial;
     private Float saldoFinal;
     private String observacao;
     private Set movimentos = new HashSet(0);
    
     public String[] getCaixa(){
         return new String[]{
           String.valueOf(this.caixaId),
             String.valueOf(this.saldoInicial),
             String.valueOf(this.saldoFinal),
             this.observacao
         };
     }
    public Caixa() {
    }

	
    public Caixa(Usuario usuario, float saldoInicial) {
        this.usuario = usuario;
        this.saldoInicial = saldoInicial;
    }
    public Caixa(Usuario usuario, float saldoInicial, Float saldoFinal, String observacao, Set movimentos) {
       this.usuario = usuario;
       this.saldoInicial = saldoInicial;
       this.saldoFinal = saldoFinal;
       this.observacao = observacao;
       this.movimentos = movimentos;
    }
   
    public Integer getCaixaId() {
        return this.caixaId;
    }
    
    public void setCaixaId(Integer caixaId) {
        this.caixaId = caixaId;
    }
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public Date getDataInicio(){
        return this.dataInicio;
    }
    
    public void setDataInicio(Date dataInicio){
        this.dataInicio = dataInicio;
    }
    
    public Date getDataFim(){
        return this.dataFim;
    }
    
    public void setDataFim(Date dataFim){
        this.dataFim = dataFim;
    }
    
    public float getSaldoInicial() {
        return this.saldoInicial;
    }
    
    public void setSaldoInicial(float saldoInicial) {
        this.saldoInicial = saldoInicial;
    }
    public Float getSaldoFinal() {
        return this.saldoFinal;
    }
    
    public void setSaldoFinal(Float saldoFinal) {
        this.saldoFinal = saldoFinal;
    }
    public String getObservacao() {
        return this.observacao;
    }
    
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    public Set getMovimentos() {
        return this.movimentos;
    }
    
    public void setMovimentos(Set movimentos) {
        this.movimentos = movimentos;
    }

    
    public Caixa retornaUltimoCaixa(){
        String sql = "from Caixa order by caixaId desc";
        
        try{
            Session s = DAOSistema.getSessionFactory().openSession();
            s.beginTransaction();
            Query q = s.createQuery(sql);
            List l = q.list();
            Iterator i = l.iterator();
            Caixa c = new Caixa();
            s.getTransaction().commit();
            if(i.hasNext()){
               c = (Caixa)i.next();
               return c; 
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    
    public Caixa retornaCaixa(int caixaId){
        String sql = "from Caixa where caixaId='"+caixaId+"'";
        
        try{
            Session s = DAOSistema.getSessionFactory().openSession();
            s.beginTransaction();
            Query q = s.createQuery(sql);
            List l = q.list();
            Iterator i = l.iterator();
            Caixa c;
            s.getTransaction().commit();
            if(i.hasNext()){
               c = (Caixa)i.next();
               return c; 
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    
    
    public boolean abrirCaixa(Caixa caixa){
        
        try{
            Session s = DAOSistema.getSessionFactory().openSession();
            s.beginTransaction();
            s.save(caixa);
            s.getTransaction().commit();
            return true;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return false;
    }
    
    public boolean fecharCaixa(Caixa caixa){
        
        try{
            Session s = DAOSistema.getSessionFactory().openSession();
            s.beginTransaction();
            s.merge(caixa);
            s.getTransaction().commit();
            return true;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return false;
        
    }


}


