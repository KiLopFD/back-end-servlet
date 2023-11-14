    package entity;

    import jakarta.persistence.*;

    import java.io.Serializable;
    import java.sql.Timestamp;
    import java.util.*;

    @Entity
    @Table(name = "order", schema = "public", catalog = "backend-servlet")
    @NamedQueries({
            @NamedQuery(name="Order.findAll", query = "SELECT o FROM Order o"),
            @NamedQuery(name="Order.countAll", query = "SELECT COUNT(*) FROM Order o"),
            @NamedQuery(
                    name = "Order.findByIdAndUser",
                    query = "SELECT o FROM Order o WHERE o.orderId = :orderId AND o.infoUser = :user"
            )
    })
    public class Order implements Serializable {
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Id
        @Column(name = "order_id")
        private int orderId;

        @Basic
        @Column(name = "order_date", nullable = false)
        private Date orderDate;
        @Basic
        @Column(name = "status_payment", nullable = false)
        private String statusPayment;
        @ManyToOne
        @JoinColumn(name = "user_id", nullable = false)
        private User infoUser;

        @OneToMany(cascade = CascadeType.PERSIST)
        @JoinColumn(name = "order_id")
        private Set<Orderdetail> listOrderDetails = new HashSet<>(0);

        public Set<Orderdetail> getListOrderDetails() {
            return listOrderDetails;
        }

        public void setListOrderDetails(Set<Orderdetail> listOrderDetails) {
            this.listOrderDetails = listOrderDetails;
        }


        public Order() {
        }

        public Order(int orderId, Timestamp orderDate, String statusPayment, User infoUser, List<Order> listOrderDetails) {
            this.orderId = orderId;
            this.orderDate = orderDate;
            this.statusPayment = statusPayment;
            this.infoUser = infoUser;
            //        this.listOrderDetails = listOrderDetails;
        }

        public int getOrderId() {
            return orderId;
        }

        public void setOrderId(int orderId) {
            this.orderId = orderId;
        }

        public Date getOrderDate() {
            return orderDate;
        }

        public void setOrderDate(Date orderDate) {
            this.orderDate = orderDate;
        }

        public String getStatusPayment() {
            return statusPayment;
        }

        public void setStatusPayment(String statusPayment) {
            this.statusPayment = statusPayment;
        }

        public User getInfoUser() {
            return infoUser;
        }

        public void setInfoUser(User infoUser) {
            this.infoUser = infoUser;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Order)) return false;
            Order order = (Order) o;
            return getOrderId() == order.getOrderId();
        }

        @Override
        public int hashCode() {
            return Objects.hash(getOrderId());
        }
    }