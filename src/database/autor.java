package database;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class autor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idAutora")
    private int idAutora;
    @Column(name="imie")
    private String imie;
    @Column(name="nazwisko")
    private String nazwisko;

    public autor() {
    }

    public autor(int idAutora, String imie, String nazwisko) {
        this.idAutora = idAutora;
        this.imie = imie;
        this.nazwisko = nazwisko;
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
        return "Autor" + "idAutora=" + idAutora + ", imie=" + imie + ", nazwisko=" + nazwisko;
    }
    
    
}
