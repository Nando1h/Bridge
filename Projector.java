package Bridge;

public class Projector implements Dispositivo {
    private boolean on = false;
    private int volume = 30;
    private int channel = 1; // en el proyector funciona como "entrada" (HDMI 1, 2...)

    @Override
    public boolean isEnabled() { return on; }

    @Override
    public void enable() {
        on = true;
        System.out.println("Proyector encendido");
    }

    @Override
    public void disable() {
        on = false;
        System.out.println("Proyector apagado");
    }

    @Override
    public int getVolume() { return volume; }

    @Override
    public void setVolume(int percent) {
        volume = Math.max(0, Math.min(100, percent));
    }

    @Override
    public int getChannel() { return channel; }

    @Override
    public void setChannel(int channel) {
        this.channel = Math.max(1, channel);
    }

    @Override
    public void printStatus() {
        System.out.println("Proyector -> " + (on ? "ON" : "OFF")
            + " | Volumen: " + volume + " | Entrada: " + channel);
    }
}

