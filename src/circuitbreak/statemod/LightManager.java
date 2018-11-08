package circuitbreak.statemod;

public class LightManager {

    private LightState state;

    public LightManager(LightState state) {
        this.state = state;
    }

    public void changeLight(LightState nextState) {
        nextState.showLight();
        this.state = nextState;
    }
}
