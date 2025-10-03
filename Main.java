package Bridge;

public class Main {
    public static void main(String[] args) {
        // La magia del Bridge: podemos combinar cualquier control con cualquier dispositivo
        ControlRemoto controlParaTV = new ControlRemotoAvanzado(new TV());
        ControlRemoto controlParaRadio = new ControlRemotoBasico(new Radio());
    }
}