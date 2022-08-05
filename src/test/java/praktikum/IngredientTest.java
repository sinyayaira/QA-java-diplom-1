package praktikum;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class IngredientTest {
    @Test
    public void checkGetPrice() {
        float expectedPrice = 100.0F;
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE,"hot sauce", expectedPrice);
        float actualPrice = ingredient.getPrice();
        assertEquals(expectedPrice, actualPrice,0.01);
    }

    @Test
    public void checkGetName() {
        String expectedName = "hot sauce";
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, expectedName, 100.0f);
        String actualName = ingredient.getName();
        assertEquals(expectedName, actualName);
    }

    @Test
    public void checkGetType() {
        IngredientType expectedType = IngredientType.SAUCE;
        Ingredient ingredient = new Ingredient(expectedType, "hot sauce", 100.0f);
        IngredientType actualType = ingredient.getType();
        assertEquals(expectedType,actualType);
    }

}
