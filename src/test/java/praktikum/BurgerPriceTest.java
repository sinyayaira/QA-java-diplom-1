package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class BurgerPriceTest {
    public static final Bun SIMPLE_BUN = new Bun("simple", 20.0f);
    public static final Bun MEGA_BUN = new Bun("mega", 50.0f);
    public static final Bun SUPER_BUN = new Bun("super", 80.0f);

    public static final Ingredient CHEESE_SOUSE = new Ingredient(SAUCE, "cheese", 10.0f);
    public static final Ingredient SPICY_SOUSE = new Ingredient(SAUCE, "spicy", 30.0f);
    public static final Ingredient PICKLES = new Ingredient(FILLING, "pickles", 10.0f);
    public static final Ingredient TOMATO = new Ingredient(FILLING, "tomato", 10.0f);

    @Test
    public void test() throws Exception {
        Burger burger = new Burger();
        burger.setBuns(bun);
        for (Ingredient ingredient : ingredients) {
            burger.addIngredient(ingredient);
        }
        assertEquals(expectedPrice, burger.getPrice(), 0.01F);
    }

    @Parameterized.Parameter(0)
    public Bun bun;

    @Parameterized.Parameter(1)
    public List<Ingredient> ingredients;

    @Parameterized.Parameter(2)
    public Float expectedPrice;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {SIMPLE_BUN, new ArrayList(), 40.0f  },
                {MEGA_BUN, new ArrayList(), 100.0f  },
                {SUPER_BUN, List.of(CHEESE_SOUSE), 170.0f  },
                {MEGA_BUN, List.of(PICKLES), 110.0f  },
                {SUPER_BUN, List.of(SPICY_SOUSE), 190.0f  },
                {SIMPLE_BUN, List.of(TOMATO), 50.0f  },
        });
    }
}
