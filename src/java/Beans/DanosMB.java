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
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.primefaces.event.FileUploadEvent;
import static org.springframework.util.FileCopyUtils.BUFFER_SIZE;

@ManagedBean(name = "danosMB")
@ViewScoped
public class DanosMB implements Serializable{
    @EJB
    DanosEJB danosEJB;
    private Danos danos;
    private Laudo laudo;
    
    public DanosMB() {
    danos = new Danos();
    }

    public Danos getDanos() {
        return danos;
    }

    public void setDanos(Danos danos) {
        this.danos = danos;
    }

    public Laudo getLaudo() {
        return laudo;
    }

    public void setLaudo(Laudo laudo) {
        this.laudo = laudo;
    }
    
    public void salvar(){
        if(danos.getIdDanos() == null){
            try{
                danos.setLaudo(laudo);
                danosEJB.salvar(danos);
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, new FacesMessage("Salvo com sucesso!"));
            }catch(Exception e){
                e.printStackTrace();
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, new FacesMessage("Erro ao salvar Danos!"));
            }
        }else{
            try{
                danos.setLaudo(laudo);
                danosEJB.salvar(danos);
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, new FacesMessage("Editado com sucesso!"));
                danos = new Danos();
            }catch(Exception e){
                e.printStackTrace();
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.addMessage(null, new FacesMessage("Erro ao editar Danos!"));
            }
        }
    }
    
    public List<Danos> listarDanos(){
        return danosEJB.listarDanoss();
    }
    
    public void selecionarDanos(Danos danos) {
        this.danos = danos;
    }
    
    public void Remover(Danos danos){
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
        ExternalContext extContext = FacesContext.getCurrentInstance().getExternalContext();
        File result = new File(extContext.getRealPath("//resources//uploaded//" + event.getFile().getFileName()));
        System.out.println(extContext.getRealPath("//resources//uploaded//" + event.getFile().getFileName()));
 
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
 
            FacesMessage msg = new FacesMessage("O arquivo: " + event.getFile().getFileName() + " foi upado com sucesso!.");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            danos.setImagem(event.getFile().getFileName());
 
        } catch (IOException e) {
            e.printStackTrace();
            FacesMessage error = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao enviar imagem.", "");
            FacesContext.getCurrentInstance().addMessage(null, error);
        }
    }
    
}
