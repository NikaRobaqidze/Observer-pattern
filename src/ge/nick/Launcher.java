package ge.nick;

import ge.nick.utils.Bobby;
import ge.nick.utils.ElectronicMarket;
import ge.nick.utils.Jane;
import ge.nick.utils.Timmy;

public class Launcher {
    public static void main(String[] args) {

        ElectronicMarket electronicMarket = new ElectronicMarket();

        Bobby bobby = new Bobby();
        Timmy timmy = new Timmy();
        Jane jane = new Jane();

        // Nothing

        electronicMarket.addNewCategory("semiconductors");
        electronicMarket.addProductTo("semiconductors");

        // Only for Bobby
        electronicMarket.subscribe("semiconductors", bobby);
        electronicMarket.addProductTo("semiconductors");

        electronicMarket.addNewCategory("conductors");
        electronicMarket.addProductTo("conductors");

        electronicMarket.subscribe("conductors", timmy);
        electronicMarket.subscribe("conductors", jane);

        electronicMarket.addProductTo("conductors");

        electronicMarket.deleteCategory("conductors");
    }
}