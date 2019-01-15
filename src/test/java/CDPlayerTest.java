import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CDPlayerTest {

        CDPlayer cdPlayer;

        @Before
        public void beforeEach(){
            cdPlayer = new CDPlayer(MakeType.JBL,567,10);
        }

        @Test
        public void canGetMake(){
            assertEquals(MakeType.JBL, cdPlayer.getMake());
        }

        @Test
        public void canGetModel(){
            assertEquals(567, cdPlayer.getModel());
        }

        @Test
        public void canGetVolume(){
            assertEquals(10, cdPlayer.getVolume());
        }

    @Test
    public void canChangeVolume(){
        cdPlayer.changeVolume(89);
        assertEquals(99, cdPlayer.getVolume());
    }

    @Test
    public void cantChangeVolumeBelowZero(){
        cdPlayer.changeVolume(-99);
        assertEquals(0, cdPlayer.getVolume());
    }

    @Test
    public void cantChangeVolumeAboveHundreds(){
        cdPlayer.changeVolume(999);
        assertEquals(100, cdPlayer.getVolume());
    }

    @Test
    public void getCurrentTrackInitial() {
            assertEquals(0,cdPlayer.getCurrentTrack());
    }

    @Test
    public void getTrayFullInitial() {
            assertFalse(cdPlayer.getTrayFull());
    }

    @Test
    public void getCurrentlyPlayingInitial() {
            assertFalse(cdPlayer.getCurrentlyPlaying());
    }

    @Test
    public void canInsert(){
            cdPlayer.insert();
            assertTrue(cdPlayer.getTrayFull());
    }

    @Test
    public void canEject(){
        cdPlayer.insert();
        assertTrue(cdPlayer.getTrayFull());
        assertEquals(1, cdPlayer.getCurrentTrack());
        cdPlayer.eject();
        assertFalse(cdPlayer.getTrayFull());
        assertEquals(0, cdPlayer.getCurrentTrack());
    }

    @Test
    public void canPlay(){
        cdPlayer.insert();
        assertTrue(cdPlayer.getTrayFull());
        assertFalse(cdPlayer.getCurrentlyPlaying());
        cdPlayer.play();
        assertTrue(cdPlayer.getCurrentlyPlaying());
    }

    @Test
    public void cantPlayWithNoCD(){
        cdPlayer.play();
        assertFalse(cdPlayer.getCurrentlyPlaying());
    }

    @Test
    public void canStop(){
        cdPlayer.insert();
        assertTrue(cdPlayer.getTrayFull());
        assertFalse(cdPlayer.getCurrentlyPlaying());
        cdPlayer.play();
        assertTrue(cdPlayer.getCurrentlyPlaying());
        cdPlayer.stop();
        assertFalse(cdPlayer.getCurrentlyPlaying());
    }

    @Test
    public void skipTrack() {
        cdPlayer.insert();
        assertTrue(cdPlayer.getTrayFull());
        assertFalse(cdPlayer.getCurrentlyPlaying());
        cdPlayer.play();
        assertTrue(cdPlayer.getCurrentlyPlaying());
        assertEquals(1, cdPlayer.getCurrentTrack());
        cdPlayer.skipTrack();
        assertEquals(2, cdPlayer.getCurrentTrack());
    }
}
