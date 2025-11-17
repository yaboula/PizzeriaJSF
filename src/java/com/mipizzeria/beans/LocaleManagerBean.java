package com.mipizzeria.beans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Locale;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

@Named(value = "localeManagerBean")
@SessionScoped
public class LocaleManagerBean implements Serializable {

    private String localeCode = "es";

    public LocaleManagerBean() {
    }

    public String getLocaleCode() {
        return localeCode;
    }

    public void setLocaleCode(String localeCode) {
        this.localeCode = localeCode;
    }

    public void cambioIdioma(ValueChangeEvent e) {
        String nuevoIdioma = e.getNewValue().toString();
        this.localeCode = nuevoIdioma;
        FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale(nuevoIdioma));
    }
}
