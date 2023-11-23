package entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users", schema = "public", catalog = "backend-servlet")
@NamedQueries({
        @NamedQuery(name = "User.findByUserName", query = "SELECT u FROM User u WHERE u.username = :username"),
        @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
        @NamedQuery(name = "User.countAll", query = "SELECT COUNT(*) FROM User u"),
        @NamedQuery(name = "User.checkLogin", query = "SELECT u FROM User u WHERE u.username = :username AND u.password = :password"),
        @NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE u.email = :email"),

})
public class User implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "user_id")
    private int userId;
    @Basic
    @Column(name = "username", nullable = false, unique = true)
    private String username;
    @Basic
    @Column(name = "password", nullable = false)
    private String password;
    @Basic
    @Column(name = "role", nullable = false)
    private String role;
    @Basic
    @Column(name = "email", nullable = false)
    private String email;
    @Basic
    @Column(name = "full_name", nullable = false)
    private String fullName;
    @Basic
    @Column(name = "address")
    private String address;
    @Basic
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;
    @OneToMany(mappedBy = "infoUser", cascade = CascadeType.ALL)
    private Set<Order> orders = new HashSet<>(0);
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Cart cart;

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public Set<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }

    @OneToMany(mappedBy = "userReview", cascade = CascadeType.ALL)
    private Set<Review> reviews = new HashSet<>(0);

    public User() {
    }

    public User(int userId, String username, String password, String role, String email, String fullName, String address, String phoneNumber) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.role = role;
        this.email = email;
        this.fullName = fullName;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
