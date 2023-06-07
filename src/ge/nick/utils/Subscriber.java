package ge.nick.utils;

abstract public class Subscriber {
    protected String Name;

    public Subscriber(String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }

    public void notifyMe(Notifity notifier){

        notifier.doNotifyUser(this);
    }

    @Override
    public String toString() {
        return "Subscriber{" +
                "Name='" + Name + '\'' +
                '}';
    }
}
