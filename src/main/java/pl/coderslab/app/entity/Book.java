package pl.coderslab.app.entity;

import org.hibernate.Hibernate;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 5)
    @NotNull
    private String title;

    @Range(min = 1, max = 10)
    private int rating;

    @Size(max = 600)
    @NotBlank
    private String description;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    @NotEmpty
    @ManyToMany
    @JoinTable(name = "book_authors", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authors = new HashSet<>();

    @Min(2)
    private int pages;

    @NotNull(message = "Proszę wybrać kategorię")
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

//    public void addAuthor(Author author) {
//        author.getBooks().add(this);
//        this.authors.add(author);
//    }

//    public void removeAuthor(Author author) {
//        author.getBooks().remove(this);
//        this.authors.remove(author);
//    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", rating=" + rating +
                ", description='" + description + '\'' +
                ", publisher=" + publisher +
                '}';
    }
}
