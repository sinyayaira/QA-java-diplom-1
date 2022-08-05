package praktikum;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BurgerReceiptTest {
    public final Bun SIMPLE_BUN = new Bun("simple", 20.0f);

    public final Ingredient CHEESE_SOUSE = new Ingredient(IngredientType.SAUCE, "cheese", 15.0f);
    public final Ingredient PICKLES = new Ingredient(IngredientType.FILLING, "pickles", 10.0f);

    public final Pattern INGREDIENT_PATTERN = Pattern.compile("= (\\w+) (\\w+) =");

    @Test
    public void testWithOutIngredients() throws Exception {
        Burger burger = new Burger();
        burger.setBuns(SIMPLE_BUN);

        String recipient = burger.getReceipt();
        assertTrue(recipient.contains("==== simple ===="));

        Matcher matcher = INGREDIENT_PATTERN.matcher(recipient);
        assertEquals(0, matcher.results().count());

        assertTrue(recipient.contains("Price: 40,000000"));
    }

    @Test
    public void testWithOneIngredient() throws Exception {
        Burger burger = new Burger();
        burger.setBuns(SIMPLE_BUN);
        burger.addIngredient(CHEESE_SOUSE);

        String recipient = burger.getReceipt();
        assertTrue(recipient.contains("==== simple ===="));

        Matcher matcher = INGREDIENT_PATTERN.matcher(recipient);
        assertEquals(1, matcher.results().count());

        assertTrue(recipient.contains("Price: 55,000000"));
    }

    @Test
    public void testWithTwoIngredient() throws Exception {
        Burger burger = new Burger();
        burger.setBuns(SIMPLE_BUN);
        burger.addIngredient(CHEESE_SOUSE);
        burger.addIngredient(PICKLES);

        String recipient = burger.getReceipt();
        assertTrue(recipient.contains("==== simple ===="));


        Matcher matcher = INGREDIENT_PATTERN.matcher(recipient);
        assertEquals(2, matcher.results().count());

        assertTrue(recipient.contains("Price: 65,000000"));
    }

    @Test
    public void testWithTwoEqualsIngredient() throws Exception {
        Burger burger = new Burger();
        burger.setBuns(SIMPLE_BUN);
        burger.addIngredient(PICKLES);
        burger.addIngredient(PICKLES);

        String recipient = burger.getReceipt();
        assertTrue(recipient.contains("==== simple ===="));


        Matcher matcher = INGREDIENT_PATTERN.matcher(recipient);
        assertEquals(2, matcher.results().count());

        assertTrue(recipient.contains("Price: 60,000000"));
    }
}


