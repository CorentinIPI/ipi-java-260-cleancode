import org.junit.Test;

import static junit.framework.TestCase.assertEquals;


public class BowlingGameTest {

    BowlingGame game = new BowlingGame();

    @Test
    public void queDesGoutieresDonne0Points() {
        rollMany(20, 0);
        assertEquals(0, game.score());
    }

    @Test
    public void uneSeuleQuille(){
        game.roll(1);
        rollMany(19, 0);
        assertEquals(1, game.score());
    }

    @Test
    public void bonusDuSpare(){
        game.roll(8);
        game.roll(2);
        game.roll(1);
        rollMany(17, 0);
        assertEquals(12, game.score());
    }
    @Test
    public void bonusStrike() {
    	game.roll(10);
    	game.roll(8);
    	game.roll(1);
    	rollMany(17,0);
    	assertEquals(28,game.score());
    }
    
    @Test
    public void bonusDoubleStrike() {
    	game.roll(10);
    	game.roll(10);
    	game.roll(8);
    	game.roll(1);
    	rollMany(14,0);
    	assertEquals(56,game.score());
    }
    
    @Test
    public void bonusDoubleSpare() {
    	game.roll(8);
    	game.roll(2);
    	game.roll(8);
    	game.roll(2);
    	game.roll(1);
    	rollMany(14,0);
    	assertEquals(30,game.score());
    }
    
    @Test
    public void StrikeSuiviSpare() {
    	game.roll(10);
    	game.roll(8);
    	game.roll(2);
    	game.roll(1);
    	rollMany(15,0);
    	assertEquals(32,game.score());
    }
    
    @Test
    public void SpareSuiviStrike() {
    	game.roll(8);
    	game.roll(2);
    	game.roll(10);
    	game.roll(1);
    	game.roll(1);
    	rollMany(14,0);
    	assertEquals(34,game.score());
    }
    @Test
    public void FullStrike() {
    	rollMany(12,10);
    	assertEquals(300,game.score());
    }

    @Test
    public void PartieUnStrikeFin() {
    	rollMany(18,0);
    	game.roll(10);
    	game.roll(10);
    	game.roll(8);
    	assertEquals(28,game.score());
    }
    
    @Test
    public void PartieSansStrikeFin() {
    	rollMany(18,0);
    	game.roll(8);
    	game.roll(1);
    	assertEquals(9,game.score());
    }
    
    @Test
    public void PartieFinStrikeSuiviSpare() {
    	rollMany(18,0);
    	game.roll(10);
    	game.roll(8);
    	game.roll(2);
    	assertEquals(20,game.score());
    }
    
    @Test
    public void PartieFinTripleStrike() {
    	rollMany(18,0);
    	game.roll(10);
    	game.roll(10);
    	game.roll(10);
    	assertEquals(30,game.score());
    }
    private void rollMany(int numberRolls, int numberPins) {
        for (int i = 0; i < numberRolls; i++) {
            game.roll(numberPins);
        }
    }
}