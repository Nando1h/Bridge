package Bridge;

public class ControlRemotoVoz extends ControlRemoto {
    public ControlRemotoVoz(Dispositivo dispositivo) {
        super(dispositivo);
    }

    @Override
    public void togglePower() {
        System.out.println("Control por Voz: Alternar encendido");
        if (dispositivo.isEnabled()) {
            dispositivo.disable();
        } else {
            dispositivo.enable();
        }
    }

    @Override
    public void volumeDown() {
        System.out.println("Control por Voz: Bajar volumen");
        dispositivo.setVolume(dispositivo.getVolume() - 10);
    }

    @Override
    public void volumeUp() {
        System.out.println("Control por Voz: Subir volumen");
        dispositivo.setVolume(dispositivo.getVolume() + 10);
    }

    @Override
    public void channelDown() {
        System.out.println("Control por Voz: Canal anterior");
        dispositivo.setChannel(dispositivo.getChannel() - 1);
    }

    @Override
    public void channelUp() {
        System.out.println("Control por Voz: Canal siguiente");
        dispositivo.setChannel(dispositivo.getChannel() + 1);
    }

    // Funcionalidad exclusiva: interpretar comandos de voz
    public void comando(String texto) {
        System.out.println("Control por Voz: escuché \"" + texto + "\"");
        switch (texto.toLowerCase().trim()) {
            case "encender", "apagar" -> togglePower();
            case "subir volumen" -> volumeUp();
            case "bajar volumen" -> volumeDown();
            case "siguiente canal" -> channelUp();
            case "canal anterior" -> channelDown();
            default -> System.out.println("Comando no reconocido: " + texto);
        }
    }
}
