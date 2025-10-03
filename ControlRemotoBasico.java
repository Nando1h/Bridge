package Bridge;

public class ControlRemotoBasico extends ControlRemoto {
    public ControlRemotoBasico(Dispositivo dispositivo) { super(dispositivo); }
    // Implementa los métodos abstractos usando 'dispositivo'
    public void togglePower() {
        if (dispositivo.isEnabled()) dispositivo.disable();
        else dispositivo.enable();
    }
    // ... Implementa volumeDown, volumeUp, etc. ...
}