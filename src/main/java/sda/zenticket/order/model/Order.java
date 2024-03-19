package sda.zenticket.order.model;

import java.io.Serializable;

public class Order implements Serializable {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
