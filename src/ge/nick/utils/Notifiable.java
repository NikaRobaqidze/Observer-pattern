package ge.nick.utils;

/**
 * Functional interface to set lambda to notify method.
 * Lambda function will be called in client class side.
 * It needs to send complex notification to subscribed client.
 */

@FunctionalInterface
public interface Notifiable {

    // To set function that render complex notification to subscribed client.
    void doNotifyUser(Subscriber subscriber);
}
