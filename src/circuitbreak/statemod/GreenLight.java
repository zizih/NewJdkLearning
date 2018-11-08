package circuitbreak.statemod;

public class GreenLight extends Light implements LightState {


    @Override
    public void showLight() {
        System.out.println("绿灯亮了");
        sleep(1000l);
    }
}
