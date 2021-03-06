package controller;
// Generated 05/11/2017 14:50:29 by Hibernate Tools 4.3.1


import java.util.Date;
import dao.DAOSistema;
import java.text.SimpleDateFormat;
import org.hibernate.Session;
import org.hibernate.Query;

import java.util.List;
import java.util.Iterator;
/**
 * Resposta generated by hbm2java
 */
public class Resposta  implements java.io.Serializable {


     private Integer respostaId;
     private Chamado chamado;
     private String resposta;
     private Date data;
     private int atendente;
     private SimpleDateFormat dataExibicao = new SimpleDateFormat("dd/MM/YYYY HH:ss:mm");
    public Resposta() {
    }

    public String[] getRespostas(){
         return new String[]{
           String.valueOf(getRespostaId()),
           String.valueOf(atendente),
           resposta,
           String.valueOf(dataExibicao.format(data))
         };
     }
    public Resposta(Chamado chamado, String resposta, int atendente) {
       this.chamado = chamado;
       this.resposta = resposta;
       this.atendente = atendente;
    }
   
    public Integer getRespostaId() {
        return this.respostaId;
    }
    
    public void setRespostaId(Integer respostaId) {
        this.respostaId = respostaId;
    }
    public Chamado getChamado() {
        return this.chamado;
    }
    
    public void setChamado(Chamado chamado) {
        this.chamado = chamado;
    }
    public String getResposta() {
        return this.resposta;
    }
    
    public void setResposta(String resposta) {
        this.resposta = resposta;
    }
    public Date getData() {
        return this.data;
    }
    
    public void setData(Date data) {
        this.data = data;
    }
    public int getAtendente() {
        return this.atendente;
    }
    
    public void setAtendente(int atendente) {
        this.atendente = atendente;
    }

    
    public boolean cadastraResposta(Resposta resposta){
        try{
            Session s = DAOSistema.getSessionFactory().openSession();
            s.beginTransaction();
            s.save(resposta);
            s.getTransaction().commit();
            return true;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return false;
    }
    
    public Iterator retornaIteratorResposta(int chamadoId){
        String sql = "from Resposta where chamado = '"+chamadoId+"' order by data desc";
        
        try{
            Session s = DAOSistema.getSessionFactory().openSession();
            s.beginTransaction();
            Query q = s.createQuery(sql);
            List l = q.list();
            Iterator i = l.iterator();
            s.getTransaction().commit();
            
            if(i.hasNext()){
                return i;
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    
    public Resposta retornaResposta(int respostaId){
        String sql = "from Resposta where respostaId = '"+respostaId+"'";
        
        try{
            Session s = DAOSistema.getSessionFactory().openSession();
            s.beginTransaction();
            Query q = s.createQuery(sql);
            List l = q.list();
            Iterator i = l.iterator();
            s.getTransaction().commit();
            Resposta r;
            
            if(i.hasNext()){
                r = (Resposta)i.next();
                return r;
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    
    /*public Resposta retornaIteratorResposta(int chamadoId){
        String sql = "from Resposta where chamado = '"+chamadoId+"'";
        
        try{
            Session s = DAOSistema.getSessionFactory().openSession();
            s.beginTransaction();
            Query q = s.createQuery(sql);
            List l = q.list();
            Iterator i = l.iterator();
            s.getTransaction().commit();
            
            Resposta r;
            if(i.hasNext()){
                r = (Resposta)i.next();
                return r;
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

*/
}


