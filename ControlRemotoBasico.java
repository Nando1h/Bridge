package Bridge;

public class ControlRemotoBasico extends ControlRemoto {
    public ControlRemotoBasico(Dispositivo dispositivo) {
        super(dispositivo);
    }

    @Override
    public void togglePower() {
        System.out.println("Control Básico: Botón power presionado");
        if (dispositivo.isEnabled()) {
            dispositivo.disable();
        } else {
            dispositivo.enable();
        }
    }

    @Override
    public void volumeDown() {
        System.out.println("Control Básico: Bajar volumen");
        dispositivo.setVolume(dispositivo.getVolume() - 10);
    }

    @Override
    public void volumeUp() {
        System.out.println("Control Básico: Subir volumen");
        dispositivo.setVolume(dispositivo.getVolume() + 10);
    }

    @Override
    public void channelDown() {
        System.out.println("Control Básico: Canal anterior");
        dispositivo.setChannel(dispositivo.getChannel() - 1);
    }

    @Override
    public void channelUp() {
        System.out.println("Control Básico: Canal siguiente");
        dispositivo.setChannel(dispositivo.getChannel() + 1);
    }
}
