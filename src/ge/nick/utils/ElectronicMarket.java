package ge.nick.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ElectronicMarket {

    private List<String> categories;
    private Map<String, List<Subscriber>> categoriesAndSubs;

    public ElectronicMarket() {

        this.categories = new ArrayList<>();
        this.categoriesAndSubs = new HashMap<>();
    }

    public List<String> getCategories() {
        return categories;
    }

    public Map<String, List<Subscriber>> getCategoriesAndSubs() {
        return categoriesAndSubs;
    }

    public void addNewCategory(String categoryName){

        if(this.categories.contains(categoryName)){

            System.out.println("Category '" + categoryName + "' already exists.");
            return;
        }

        this.categoriesAndSubs.put(categoryName, new ArrayList<>());
        this.categories.add(categoryName);

        System.out.println("Category '" + categoryName + "' successfully added!");
    }

    public void subscribe(String categoryName, Subscriber subscriber){

        if(!this.categories.contains(categoryName)){

            System.out.println("Category: '" + categoryName + "' not exist.");
            return;
        }

        if(this.categoriesAndSubs.get(categoryName).contains(subscriber)){

            System.out.println("User '" + subscriber.getName() + "' have already subscribed.");
            return;
        }

        this.categoriesAndSubs.get(categoryName).add(subscriber);
        System.out.println("New subscriber: " + subscriber.getName());
    }

    public void addProductTo(String categoryName){

        if(!this.categories.contains(categoryName)){

            System.out.println("Category: '" + categoryName + "' not exist.");
            return;
        }

        this.sendNotification(categoryName, (Subscriber subscriber) -> {

            System.out.println("Look! " + subscriber.getName() + " don't miss new products in '" + categoryName + "' Category:");

            for(int i = 1; i <= 3; i ++){

                System.out.println("- New product " + i);
            }

            System.out.println("Special for you!");
        });
    }

    public void deleteCategory(String categoryName){

        if(!this.categories.contains(categoryName)){

            System.out.println("Category: '" + categoryName + "' not exist.");
            return;
        }

        this.sendNotification(categoryName, (Subscriber subscriber) -> {

            System.out.println("Dear, " + subscriber.getName() + " category '" + categoryName + "' has deleted. :(");
        });
    }

    protected void sendNotification(String categoryName, Notifity renderNotif){

        if(this.categories.contains(categoryName) &&
            this.categoriesAndSubs.get(categoryName).size() > 0){

            for(Subscriber subscriber : this.categoriesAndSubs.get(categoryName)){

                subscriber.notifyMe(renderNotif);
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
