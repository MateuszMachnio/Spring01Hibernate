package pl.coderslab.app.entity;

import javax.persistence.*;

@Entity
@Table(name = "persons_details")
public class PersonDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private int streetNumber;

    private String street;

    private String city;

    @OneToOne(mappedBy = "personDetails")
    private Person person;
}
