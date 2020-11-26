package kr.co.fastcompus.eatgo.domain;


import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private Long id;
    private final String name;
    private String address;
    private List<MenuItem> menuItems = new ArrayList<>();


    public Restaurant(Long id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    public String getInformation() {
        return name + " in " + address;
    }


    public List<MenuItem> getMenuItems() {
        return this.menuItems;
    }

    public void addMenuItem(MenuItem menuItem) {
        menuItems.add(menuItem);
    }


    public void setMenuItems(List<MenuItem> menuItems) {
        for (MenuItem menuItem: menuItems
             ) {
            this.menuItems.add(menuItem);

        }
    }
}
