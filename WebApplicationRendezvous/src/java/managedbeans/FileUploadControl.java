/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import com.google.common.io.FileBackedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.logging.Level;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.jboss.logging.Logger;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author juand_000
 */
@Named(value = "fileUploadControl")
@SessionScoped
public class FileUploadControl implements Serializable {
    
    private String destino = "C:\\tmp\\";
    private UploadedFile file;



    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    /**
     * Creates a new instance of FileUploadControl
     */
    public FileUploadControl() {
    }
    
    public void TransferFile(String fileName, InputStream in){
        try{
            OutputStream out = new FileOutputStream(new File(destino + fileName));
            int reader = 0;
            byte[] bytes = new byte[(int)getFile().getSize()];
            while ((reader = in.read(bytes)) != -1){
                out.write(bytes,0,reader);
            }
            in.close();
            out.flush();
            out.close();
        } catch(IOException e){
        System.out.println(e.getMessage());
        }
    }
    
    public void upload(){
        String extValidate;
        if(getFile()!=null){
            String ext=getFile().getFileName();
            if(ext!=null){
                extValidate=ext.substring(ext.indexOf(".")+1);
            }else{extValidate="null";}
            if(extValidate.equals("pdf")){
                try{
                    TransferFile(getFile().getFileName(), getFile().getInputstream());
                } catch (IOException ex){
                    //Logger.getLogger(FileUploadControl.class.getName()).log(Level.SEVERE, null,ex);
                    FacesContext context = FacesContext.getCurrentInstance();
                    context.addMessage(null, new FacesMessage("Wrong", "Error uploading file"));
                }
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null,new FacesMessage("Succesful", getFile().getFileName()+"is uploaded. typecontent "+getFile().getContentType()+"tamaño"+getFile().getSize()));
                
            }else{
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage("Wrong_ext", "only extension .pdf"));
            }
        }else{
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Wrong", "Select a file"));
        }
    }
    
}
