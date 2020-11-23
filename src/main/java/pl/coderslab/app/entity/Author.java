package pl.coderslab.app.entity;

import org.hibernate.validator.constraints.pl.PESEL;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

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
    @ManyToMany(mappedBy = "authors", cascade = CascadeType.MERGE)
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

    public void updateBooks(Set<Book> books) {
        List<Book> toDelete = this.books.stream()
                .filter(b -> !books.contains(b))
                .collect(Collectors.toList());
        toDelete.forEach(b -> b.removeAuthor(this));
        books.forEach(b -> b.addAuthor(this));
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(id, author.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
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
