import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class DiscountTest {

    private static Stream<Arguments> ItemsTestStream() {
        return Stream.of(
                arguments(new Item("*", 100, Item.Type.REGULAR,  5), 0),
                arguments(new Item("*", 100, Item.Type.SECOND,   5), 50),
                arguments(new Item("*", 100, Item.Type.DISCOUNT, 5), 10),
                arguments(new Item("*", 100, Item.Type.DISCOUNT, 70),50),
                arguments(new Item("*", 5,   Item.Type.SALE,     5), 80));
    }

    @ParameterizedTest
    @MethodSource("ItemsTestStream")
    void calculateDiscountTest(Item item, int value) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method calculateDiscount = ShoppingCart.class.getDeclaredMethod("calculateDiscount", Item.class);
        calculateDiscount.setAccessible(true);
        ShoppingCart shoppingCart = new ShoppingCart();
        assertEquals(value, calculateDiscount.invoke(shoppingCart, item));
    }

}