package ge.nick.utils;

/**
 * Abstract class Subscriber is a prototype
 * of client that have opportunities to subscribe
 * on category of electronic market to notify
 * them about new product.
 * All classes that extends it is subscribable.
 */

abstract public class Subscriber {

    protected String Name;

    public Subscriber(String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }

    public void notifyMe(Notifiable notifier){

        notifier.doNotifyUser(this);
    }

    @Override
    public String toString() {
        return "Subscriber{" +
                "Name='" + Name + '\'' +
                '}';
    }
}
