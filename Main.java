package Bridge;

public class Main {
    public static void main(String[] args) {
        // Combinación 1: Control básico con Radio
        System.out.println("=== Control Básico con Radio ===");
        ControlRemoto control1 = new ControlRemotoBasico(new Radio());
        probarControlRemoto(control1);

        // Combinación 2: Control avanzado con TV
        System.out.println("\n=== Control Avanzado con TV ===");
        ControlRemotoAvanzado control2 = new ControlRemotoAvanzado(new TV());
        probarControlRemoto(control2);
        control2.mute();
        control2.record();

        // Combinación 3: Control básico con TV
        System.out.println("\n=== Control Básico con TV ===");
        ControlRemoto control3 = new ControlRemotoBasico(new TV());
        probarControlRemoto(control3);

        // Combinación 4: Control avanzado con Radio
        System.out.println("\n=== Control Avanzado con Radio ===");
        ControlRemotoAvanzado control4 = new ControlRemotoAvanzado(new Radio());
        probarControlRemoto(control4);
        control4.record();

        // Combinación 5: Control básico con Projector
        System.out.println("\n=== Control Básico con Projector ===");
        ControlRemoto control5 = new ControlRemotoBasico(new Projector());
        probarControlRemoto(control5);

        // Combinación 6: Control avanzado con Projector
        System.out.println("\n=== Control Avanzado con Projector ===");
        ControlRemotoAvanzado control6 = new ControlRemotoAvanzado(new Projector());
        probarControlRemoto(control6);
        control6.mute();
        control6.record();

        // Combinación 7: Control por voz con TV
        System.out.println("\n=== Control por Voz con TV ===");
        ControlRemotoVoz voz = new ControlRemotoVoz(new TV());
        voz.comando("encender");
        voz.comando("subir volumen");
        voz.comando("siguiente canal");
        voz.comando("abrir netflix");   // comando no reconocido
        voz.comando("apagar");

        // Combinación 8: Control por voz con Projector
        System.out.println("\n=== Control por Voz con Projector ===");
        ControlRemotoVoz voz2 = new ControlRemotoVoz(new Projector());
        voz2.comando("encender");
        voz2.comando("bajar volumen");
        voz2.comando("apagar");
    }

    public static void probarControlRemoto(ControlRemoto control) {
        control.togglePower(); // Encender
        control.volumeUp();
        control.channelUp();
        control.volumeDown();
        control.togglePower(); // Apagar
    }
}