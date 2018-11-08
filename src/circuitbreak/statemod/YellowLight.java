package circuitbreak.statemod;

public class YellowLight extends Light implements LightState {


    @Override
    public void showLight() {
        System.out.println("黄灯亮了");
        sleep(1000l);
    }
}
