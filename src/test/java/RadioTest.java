import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RadioTest {

    Radio radio;

    @Before
    public void beforeEach(){
        radio = new Radio(MakeType.JBL,567,10,97.3);
    }

    @Test
    public void canGetMake(){
        assertEquals(MakeType.JBL, radio.getMake());
    }

    @Test
    public void canGetModel(){
        assertEquals(567, radio.getModel());
    }

    @Test
    public void canGetVolume(){
        assertEquals(10, radio.getVolume());
    }

    @Test
    public void canGetFrequency(){
        assertEquals(97.3, radio.getFrequency(), 0.01);
    }

    @Test
    public void canSetFrequency(){
        radio.tune(103.2);
        assertEquals(103.2, radio.getFrequency(), 0.01);
    }

    @Test
    public void canChangeVolume(){
        radio.changeVolume(89);
        assertEquals(99, radio.getVolume());
    }

    @Test
    public void cantChangeVolumeBelowZero(){
        radio.changeVolume(-99);
        assertEquals(0, radio.getVolume());
    }

    @Test
    public void cantChangeVolumeAboveHundreds(){
        radio.changeVolume(999);
        assertEquals(100, radio.getVolume());
    }
}
