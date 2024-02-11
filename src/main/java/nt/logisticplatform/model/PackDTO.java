package nt.logisticplatform.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PackDTO extends AbstractEntity {
    private String content;
    private BigDecimal price;
    private Long senderId;
    private Long receiverId;
    private Long employeeId;
    private Long senderOfficeId;
    private Long receiverOfficeId;
    private Boolean sent;
    private Boolean received;

    public PackDTO() {
    }

    public PackDTO(Long id) {
        super(id);
    }

    public PackDTO(Long id, LocalDate dateCreated, LocalDate dateUpdated) {
        super(id, dateCreated, dateUpdated);
    }

    public PackDTO(String content, BigDecimal price, Long senderId, Long receiverId, Long employeeId,
                   Long senderOfficeId, Long receiverOfficeId, Boolean sent, Boolean received) {
        this.content = content;
        this.price = price;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.employeeId = employeeId;
        this.senderOfficeId = senderOfficeId;
        this.receiverOfficeId = receiverOfficeId;
        this.sent = sent;
        this.received = received;
    }

    public PackDTO(Long id, String content, BigDecimal price, Long senderId, Long receiverId,
                   Long employeeId, Long senderOfficeId, Long receiverOfficeId, Boolean sent, Boolean received) {
        super(id);
        this.content = content;
        this.price = price;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.employeeId = employeeId;
        this.senderOfficeId = senderOfficeId;
        this.receiverOfficeId = receiverOfficeId;
        this.sent = sent;
        this.received = received;
    }

    public PackDTO(Long id, LocalDate dateCreated, LocalDate dateUpdated, String content, BigDecimal price,
                   Long senderId, Long receiverId, Long employeeId, Long senderOfficeId, Long receiverOfficeId,
                   Boolean sent, Boolean received) {
        super(id, dateCreated, dateUpdated);
        this.content = content;
        this.price = price;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.employeeId = employeeId;
        this.senderOfficeId = senderOfficeId;
        this.receiverOfficeId = receiverOfficeId;
        this.sent = sent;
        this.received = received;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public Long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Long receiverId) {
        this.receiverId = receiverId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getSenderOfficeId() {
        return senderOfficeId;
    }

    public void setSenderOfficeId(Long senderOfficeId) {
        this.senderOfficeId = senderOfficeId;
    }

    public Long getReceiverOfficeId() {
        return receiverOfficeId;
    }

    public void setReceiverOfficeId(Long receiverOfficeId) {
        this.receiverOfficeId = receiverOfficeId;
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
