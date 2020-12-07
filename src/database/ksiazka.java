package database;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class ksiazka {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idKsiazki")
    private int idKsiazki;
    @Column(name="nazwa")
    private String nazwa;
    @Column(name="rokWydania")
    private int rokWydania;
    @Column(name="idAutora")
    private int idAutora;
    @Column(name="imie")
    private String imie;
    @Column(name="nazwisko")
    private String nazwisko;

    public ksiazka() {
    }

    public ksiazka(int idKsiazki, String nazwa, int rokWydania, int idAutora, String imie, String nazwisko) {
        this.idKsiazki = idKsiazki;
        this.nazwa = nazwa;
        this.rokWydania = rokWydania;
        this.idAutora = idAutora;
        this.imie = imie;
        this.nazwisko = nazwisko;
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

    public int getRokWydania() {
        return rokWydania;
    }

    public void setRokWydania(int rokWydania) {
        this.rokWydania = rokWydania;
    }

    public int getIdAutora() {
        return idAutora;
    }

    public void setIdAutora(int idAutora) {
        this.idAutora = idAutora;
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

    @Override
    public String toString() {
        return "ksiazka" + "idKsiazki=" + idKsiazki + ", nazwa=" + nazwa + ", rokWydania=" + rokWydania + ", idAutora=" + idAutora + ", imie=" + imie + ", nazwisko=" + nazwisko;
    }

    
    
    
            
}
