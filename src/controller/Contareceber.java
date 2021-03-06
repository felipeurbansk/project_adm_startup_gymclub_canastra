package controller;
// Generated 04/10/2017 16:18:01 by Hibernate Tools 4.3.1


import dao.DAOSistema;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * Contareceber generated by hbm2java
 */
public class Contareceber  implements java.io.Serializable {


     private Integer contaReceberId;
     private Fornecedor fornecedor;
     private Transacao transacao;
     private Date vencimento;
     private float valor;
     private float desconto;
     private float multa;
     private Date dataEmissao;
     private int parcela;
     private float total;
     private String descricao;

     public String[] getContaReceber(){
         return new String[]{
             String.valueOf(this.contaReceberId),
             this.descricao,
             String.valueOf("R$"+this.valor),
             String.valueOf("R$"+this.multa),
             String.valueOf("R$"+this.total),
         };
     }
    public Contareceber() {
    }

    public Contareceber(Date vencimento, float valor, float desconto, float multa, Date dataEmissao, int parcela, String descricao) {
       //Remover estrangeira Fornecedor, não será utilizado no conta receber
        this.fornecedor = fornecedor;
       this.transacao = transacao;
       this.vencimento = vencimento;
       this.valor = valor;
       this.desconto = desconto;
       this.multa = multa;
       this.dataEmissao = dataEmissao;
       this.parcela = parcela;
       this.descricao = descricao;
       this.somarTotal();
    }
   
    public Integer getContaReceberId() {
        return this.contaReceberId;
    }
    
    public void setContaReceberId(Integer contaReceberId) {
        this.contaReceberId = contaReceberId;
    }
    public Fornecedor getFornecedor() {
        return this.fornecedor;
    }
    
    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
    public Transacao getTransacao() {
        return this.transacao;
    }
    
    public void setTransacao(Transacao transacao) {
        this.transacao = transacao;
    }
    public Date getVencimento() {
        return this.vencimento;
    }
    
    public void setVencimento(Date vencimento) {
        this.vencimento = vencimento;
    }
    public float getValor() {
        return this.valor;
    }
    
    public void setValor(float valor) {
        this.valor = valor;
    }
    public float getDesconto() {
        return this.desconto;
    }
    
    public void setDesconto(float desconto) {
        this.desconto = desconto;
    }
    public float getMulta() {
        return this.multa;
    }
    
    public void setMulta(float multa) {
        this.multa = multa;
    }
    public Date getDataEmissao() {
        return this.dataEmissao;
    }
    
    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }
    public int getParcela() {
        return this.parcela;
    }
    
    public void setParcela(int parcela) {
        this.parcela = parcela;
    }
    public float getTotal() {
        return this.total;
    }
    
    public void setTotal(float total) {
        this.total = total;
    }
    public String getDescricao() {
        return this.descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public void somarTotal(){
        this.total = (this.valor + this.multa) - this.desconto;
    }


    public Iterator retornaContaReceber(String pesquisa,int filtro, int tipoConsulta){
        
        String sql = "from Contareceber c";
        
        if(tipoConsulta >= 0){
            switch(tipoConsulta){
                case 0:
                    //Contas a receber não vencidas
                    sql += " where c.transacao.situacao.situacaoId  = '6'";
                    break;
                case 1:
                    //Contas a receber vencidas
                    sql += " where c.transacao.situacao.situacaoId  = '1' ";
                    break;
                case 2:
                    // Contas a receber Pagas
                    sql += " where c.transacao.situacao.situacaoId  = '2' ";
                    break;
                case 3:
                    break;
            }
        }
        
        if(pesquisa != null){
            switch(filtro){
                case 0:
                    //Contas a receber por id
                    sql += " and c.contaReceberId = '"+pesquisa+"'";
                    break;
                case 1:
                    //Contas a receber por descrição
                    sql += " and c.descricao LIKE '%"+pesquisa+"%'";
                    break;
                case 2:
                    //Contas a receber por valor
                    sql  += " and c.valor LIKE '%"+pesquisa+"%'";
                    break;
                    
                case 3:
                    //Conta a receber por multa
                    sql += " and c.multa LIKE '%"+pesquisa+"%'";
                    break;
                case 4:
                    //Conta a receber por toral
                    sql += " and c.total LIKE '%"+pesquisa+"%'";
                    break;

            }
        }
        
        try{
            Session s = DAOSistema.getSessionFactory().openSession();
            s.beginTransaction();
            Query q = s.createQuery(sql);
            List l = q.list();
            Iterator i = l.iterator();
            s.getTransaction().commit();
            return i;
        }catch(Exception ex){
            ex.printStackTrace();
        }
            return null;
    }
    
    public  void cadastraContaReceber(Contareceber contaPagar){
        try{
            Session s = DAOSistema.getSessionFactory().openSession();
            s.beginTransaction();
            s.save(contaPagar);
            s.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public Contareceber retornaContaReceber(int contaReceberId){
        String sql = "from Contareceber where contaReceberId = '"+contaReceberId+"'";
        
        try{
            Session s = DAOSistema.getSessionFactory().openSession();
            s.beginTransaction();
            Query q = s.createQuery(sql);
            List l = q.list();
            Iterator i = l.iterator();
            Contareceber c;
            
            s.getTransaction().commit();
            if(i.hasNext()){
                c = (Contareceber)i.next();
                return c;
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    
    public boolean atualizarSituacaoContaReceber(Contareceber conta, int situacaoId){
        String sql = "update Transacao t set t.situacao.situacaoId = '"+situacaoId+"', t.data = CURRENT_TIMESTAMP where t.transacaoId = '"+conta.getTransacao().getTransacaoId()+"'";
        
        try{
            Session s = DAOSistema.getSessionFactory().getCurrentSession();
            s.beginTransaction();
            Query q = s.createQuery(sql);
            q.executeUpdate();
            s.getTransaction().commit();
            return true;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return false;
    }
    
    public boolean atualizaCaixa(int contaReceberId, int caixaId){
        String sql = "update Contareceber set caixa.caixaId = '"+caixaId+"' where contaRecenerId = '"+contaReceberId+"'";
        try{
            Session s = DAOSistema.getSessionFactory().openSession();
            s.beginTransaction();
            Query q = s.createQuery(sql);
            q.executeUpdate();
            s.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return false;
    }
    
    public void gerarRelatorio(String sql){
        String arquivo = "src/relatorios/report_contaReceber.jasper";
        try{
            Session s = DAOSistema.getSessionFactory().openSession();
            s.beginTransaction();
            Query q = s.createQuery(sql);
            List l = q.list();
  
            JRBeanCollectionDataSource dados = new JRBeanCollectionDataSource(l);
            JasperPrint jp = JasperFillManager.fillReport(arquivo, new HashMap(),dados);

            JasperViewer.viewReport(jp, false);
            s.getTransaction().commit();
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

}


