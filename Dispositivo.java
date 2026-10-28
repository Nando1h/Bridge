package Bridge;


public interface Dispositivo {
    boolean isEnabled();
    void enable();
    void disable();
    int getVolume();
    void setVolume(int percent);
    int getChannel();
    void setChannel(int channel);
    void printStatus();
    
    default boolean soportaGrabacion() {
        return false;
    }
}
