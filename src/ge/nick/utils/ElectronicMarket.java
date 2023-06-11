package ge.nick.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class represent electronic market that have categories.
 * User can subscribe to each one and get notifications when
 * new product will be added with this category.
 * All methods have described to manage processes in market.*/

public class ElectronicMarket {

    // List of string name of categories.
    private final List<String> categories;

    // Map to save subscribers to each category.
    private final Map<String, List<Subscriber>> categoriesAndSubs;

    // Default constructor to initialize list and map.
    public ElectronicMarket() {

        this.categories = new ArrayList<>();
        this.categoriesAndSubs = new HashMap<>();
    }

    // To get categories.
    public List<String> getCategories() {
        return categories;
    }

    // To get subscribers of each category.
    public Map<String, List<Subscriber>> getCategoriesAndSubs() {
        return categoriesAndSubs;
    }

    // To add create new category.
    public void addNewCategory(String categoryName){

        // Check if category is the same name already exists.
        if(this.categories.contains(categoryName)){

            System.out.println("Category '" + categoryName + "' already exists.");
            return;
        }

        // Add new category.
        this.categories.add(categoryName);

        // Put category to map and initialize list to save subscribers.
        this.categoriesAndSubs.put(categoryName, new ArrayList<>());

        System.out.println("Category '" + categoryName + "' successfully added!");
    }

    // Method for client to subscribe on category.
    public void subscribe(String categoryName, Subscriber subscriber){

        // Check if category exists.
        if(!this.categories.contains(categoryName)){

            System.out.println("Category: '" + categoryName + "' not exist.");
            return;
        }

        // Check if client already subscribed on category.
        if(this.categoriesAndSubs.get(categoryName).contains(subscriber)){

            System.out.println("User '" + subscriber.getName() + "' have already subscribed.");
            return;
        }

        // Add new subscriber to subscribers map value.
        this.categoriesAndSubs.get(categoryName).add(subscriber);

        System.out.println("New subscriber: " + subscriber.getName());
    }

    // To add new product with specific category. Notify client about it.
    public void addProductTo(String categoryName){

        // Check if category exists.
        if(!this.categories.contains(categoryName)){

            System.out.println("Category: '" + categoryName + "' not exist.");
            return;
        }

        // Notify client about new product.
        this.sendNotification(categoryName, (Subscriber subscriber) -> {

            System.out.println(
                    "Look! " + subscriber.getName() + " don't miss new products in '"
                            + categoryName + "' Category:");

            for(int i = 1; i <= 3; i ++){

                System.out.println("- New product " + i);
            }

            System.out.println("Special for you!");
        });
    }

    // To delete specific category. Notify client about it.
    public void deleteCategory(String categoryName){

        // Check if category exists.
        if(!this.categories.contains(categoryName)){

            System.out.println("Category: '" + categoryName + "' not exist.");
            return;
        }

        // Notify clients that category has deleted.
        this.sendNotification(

                categoryName,

                (Subscriber subscriber) -> System.out.println(
                        "Dear, " + subscriber.getName() + " category '"
                                + categoryName + "' has deleted. :("
                )
        );
    }

    // Method for subscribers to notify them.
    protected void sendNotification(String categoryName, Notifiable renderNotify){

        // Check if category exists and somebody subscribed.
        if(this.categories.contains(categoryName) &&
            this.categoriesAndSubs.get(categoryName).size() > 0){

            // Get all subscribed client class to notify them.
            for(Subscriber subscriber : this.categoriesAndSubs.get(categoryName)){

                // Call notify method and set lambda function to
                // call it in client class.
                subscriber.notifyMe(renderNotify);
            }
        }
    }

    @Override
    public String toString() {
        return "ElectronicMarket{" +
                "categories=" + categories +
                ", categoriesAndSubs=" + categoriesAndSubs +
                '}';
    }
}