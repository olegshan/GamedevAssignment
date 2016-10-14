package players;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by olegshan on 14.10.2016.
 */
public class OpponentFinderTest {
    OpponentFinder opponentFinder = new OpponentFinder();

    @Before
    public void setUp() throws Exception {
        opponentFinder.addPlayer(new Player("Hillary", 12.3));
        opponentFinder.addPlayer(new Player("Donald", -8));
        opponentFinder.addPlayer(new Player("Barack", 21.1));
        opponentFinder.addPlayer(new Player("George", 19));
        opponentFinder.addPlayer(new Player("Bill", 37.8));
        opponentFinder.addPlayer(new Player("Ronald", -18.5));
    }

    @Test
    public void addPlayerTest() throws Exception {
        assertTrue(opponentFinder.playersCount() == 6);
        opponentFinder.addPlayer(new Player("Bernie", 14.5));
        assertTrue(opponentFinder.playersCount() == 7);
    }

    @Test
    public void findOpponentTest() throws Exception {
        Player opponent = opponentFinder.findOpponent(new Player("Nick", 7));
        assertTrue(opponent.getName().equals("Hillary"));
        Player opponent2 = opponentFinder.findOpponent(new Player("Jack", 2));
        assertTrue(opponent2.getName().equals("Donald"));
        Player opponent3 = opponentFinder.findOpponent(new Player("Carl", -14.6));
        assertTrue(opponent3.getName().equals("Ronald"));
        Player opponent4 = opponentFinder.findOpponent(new Player("William", 584.9));
        assertTrue(opponent4.getName().equals("Bill"));
        assertEquals(2, opponentFinder.playersCount());
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void findInEmptyList() throws Exception {
        for (int i = 0; i < 7; i++) {
            opponentFinder.findOpponent(new Player("John Doe", 0.0));
        }
    }
}