package Bridge;

public class TV implements Dispositivo {
    private boolean on = false;
    private int volume = 30;
    private int channel = 1;

    @Override
    public boolean isEnabled() { return on; }

    @Override
    public void enable() {
        on = true;
        System.out.println("TV encendida");
    }

    @Override
    public void disable() {
        on = false;
        System.out.println("TV apagada");
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
        System.out.println("TV -> " + (on ? "ON" : "OFF")
            + " | Volumen: " + volume + " | Canal: " + channel);
    }
    @Override
    public boolean soportaGrabacion() {
        return true;
    }
}