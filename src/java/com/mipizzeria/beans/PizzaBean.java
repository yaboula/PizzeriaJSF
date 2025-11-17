

package com.mipizzeria.beans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Named(value = "pizzaBean")
@SessionScoped
public class PizzaBean implements Serializable {

    
    private String masa;
    private String salsa;
    private String queso;

   
    public PizzaBean() {
    }

    public String getMasa() {
        return masa;
    }

    public void setMasa(String masa) {
        this.masa = masa;
    }

    public String getSalsa() {
        return salsa;
    }

    public void setSalsa(String salsa) {
        this.salsa = salsa;
    }

    public String getQueso() {
        return queso;
    }

    public void setQueso(String queso) {
        this.queso = queso;
    }

public String elegirMasa(String tipoMasa) {
    this.masa = tipoMasa;
    return null;
}

public String elegirSalsa(String tipoSalsa) {
    this.salsa = tipoSalsa;
    return null;
}

public String elegirQueso(String tipoQueso) {
    this.queso = tipoQueso;
    return null;
}
    
    
    
public String navegarA(String categoria) {
    switch (categoria) {
        case "masa":
            return "ir_a_masas"; 
        case "salsa":
            return "ir_a_salsas"; 
        case "queso":
            return "ir_a_quesos"; 
        default:
            return "volver_a_categorias"; 
    }
}   





public String procederAlPago() {
    
    if (masa == null || masa.isEmpty() || 
        salsa == null || salsa.isEmpty() || 
        queso == null || queso.isEmpty()) {

        FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, "¡Pizza Incompleta!", "Debes seleccionar un ingrediente de cada categoría.");
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
        return null; 
    } else {
        return "ir_a_facturacion";
    }
}

public String logout() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().invalidateSession();
        return "/bienvenida.xhtml?faces-redirect=true";
    }

public String getNombreUsuario() {
        FacesContext context = FacesContext.getCurrentInstance();
        String nombre = context.getExternalContext().getRemoteUser();
        
        if (nombre != null) {
            return nombre;
        } else {
            return "invitado";
        }
    }
}