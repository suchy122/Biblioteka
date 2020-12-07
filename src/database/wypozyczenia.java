/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author suchy
 */
public class wypozyczenia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idWypozyczenia")
    private int idWypozyczenia;
    @Column(name="idKsiazki")
    private int idKsiazki;
    @Column(name="idCzytelnika")
    private int idCzytelnika;
    @Column(name="ImNa")
    private String ImNa;
    @Column(name="nazwa")
    private String nazwa;

    public wypozyczenia() {
    }

    public wypozyczenia(int idWypozyczenia, int idKsiazki, int idCzytelnika, String imie, String nazwa) {
        this.idWypozyczenia = idWypozyczenia;
        this.idKsiazki = idKsiazki;
        this.idCzytelnika = idCzytelnika;
        this.ImNa = ImNa;
        this.nazwa = nazwa;
    }

    public int getIdWypozyczenia() {
        return idWypozyczenia;
    }

    public void setIdWypozyczenia(int idWypozyczenia) {
        this.idWypozyczenia = idWypozyczenia;
    }

    public int getIdKsiazki() {
        return idKsiazki;
    }

    public void setIdKsiazki(int idKsiazki) {
        this.idKsiazki = idKsiazki;
    }

    public int getIdCzytelnika() {
        return idCzytelnika;
    }

    public void setIdCzytelnika(int idCzytelnika) {
        this.idCzytelnika = idCzytelnika;
    }

    public String getImNa() {
        return ImNa;
    }

    public void setImNa(String imie) {
        this.ImNa = imie;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    @Override
    public String toString() {
        return "wypozyczenia" + "idWypozyczenia=" + idWypozyczenia + ", idKsiazki=" + idKsiazki + ", idCzytelnika=" + idCzytelnika + ", ImNa=" + ImNa + ", nazwa=" + nazwa;
    }

    

    
    
    
}
