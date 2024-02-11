package nt.logisticplatform.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Package extends AbstractEntity {
    @ManyToOne
    @JoinColumn(name = "sender_id")
    private Person sender;

    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private Person receiver;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Person employee;

    @ManyToOne
    @JoinColumn(name = "sender_office_id")
    private Office senderOffice;

    @ManyToOne
    @JoinColumn(name = "receiver_office_id")
    private Office receiverOffice;

    private String content;
    private BigDecimal price;

    @Column(columnDefinition = "boolean default false")
    private Boolean sent;

    @Column(columnDefinition = "boolean default false")
    private Boolean received;

    public Package() {
    }

    public Package(Person sender, Person receiver, Person employee, Office senderOffice, Office receiverOffice,
                   String content, BigDecimal price, Boolean sent, Boolean received) {
        this.sender = sender;
        this.receiver = receiver;
        this.employee = employee;
        this.senderOffice = senderOffice;
        this.receiverOffice = receiverOffice;
        this.content = content;
        this.price = price;
        this.sent = sent;
        this.received = received;
    }

    public Package(Long id, Person sender, Person receiver, Person employee, Office senderOffice, Office receiverOffice,
                   String content, BigDecimal price, Boolean sent, Boolean received) {
        super(id);
        this.sender = sender;
        this.receiver = receiver;
        this.employee = employee;
        this.senderOffice = senderOffice;
        this.receiverOffice = receiverOffice;
        this.content = content;
        this.price = price;
        this.sent = sent;
        this.received = received;
    }

    public Package(Long id, LocalDate dateCreated, LocalDate dateUpdated, Person sender, Person receiver, Person employee, Office senderOffice,
                   Office receiverOffice, String content, BigDecimal price, Boolean sent, Boolean received) {
        super(id, dateCreated, dateUpdated);
        this.sender = sender;
        this.receiver = receiver;
        this.employee = employee;
        this.senderOffice = senderOffice;
        this.receiverOffice = receiverOffice;
        this.content = content;
        this.price = price;
        this.sent = sent;
        this.received = received;
    }

    public Person getSender() {
        return sender;
    }

    public void setSender(Person sender) {
        this.sender = sender;
    }

    public Person getReceiver() {
        return receiver;
    }

    public void setReceiver(Person receiver) {
        this.receiver = receiver;
    }

    public Person getEmployee() {
        return employee;
    }

    public void setEmployee(Person employee) {
        this.employee = employee;
    }

    public Office getSenderOffice() {
        return senderOffice;
    }

    public void setSenderOffice(Office senderOffice) {
        this.senderOffice = senderOffice;
    }

    public Office getReceiverOffice() {
        return receiverOffice;
    }

    public void setReceiverOffice(Office receiverOffice) {
        this.receiverOffice = receiverOffice;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getSent() {
        return sent;
    }

    public void setSent(Boolean sent) {
        this.sent = sent;
    }

    public Boolean getReceived() {
        return received;
    }

    public void setReceived(Boolean received) {
        this.received = received;
    }
}
