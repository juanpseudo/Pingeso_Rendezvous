/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import entities.Comuna;
import entities.TipoCargo;
import entities.Trabajador;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;  
import javax.faces.event.ActionEvent;  
import sessionbeans.TrabajadorFacadeLocal;
import javax.faces.application.FacesMessage;  
import javax.servlet.ServletContext;
import org.primefaces.event.FileUploadEvent;  
import org.primefaces.model.UploadedFile; 

/**
 *
 * @author juand_000
 */
@Named(value = "managedBeanTrabajador")
@RequestScoped
public class ManagedBeanTrabajador {
    @EJB
    private TrabajadorFacadeLocal trabajadorFacade;

    /**
     * Creates a new instance of ManagedBeanTrabajador
     */
     
    private int rut;
    private String rut_text;
    private int cargo;
    private String text;  
    private String Cargo_nombre;
    private String Comuna_nombre;
    private String nombre;
    private String apellido_pat;
    private String apellido_mat;
    private String direccion;
    private String telefono_text;
    private int telefono;
    private String correo;
    private Date fecha_nac;
    private List<Trabajador> trabajadores;
    private TipoCargo tipoCargo;
    private Comuna comuna;


    @PostConstruct
    public void init(){
        trabajadores = trabajadorFacade.findAll();
    }
    public String getTelefono_text() {
        return telefono_text;
    }
    public void setTelefono_text(String telefono_text) {
        this.telefono_text = telefono_text;
    }
    public String getRut_text() {
        return rut_text;
    }
    public void setRut_text(String rut_text) {
        this.rut_text = rut_text;
    }
    public void setFecha_nac(Date fecha_nac) {
        this.fecha_nac = fecha_nac;
    }
    public Date getFecha_nac() {
        return fecha_nac;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public void setTipoCargo(TipoCargo tipoCargo) {
        this.tipoCargo = tipoCargo;
    }
    public String getComuna_nombre() {
        return Comuna_nombre;
    }
    public void setComuna_nombre(String Comuna_nombre) {
        this.Comuna_nombre = Comuna_nombre;
    }
    public String getCargo_nombre() {
        return Cargo_nombre;
    }
    public void setCargo_nombre(String Cargo_nombre) {
        this.Cargo_nombre = Cargo_nombre;
    }
    public int getRut() {
        return rut;
    }
    public void setRut(int rut) {
        this.rut = rut;
    }
    public int getCargo() {
        return cargo;
    }
    public void setCargo(int cargo) {
        this.cargo = cargo;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido_pat() {
        return apellido_pat;
    }
    public void setApellido_pat(String apellido_pat) {
        this.apellido_pat = apellido_pat;
    }
    public String getApellido_mat() {
        return apellido_mat;
    }
    public void setApellido_mat(String apellido_mat) {
        this.apellido_mat = apellido_mat;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public int getTelefono() {
        return telefono;
    }
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public List<Trabajador> getTrabajadores() {
        return trabajadores;
    }
    public void setTrabajadores(List<Trabajador> trabajadores) {
        this.trabajadores = trabajadores;
    }
    
   // Se utiliza para agregar un nuevo trabajador a la aplicación 
    
    public void nuevoTrabajador(){
        Trabajador trabajador;
        rut=Integer.parseInt(rut_text);
        telefono=Integer.parseInt(telefono_text);
        trabajador = new Trabajador(rut, nombre, apellido_pat, apellido_mat, direccion, telefono, correo);
        // Guardar el cargo seleccionado
        boolean cont=true;
        int cont1=1;
        while(cont){
            tipoCargo = new TipoCargo(cont1);
            if(tipoCargo.toString().equals(Cargo_nombre)){
                cont=false;
                trabajador.setIdCargo(tipoCargo);
            }
            cont1++;
        }
        // Guardar la comuna seleccionada
        boolean cont2=true;
        int cont3=1;
        while(cont2){
            comuna = new Comuna(cont3);
            if(comuna.toString().equals(Comuna_nombre)){
                cont2=false;
                trabajador.setIdComuna(comuna);
            }
            cont3++;
        }
        trabajador.setFechaNacTrab(fecha_nac);
        trabajadorFacade.create(trabajador);
    }
    
    // A continuación se encuentran las funciones de tipos de mensajes
    
    public void addInfo(ActionEvent actionEvent) {  
       // System.out.println("Q es esto: "+actionEvent);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Se acaba de ingresar exitosamente al nuevo trabajador: ", nombre + " "+ apellido_pat + " " +apellido_mat));  
    }  
    public void addWarn(ActionEvent actionEvent) {  
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Sample warn message", "Watch out for PrimeFaces!"));  
    }  
    public void addError(ActionEvent actionEvent) {  
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample error message", "PrimeFaces makes no mistakes"));  
    }  
    public void addFatal(ActionEvent actionEvent) {  
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Sample fatal message", "Fatal Error in System"));  
    }  
  public void handleFileUpload(FileUploadEvent event) {
        UploadedFile file = event.getFile();
        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        String newFileName = servletContext.getRealPath("") + File.separator + "uploaded" + File.separator+ file.getFileName();
        FacesMessage msg = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");  
     
        FacesContext.getCurrentInstance().addMessage(null, msg); 
        try {
            System.out.println( ": Q mierda es esto???");
        File targetFolder = new File("C:\\img");
        InputStream inputStream = event.getFile().getInputstream();
        OutputStream out = new FileOutputStream(new File(targetFolder,
        event.getFile().getFileName()));
        int read = 0;
        byte[] bytes = new byte[1024];
        while ((read = inputStream.read(bytes)) != -1) {
        out.write(bytes, 0, read);
        }
        inputStream.close();
        out.flush();
        out.close();
        } catch (IOException e) {
        e.printStackTrace();
        }
}
            
   
    
    public void save(ActionEvent actionEvent) {  
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Successful", "Hello " + text));  
        context.addMessage(null, new FacesMessage("Second Message", "Additional Info Here..."));  
    }
    
      public void addInfo2(ActionEvent actionEvent) {  
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Se acaban de modificar exitosamente los datos del trabajador: ", nombre + " "+ apellido_pat + " " +apellido_mat));  
        
     }
   public void addInfo3(ActionEvent actionEvent) {  
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Se acaban de eliminar exitosamente los datos del trabajador: ", nombre + " "+ apellido_pat + " " +apellido_mat));  
    }
    public void borrarTrabajador(){
         Trabajador trabajador;
        rut=Integer.parseInt(rut_text);
        telefono=Integer.parseInt(telefono_text);
        trabajador = new Trabajador(rut, nombre, apellido_pat, apellido_mat, direccion, telefono, correo);
        // Guardar el cargo seleccionado
        boolean cont=true;
        int cont1=1;
        while(cont){
            tipoCargo = new TipoCargo(cont1);
            if(tipoCargo.toString().equals(Cargo_nombre)){
                cont=false;
                trabajador.setIdCargo(tipoCargo);
            }
            cont1++;
        }
        // Guardar la comuna seleccionada
        boolean cont2=true;
        int cont3=1;
        while(cont2){
            comuna = new Comuna(cont3);
            if(comuna.toString().equals(Comuna_nombre)){
                cont2=false;
                trabajador.setIdComuna(comuna);
            }
            cont3++;
        }
        
        trabajador.setFechaNacTrab(fecha_nac);
        trabajadorFacade.remove(trabajador);
    }

    public void modificarTrabajador(){
        Trabajador trabajador;
        rut=Integer.parseInt(rut_text);
        telefono=Integer.parseInt(telefono_text);
        trabajador = new Trabajador(rut, nombre, apellido_pat, apellido_mat, direccion, telefono, correo);
        // Guardar el cargo seleccionado
        boolean cont=true;
        int cont1=1;
        while(cont){
            tipoCargo = new TipoCargo(cont1);
            if(tipoCargo.toString().equals(Cargo_nombre)){
                cont=false;
                trabajador.setIdCargo(tipoCargo);
            }
            cont1++;
        }
        // Guardar la comuna seleccionada
        boolean cont2=true;
        int cont3=1;
        while(cont2){
            comuna = new Comuna(cont3);
            if(comuna.toString().equals(Comuna_nombre)){
                cont2=false;
                trabajador.setIdComuna(comuna);
            }
            cont3++;
        }
        
        trabajador.setFechaNacTrab(fecha_nac);
        trabajadorFacade.edit(trabajador);
    }  
     

 
}
