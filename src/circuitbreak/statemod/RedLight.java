package circuitbreak.statemod;

public class RedLight extends Light implements LightState {


    @Override
    public void showLight() {
        System.out.println("红灯亮了");
        sleep(1000l);
    }
}
