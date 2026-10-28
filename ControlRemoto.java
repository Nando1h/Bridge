package Bridge;

public abstract class ControlRemoto {
    protected Dispositivo dispositivo; // el puente

    public ControlRemoto(Dispositivo dispositivo) {
        this.dispositivo = dispositivo;
    }

    public abstract void togglePower();
    public abstract void volumeDown();
    public abstract void volumeUp();
    public abstract void channelDown();
    public abstract void channelUp();
}