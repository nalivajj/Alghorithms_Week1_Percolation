/**
 * Created by naliv on 31.01.2018.
 */
public class Site {
    private State siteState;
    private int value;

    Site(){
        siteState = State.blocked;
    }

    public State getSiteState() {
        return siteState;
    }

    public int getValue() {
        return value;
    }

    public void setSiteState(State siteState) {
        this.siteState = siteState;
    }

    public void setValue(int value) {
        this.value = value;
    }

    enum State {blocked, open};
}
