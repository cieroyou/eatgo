package kr.co.fastcompus.eatgo.domain;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Restaurant {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String address;

//    이값은 db에 저장하려는 용도가 아니기 때문에 Transient 를 써준다.
    @Transient
    private List<MenuItem> menuItems = new ArrayList<>();


    public Restaurant(){

    }
    public Restaurant(String name, String address) {
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
