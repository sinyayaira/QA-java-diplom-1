package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BunTest {
    @Test
    public void checkGetName() {
        String expectedName = "black bun";
        Bun bun = new Bun(expectedName, 100.0f);
        String actualName = bun.getName();
        assertEquals (expectedName,actualName);
    }

    @Test
    public void checkGetPrice() {
        float expectedPrise = 100.0f;
        Bun bun = new Bun("black bun", expectedPrise);
        float actualPrice = bun.getPrice();
        assertEquals(expectedPrise,actualPrice, 0.01);
    }
}
