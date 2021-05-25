package org.jaravan.leorder;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity(name = "le_order")
public class Order implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 8764655849145653384L;

    /**
     * Unique Order ID.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    /**
     * Unique Product ID.
     */
    @Column(name = "product_id")
    @NotNull
    private long productId;

    /**
     * Unique Customer ID.
     */
    @Column(name = "customer_id")
    @NotNull
    private long customerId;

    /**
     * Status of Order.
     */
    @Column(name = "o_status")
    @NotNull
    private OrderStatus status;

    /**
     *
     */
    public Order() {
        super();
    }

    /**
     * @param product
     * @param customer
     * @param orderStatus
     */
    public Order(final long product,
            final long customer,
            final OrderStatus orderStatus) {
        super();
        this.productId = product;
        this.customerId = customer;
        this.status = orderStatus;
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param orderId the id to set
     */
    public void setId(final long orderId) {
        this.id = orderId;
    }

    /**
     * @return the productId
     */
    public long getProductId() {
        return productId;
    }

    /**
     * @param product the product to set
     */
    public void setProductId(final long product) {
        this.productId = product;
    }

    /**
     * @return the customerId
     */
    public long getCustomerId() {
        return customerId;
    }

    /**
     * @param customer the customerId to set
     */
    public void setCustomerId(final long customer) {
        this.customerId = customer;
    }

    /**
     * @return the status
     */
    public OrderStatus getStatus() {
        return status;
    }

    /**
     * @param orderStatus the status to set
     */
    public void setStatus(final OrderStatus orderStatus) {
        this.status = orderStatus;
    }
}
