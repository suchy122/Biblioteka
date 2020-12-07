package database;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class czytelnik {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idCzytelnika")
    private int idCzytelnika;
    @Column(name="imie")
    private String imie;
    @Column(name="nazwisko")
    private String nazwisko;
    @Column(name="miasto")
    private String miasto;
    @Column(name="pesel")
    private int pesel;
    @Column(name="idKsiazki")
    private int idKsiazki;
    @Column(name="nazwa")
    private String nazwa;

    public czytelnik() {
    }

    public czytelnik(int idCzytelnika, String imie, String nazwisko, String miasto, int pesel, int idKsiazki, String nazwa) {
        this.idCzytelnika = idCzytelnika;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.miasto = miasto;
        this.pesel = pesel;
        this.idKsiazki = idKsiazki;
        this.nazwa=nazwa;
    }

    public int getIdCzytelnika() {
        return idCzytelnika;
    }

    public void setIdCzytelnika(int idCzytelnika) {
        this.idCzytelnika = idCzytelnika;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public int getPesel() {
        return pesel;
    }

    public void setPesel(int pesel) {
        this.pesel = pesel;
    }

    public int getIdKsiazki() {
        return idKsiazki;
    }

    public void setIdKsiazki(int idKsiazki) {
        this.idKsiazki = idKsiazki;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    @Override
    public String toString() {
        return "czytelnik" + "idCzytelnika=" + idCzytelnika + ", imie=" + imie + ", nazwisko=" + nazwisko + ", miasto=" + miasto + ", pesel=" + pesel + ", idKsiazki=" + idKsiazki + ", nazwa=" + nazwa;
    }
    
    
}
