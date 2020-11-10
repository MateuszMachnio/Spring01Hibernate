package pl.coderslab.app.entity;

import org.hibernate.Hibernate;
import org.hibernate.validator.constraints.pl.PESEL;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @PESEL
//    @NotNull
    private String pesel;

    @Email
//    @NotNull
    private String email;

    @NotEmpty
    @ManyToMany(mappedBy = "authors")
//    @ManyToMany
//    @JoinTable(name = "book_authors", joinColumns = @JoinColumn(name = "author_id"), inverseJoinColumns = @JoinColumn(name = "book_id"))
    private Set<Book> books = new HashSet<>();

    public void removeBooks() {
        books.forEach(book -> book.getAuthors().remove(this));
        books.clear();
    }

    public Author saveBooks(Set<Book> newBooks) {
        books.addAll(newBooks);
        books.forEach(book -> book.getAuthors().add(this));
        return this;
    }

//    public void addBook(Book book) {
//        books.add(book);
//        book.getAuthors().add(this);
//    }
//
//    public void removeBook(Book book) {
//        books.remove(book);
//        book.getAuthors().remove(this);
//    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
