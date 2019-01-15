import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TapeTest {

    Tape tape;
    @Before
    public void setUp(){
        tape = new Tape(MakeType.BOSE, 729, 15);
    }

    @Test
    public void getTapePosition() {
        assertEquals(0, tape.getTapePosition(), 0.01);
    }

    @Test
    public void isTrayFull() {
        assertFalse(tape.getTrayFull());
    }

    @Test
    public void isCurrentlyPlaying() {
        assertFalse(tape.getCurrentlyPlaying());
    }

    @Test
    public void getMake() {
        assertEquals(MakeType.BOSE, tape.getMake());
    }

    @Test
    public void getModel() {
        assertEquals(729, tape.getModel());
    }

    @Test
    public void getVolume() {
        assertEquals(15, tape.getVolume());
    }


    @Test
    public void canChangeVolume(){
        tape.changeVolume(84);
        assertEquals(99, tape.getVolume());
    }

    @Test
    public void cantChangeVolumeBelowZero(){
        tape.changeVolume(-99);
        assertEquals(0, tape.getVolume());
    }

    @Test
    public void cantChangeVolumeAboveHundreds(){
        tape.changeVolume(999);
        assertEquals(100, tape.getVolume());
    }

    @Test
    public void canInsert(){
        tape.insert();
        assertTrue(tape.getTrayFull());
    }

    @Test
    public void canEject(){
        tape.insert();
        assertTrue(tape.getTrayFull());
        tape.eject();
        assertFalse(tape.getTrayFull());
    }

    @Test
    public void canPlay(){
        tape.insert();
        assertTrue(tape.getTrayFull());
        assertFalse(tape.getCurrentlyPlaying());
        tape.play();
        assertTrue(tape.getCurrentlyPlaying());
    }

    @Test
    public void cantPlayWithNoCD(){
        tape.play();
        assertFalse(tape.getCurrentlyPlaying());
    }

    @Test
    public void canStop(){
        tape.insert();
        assertTrue(tape.getTrayFull());
        assertFalse(tape.getCurrentlyPlaying());
        tape.play();
        assertTrue(tape.getCurrentlyPlaying());
        tape.stop();
        assertFalse(tape.getCurrentlyPlaying());
    }

    @Test
    public void canForward(){
        tape.insert();
        assertTrue(tape.getTrayFull());
        tape.fastForward(20);
        assertEquals(20, tape.getTapePosition(), 0.01);
    }

    @Test
    public void canForwardAbove100(){
        tape.insert();
        assertTrue(tape.getTrayFull());
        tape.fastForward(120);
        assertEquals(100, tape.getTapePosition(), 0.01);
    }

    @Test
    public void canRewind(){
        tape.insert();
        assertTrue(tape.getTrayFull());
        tape.fastForward(20);
        assertEquals(20, tape.getTapePosition(), 0.01);
        tape.rewind(10);
        assertEquals(10, tape.getTapePosition(), 0.01);
    }

    @Test
    public void canRewindPastZero(){
        tape.insert();
        assertTrue(tape.getTrayFull());
        tape.fastForward(20);
        assertEquals(20, tape.getTapePosition(), 0.01);
        tape.rewind(30);
        assertEquals(00, tape.getTapePosition(), 0.01);
    }

    @Test
    public void cantForwardWithNoTape(){
        tape.fastForward(45.5);
        assertEquals(0, tape.getTapePosition(), 0.01);
    }
}