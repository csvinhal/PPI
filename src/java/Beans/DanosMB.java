package Beans;

import Controller.DanosEJB;
import Model.Danos;
import Model.Laudo;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.primefaces.event.FileUploadEvent;
import static org.springframework.util.FileCopyUtils.BUFFER_SIZE;

@ManagedBean(name = "danosMB")
@SessionScoped
public class DanosMB implements Serializable{
    @EJB
    DanosEJB danosEJB;
    private Danos danos;
    
    public DanosMB() {
        danos = new Danos();
    }


    //SETS E GETS
    public Danos getDanos() {
        return danos;
    }

    public void setDanos(Danos danos) {
        this.danos = danos;
    }

    
    //METODOS
    public void salvar(){
        try{
            danosEJB.salvar(danos);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, new FacesMessage("Salvo com sucesso!"));
            danos = new Danos();
        }catch(Exception e){
            e.printStackTrace();
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, new FacesMessage("Erro ao salvar Danos!"));
        }
    }
    
    public List<Danos> listarDanos(){
        return danosEJB.listarDanos();
    }
    
    public List<Danos> listarDanosLaudo(){
        Integer id = 0;
        if(danos.getLaudo() != null){
            id = danos.getLaudo().getIdLaudo();
        }
        System.out.println(id);
        return danosEJB.listarDanosLaudo(id);

    }

    public void selecionarDanos(Danos danos) {
        this.danos = danos;
    }
    
    public void remover(Danos danos){
        try{
            danosEJB.excluir(danos);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, new FacesMessage("Danos excluído com sucesso!"));
        }catch(Exception e){
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, new FacesMessage("Erro ao excluir Danos!"));
        }
    }
    
    public void handleFileUpload(FileUploadEvent event) {
        Long nomeImagem = System.currentTimeMillis();
        File result = new File("C:/Users/Cristiano/Documents/NetBeansProjects/Upload/" 
                + nomeImagem.toString() + ".jpg");
 
        try {
            InputStream inputStream;
            try (FileOutputStream fileOutputStream = new FileOutputStream(result)) {
                byte[] buffer = new byte[BUFFER_SIZE];
                int bulk;
                inputStream = event.getFile().getInputstream();
                while (true) {
                    bulk = inputStream.read(buffer);
                    if (bulk < 0) {
                        break;
                    }
                    fileOutputStream.write(buffer, 0, bulk);
                    fileOutputStream.flush();
                }
            }
            inputStream.close();
 
            FacesMessage msg = new FacesMessage("O arquivo: " + nomeImagem + ".jpg " + " foi upado com sucesso!.");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            danos.setImagem(nomeImagem + ".jpg");
 
        } catch (IOException e) {
            e.printStackTrace();
            FacesMessage error = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao enviar imagem.", "");
            FacesContext.getCurrentInstance().addMessage(null, error);
        }
    }
    
}
