import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MP3Test {

    MP3 mp3;
    Stereo stereo;

    @Before
    public void setUp(){
        mp3 = new MP3("IPOD");
        stereo = new Stereo("my stereo");
    }

    @Test
    public void connect() {
        assertEquals("my stereo", mp3.connect(stereo));
    }
}