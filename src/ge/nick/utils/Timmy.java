package ge.nick.utils;

/**
 * Class Timmy represent client of
 * electronic market. Which take notification
 * from market, because he subscribed on it.
 * To get this opportunity it extends Subscriber
 * that have all required methods to take notifications.
 * Timmy is a formal name of client.
 */

public class Timmy extends Subscriber {

    // Default constructor to initialize parent.
    public Timmy() {
        super("Timmy");
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void notifyMe(Notifiable notifier) {
        super.notifyMe(notifier);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
