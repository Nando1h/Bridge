package Bridge;

public class ControlRemotoAvanzado extends ControlRemoto {
    public ControlRemotoAvanzado(Dispositivo dispositivo) { super(dispositivo); }
    // ... Implementa los métodos básicos ...
    public void mute() { dispositivo.setVolume(0); } // Funcionalidad extra
}