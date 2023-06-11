/**
 * @Author: Nika Robaqidze
 * @Email: nika42568@gmail.com

 * Scenario:
 * Initialize electronic market. Have three client.
 * At first market do not have subscribers and
 * when it adds product nothing happened.
 * Then client by one client subscribed on it.
 * As result market notified them about new product.
 * At the end market delete category and subscribers got
 * notification about it. All notifications will be printed on screen.
 */

package ge.nick;

import ge.nick.utils.Bobby;
import ge.nick.utils.ElectronicMarket;
import ge.nick.utils.Jane;
import ge.nick.utils.Timmy;

public class Launcher {
    public static void main(String[] args) {

        // Initialize electronic market.
        ElectronicMarket electronicMarket = new ElectronicMarket();

        // Initialize clients.
        Bobby bobby = new Bobby();
        Timmy timmy = new Timmy();
        Jane jane = new Jane();

        // Create category and add product with it.
        electronicMarket.addNewCategory("semiconductors");
        electronicMarket.addProductTo("semiconductors");

        // Client Bobby subscribed on added category.
        electronicMarket.subscribe("semiconductors", bobby);

        // Add new product.
        electronicMarket.addProductTo("semiconductors");

        // Create category and add product with it.
        electronicMarket.addNewCategory("conductors");
        electronicMarket.addProductTo("conductors");

        // Clients Timmy and Jane also subscribed on other categories.
        electronicMarket.subscribe("conductors", timmy);
        electronicMarket.subscribe("conductors", jane);

        // Add new product.
        electronicMarket.addProductTo("conductors");

        // Delete category.
        electronicMarket.deleteCategory("conductors");
    }
}