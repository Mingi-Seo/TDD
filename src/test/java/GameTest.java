import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Mingi-Seo on 2014-11-29.
 */
public class GameTest {

    private Game g;

    @Before
    public void setUp() throws Exception {
        g = new Game();
    }

    private void rollMany(int rolls, int pins) {
        for (int i = 0; i < rolls; i++)
            g.roll(pins);
    }

    @Test
    public void canRoll() {
        g.roll(0);
    }

    @Test
    public void gutterGame() {
        rollMany(20, 0);
        assertThat(g.score(), is(0));
    }

    @Test
    public void allOnes() {
        rollMany(20, 1);
        assertThat(g.score(), is(20));
    }

    @Test
    public void oneSpare() {
        rollSpare();
        g.roll(3);
        rollMany(17, 0);
        assertThat(g.score(), is(16));
    }

    private void rollSpare() {
        g.roll(5);
        g.roll(5);
    }

    @Test
    public void oneStrike() {
        rollStrike();
        g.roll(5);
        g.roll(3);
        rollMany(16, 0);
        assertThat(g.score(), is(26));
    }

    private void rollStrike() {
        g.roll(10);
    }

    @Test
    public void perfectGame() {
        rollMany(12, 10);
        assertThat(g.score(), is(300));
    }
}
