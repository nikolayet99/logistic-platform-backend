package nt.logisticplatform.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Bill extends AbstractEntity {
    @ManyToOne
    @JoinColumn(name = "package_id")
    private Package pack;

    private BigDecimal price;

    public Bill() {
    }

    public Bill(Package pack, BigDecimal price) {
        this.pack = pack;
        this.price = price;
    }

    public Bill(Long id, Package pack, BigDecimal price) {
        super(id);
        this.pack = pack;
        this.price = price;
    }

    public Bill(Long id, LocalDate dateCreated, LocalDate dateUpdated, Package pack, BigDecimal price) {
        super(id, dateCreated, dateUpdated);
        this.pack = pack;
        this.price = price;
    }

    public Package getPack() {
        return pack;
    }

    public void setPack(Package pack) {
        this.pack = pack;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
