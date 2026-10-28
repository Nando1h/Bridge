# Ejercicio: Patrón Bridge en Java

## 🌉 Contexto del Problema

Tenemos diferentes tipos de dispositivos (e.g., `Radio`, `TV`) y diferentes tipos de controles remotos (e.g., `ControlRemotoBasico`, `ControlRemotoAvanzado`). Queremos evitar una explosión de clases como `ControlRemotoBasicoParaRadio`, `ControlRemotoAvanzadoParaTV`, etc., y permitir que ambas jerarquías evolucionen independientemente.

## 🎯 Tu Tarea

Analizar y comprender cómo el patrón Bridge desacopla la abstracción (controles remotos) de la implementación (dispositivos), permitiendo que ambas jerarquías varíen independientemente.

## 📋 Instrucciones Paso a Paso

### Paso 1: Identifica las Dos Jerarquías

**Jerarquía de Implementación (Dispositivos):**
- Interfaz `Dispositivo` con operaciones básicas de dispositivo
- Clases `Radio` y `TV` que implementan la interfaz

**Jerarquía de Abstracción (Controles):**
- Clase abstracta `ControlRemoto` que contiene referencia a un `Dispositivo`
- Clases `ControlRemotoBasico` y `ControlRemotoAvanzado` que extienden `ControlRemoto`

### Paso 2: Implementa la Interfaz Dispositivo

Crea la interfaz que define las operaciones que todos los dispositivos deben implementar:

```java
public interface Dispositivo {
    boolean isEnabled();
    void enable();
    void disable();
    int getVolume();
    void setVolume(int percent);
    int getChannel();
    void setChannel(int channel);
    void printStatus();
}
```
### Paso 3: Implementa las Clases Concretas de Dispositivos

Para Radio:

```java
public class Radio implements Dispositivo {
    private boolean on = false;
    private int volume = 30;
    private int channel = 1;
    
    @Override
    public boolean isEnabled() { return on; }
    
    @Override
    public void enable() { 
        on = true;
        System.out.println("Radio encendida");
    }
    
    @Override
    public void disable() { 
        on = false;
        System.out.println("Radio apagada");
    }
    
    // Implementa los demás métodos: getVolume, setVolume, getChannel, setChannel
    // y printStatus para mostrar el estado actual
}
```

Para TV:

```java
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
    
    // Implementa los demás métodos similares a Radio
}
```

### Paso 4: Crea la Abstracción Base (ControlRemoto)

Implementa la clase abstracta que contiene el "puente" hacia la implementación:

```java
public abstract class ControlRemoto {
    protected Dispositivo dispositivo; // ¡ESTE ES EL PUENTE!

    public ControlRemoto(Dispositivo dispositivo) {
        this.dispositivo = dispositivo;
    }

    public abstract void togglePower();
    public abstract void volumeDown();
    public abstract void volumeUp();
    public abstract void channelDown();
    public abstract void channelUp();
}
```

### Paso 5: Implementa las Abstracciones Refinadas

Control Remoto Básico:

```java
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
```

Control Remoto Avanzado:

```java
public class ControlRemotoAvanzado extends ControlRemoto {
    public ControlRemotoAvanzado(Dispositivo dispositivo) {
        super(dispositivo);
    }

    // Implementa los mismos métodos básicos
    @Override
    public void togglePower() {
        System.out.println("Control Avanzado: Power inteligente");
        if (dispositivo.isEnabled()) {
            dispositivo.disable();
        } else {
            dispositivo.enable();
        }
    }

    // ... implementa volumeDown, volumeUp, channelDown, channelUp

    // Método adicional solo disponible en el control avanzado
    public void mute() {
        System.out.println("Control Avanzado: Silenciar");
        dispositivo.setVolume(0);
    }

    public void record() {
        System.out.println("Control Avanzado: Grabando programa actual");
        // Lógica específica del control avanzado
    }
}
```

### Paso 6: Experimenta con Diferentes Combinaciones

En la clase Main, prueba diferentes combinaciones de controles y dispositivos:

```java
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
        control2.mute(); // Funcionalidad exclusiva del control avanzado

        // Combinación 3: Control básico con TV
        System.out.println("\n=== Control Básico con TV ===");
        ControlRemoto control3 = new ControlRemotoBasico(new TV());
        probarControlRemoto(control3);

        // Combinación 4: Control avanzado con Radio
        System.out.println("\n=== Control Avanzado con Radio ===");
        ControlRemotoAvanzado control4 = new ControlRemotoAvanzado(new Radio());
        probarControlRemoto(control4);
        control4.record();
    }

    public static void probarControlRemoto(ControlRemoto control) {
        control.togglePower(); // Encender
        control.volumeUp();
        control.channelUp();
        control.volumeDown();
        control.togglePower(); // Apagar
    }
}
```

## 🔍 Puntos Clave del Bridge

El "Puente":

La composición protected Dispositivo dispositivo; en la clase ControlRemoto es el puente que conecta las dos jerarquías independientes.

Ventajas del Patrón:

Evita explosión de clases: Sin Bridge necesitaríamos:

ControlRemotoBasicoRadio
ControlRemotoBasicoTV
ControlRemotoAvanzadoRadio
ControlRemotoAvanzadoTV
Extensibilidad independiente: Podemos agregar nuevos dispositivos O nuevos controles sin afectar la otra jerarquía
### 🤔 Preguntas de Análisis

* Explosión de Clases: ¿Cuántas clases necesitaríamos si tuviéramos 3 tipos de controles y 4 tipos de dispositivos sin el patrón Bridge? ¿Y con el patrón Bridge?

Sin el patrón Bridge se necesitarían 3 × 4 = 12 clases, una por cada combinación de control y dispositivo. Con Bridge solo se necesitan 3 + 4 = 7 clases concretas (más la abstracción ControlRemoto y la interfaz Dispositivo), porque las dos jerarquías evolucionan por separado y se conectan por composición. Así, el número de clases crece sumando y no multiplicando.    

* Acoplamiento: ¿Qué pasaría si la clase ControlRemotoBasico heredara directamente de Radio o TV en lugar de usar composición?

Si ControlRemotoBasico heredara directamente de Radio o TV, quedaría fuertemente acoplado a un dispositivo concreto: solo podría controlar ese tipo de dispositivo y habría que crear una clase nueva por cada combinación, lo que provoca la explosión de clases. Además, no se podría cambiar el dispositivo en tiempo de ejecución, y los cambios en una clase afectarían a la otra. También sería un error de diseño, porque un control remoto no “es un” dispositivo, sino que “usa un” dispositivo. Con composición, el control depende solo de la interfaz Dispositivo, lo que mantiene ambas jerarquías desacopladas.

* Extensibilidad: Si quiero agregar un nuevo dispositivo (ej: Projector), ¿qué cambios necesito hacer? ¿Necesito modificar las clases de controles existentes?

Para agregar un Projector solo hay que crear una nueva clase que implemente la interfaz Dispositivo. No es necesario modificar ninguna de las clases de control existentes (ControlRemoto, ControlRemotoBasico y ControlRemotoAvanzado), porque dependen de la abstracción Dispositivo y no de clases concretas. Así, el nuevo dispositivo funciona con todos los controles sin cambiar su código, lo que cumple el principio Abierto/Cerrado.

* Principios SOLID: ¿Qué principios SOLID se aplican en este patrón? (Especialmente Principio de Inversión de Dependencias y * Principio Abierto/Cerrado)

En el patrón Bridge se aplican principalmente dos principios SOLID. El Principio de Inversión de Dependencias, porque ControlRemoto depende de la interfaz Dispositivo y no de clases concretas como Radio o TV, de modo que tanto la abstracción como la implementación dependen de una abstracción común. El Principio Abierto/Cerrado, porque se pueden agregar nuevos dispositivos (Projector) o nuevos controles (ControlRemotoVoz) sin modificar el código existente. También se aplican el Principio de Responsabilidad Única, ya que cada jerarquía tiene una responsabilidad distinta (operar el dispositivo y funcionar internamente), y el Principio de Sustitución de Liskov, porque cualquier subclase puede usarse en lugar de su tipo base sin alterar el comportamiento del programa.

* Flexibilidad: ¿Cómo nos beneficiamos al poder cambiar el dispositivo de un control en tiempo de ejecución?

Poder cambiar el dispositivo de un control en tiempo de ejecución permite reutilizar un mismo control con distintos dispositivos sin crear nuevas instancias ni nuevas clases. Esto da flexibilidad para decidir dinámicamente qué dispositivo se controla (por ejemplo, según la elección del usuario), reduce la cantidad de objetos y el código duplicado, y facilita las pruebas al poder sustituir un dispositivo real por uno simulado. Es posible gracias a que el control depende de la interfaz Dispositivo y no de una clase concreta, que es la esencia del patrón Bridge.

### 🧪 Ejercicios de Extensión

* Agrega un nuevo dispositivo: Implementa la clase Projector y prueba con los controles existentes.
* Agrega un nuevo control: Crea ControlRemotoVoz que responda a comandos de voz.
* Funcionalidad cruzada: ¿Qué pasaría si algunos controles avanzados solo funcionaran con ciertos dispositivos? ¿Cómo manejarías esta restricción?