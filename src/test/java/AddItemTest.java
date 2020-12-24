import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AddItemTest {

    @Test
    void TestThrownExceptionWhenWrongTitle(){
        assertThrows(
                IllegalArgumentException.class,
                () -> {
                    ShoppingCart cart = new ShoppingCart();
                    cart.addItem(null, 5, 10, Item.Type.SECOND);
                },
                "* IllegalArgumentException is not thrown when Title is null");

        assertThrows(
                IllegalArgumentException.class,
                () -> {
                    ShoppingCart cart = new ShoppingCart();
                    cart.addItem("+".repeat(33), 5, 10, Item.Type.SECOND);
                },
                "* IllegalArgumentException is not thrown when Title is longer then 32");

        assertThrows(
                IllegalArgumentException.class,
                () -> {
                    ShoppingCart cart = new ShoppingCart();
                    cart.addItem("", 5, 10, Item.Type.SECOND);
                },
                "* IllegalArgumentException is not thrown when Title is empty");
    }

    @Test
    void TestThrownExceptionWhenWrongPrice(){
        assertThrows(
                IllegalArgumentException.class,
                () -> {
                    ShoppingCart cart = new ShoppingCart();
                    cart.addItem("*", 0, 10, Item.Type.SECOND);
                },
                "* IllegalArgumentException is not thrown when Prise is not more than 0");

        assertThrows(
                IllegalArgumentException.class,
                () -> {
                    ShoppingCart cart = new ShoppingCart();
                    cart.addItem("*", 1000, 10, Item.Type.SECOND);
                },
                "* IllegalArgumentException is not thrown when Prise is not less than 1000");
    }

    @Test
    void TestThrownExceptionWhenWrongtQuantity(){
        assertThrows(
                IllegalArgumentException.class,
                () -> {
                    ShoppingCart cart = new ShoppingCart();
                    cart.addItem("*", 5, 0, Item.Type.SECOND);
                },
                "* IllegalArgumentException is not thrown when quantity is not more than 0");

        assertThrows(
                IllegalArgumentException.class,
                () -> {
                    ShoppingCart cart = new ShoppingCart();
                    cart.addItem("*", 5, 1001, Item.Type.SECOND);
                },
                "* IllegalArgumentException is not thrown when quantity is not more than 1001");
    }

    @Test
    void TestThrownExceptionWhenItemsMoreThan100(){
        assertThrows(
                IndexOutOfBoundsException.class,
                () -> {
                    ShoppingCart cart = new ShoppingCart();
                    for(int i = 0; i <= 100; i++)
                        cart.addItem("test", 5, 10, Item.Type.SECOND);
                },
                "* IndexOutOfBoundsException is not thrown when Items is more than 100");
    }

}