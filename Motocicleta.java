// src/com/tuproyecto/model/Motocicleta.jav
public class Motocicleta {
    private String placa;
    private String marca;
    private String modelo;
    private int año;

    public Motocicleta(String placa, String marca, String modelo, int año) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.año   = año;
    }

    // Getters y setters
    public String getPlaca()  { return placa; }
    public void   setPlaca(String p) { this.placa = p; }
    public String getMarca()  { return marca; }
    public void   setMarca(String m) { this.marca = m; }
    public String getModelo() { return modelo; }
    public void   setModelo(String m) { this.modelo = m; }
    public int    getAño()    { return año; }
    public void   setAño(int a)     { this.año = a; }

    @Override
    public String toString() {
        return placa + " | " + marca + " " + modelo + " (" + año + ")";
    }
}
