package circuitbreak.statemod;

public class Test {

    public static void main(String[] args) {

        LightState[] lights = {new RedLight(), new GreenLight(), new YellowLight()};
        LightManager manager = new LightManager(lights[0]);
        int i = 0;
        while (true) {
            manager.changeLight(lights[i++]);
            if (i == lights.length) {
                i = 0;
                System.out.println("-------------------");
            }
        }

    }

}
