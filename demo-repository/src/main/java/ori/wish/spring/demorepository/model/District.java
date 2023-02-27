package ori.wish.spring.demorepository.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class District {
    @Id
    private String postCode;
    private String name;

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
