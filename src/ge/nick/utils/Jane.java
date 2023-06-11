package ge.nick.utils;

/**
 * Class Jane represent client of
 * electronic market. Which take notification
 * from market, because he subscribed on it.
 * To get this opportunity it extends Subscriber
 * that have all required methods to take notifications.
 * Jane is a formal name of client.
 */

public class Jane extends Subscriber {

    // Default constructor to initialize parent.
    public Jane() {
        super("Jane");
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
