import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StereoTest {

    Stereo stereo;
    Radio radio;
    CDPlayer cdPlayer;
    Tape tape;

    @Before
    public void setUp()  {
        stereo = new Stereo("My Stereo");
        radio = new Radio(MakeType.SONY, 123, 12, 97.3);
        cdPlayer = new CDPlayer(MakeType.SENNHEISER, 1223, 23);
        tape = new Tape(MakeType.JBL, 435, 19);
    }

    @Test
    public void getName() {
        assertEquals("My Stereo", stereo.getName());
    }

    @Test
    public void getComponents() {
        assertEquals(0, stereo.getComponents().size());
    }

    @Test
    public void addComponent(){
        stereo.addComponent(radio);
        assertEquals(1, stereo.getComponents().size());
        assertEquals(radio, stereo.getComponents().get(0));
        assertEquals(123, stereo.getComponents().get(0).getModel());
        stereo.addComponent(cdPlayer);
        assertEquals(2, stereo.getComponents().size());
        assertEquals(cdPlayer, stereo.getComponents().get(1));
        assertEquals(23, stereo.getComponents().get(1).getVolume());
        stereo.addComponent(tape);
        assertEquals(3, stereo.getComponents().size());
        assertEquals(tape, stereo.getComponents().get(2));
        assertEquals(MakeType.JBL, stereo.getComponents().get(2).getMake());
    }
}