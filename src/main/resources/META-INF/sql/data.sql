
INSERT INTO test.authors (firstName, lastName) VALUES ('Javaman', 'curious');
INSERT INTO test.authors (firstName, lastName) VALUES ('Javaman2', 'ciekawy');
INSERT INTO test.authors (firstName, lastName) VALUES ('Mateus', 'Machni');

INSERT INTO test.categories (name) VALUES ('Category 1');
INSERT INTO test.categories (name) VALUES ('Category 2');
INSERT INTO test.categories (name) VALUES ('Category 3');
INSERT INTO test.categories (name) VALUES ('Category 4');


INSERT INTO test.publishers (name) VALUES ('Some publisher');
INSERT INTO test.publishers (name) VALUES ('Publisher');
INSERT INTO test.publishers (name) VALUES ('Marchewa');
INSERT INTO test.publishers (name) VALUES ('Śniadanko');

INSERT INTO test.books (description, rating, title, publisher_id, pages, category_id) VALUES ('Opis książki2', 9, 'Thinking in Java2', 1, 2, 1);
INSERT INTO test.books (description, rating, title, publisher_id, pages, category_id) VALUES ('qqqqqqqqq', 10, 'np', 2, 2, 2);
INSERT INTO test.books (description, rating, title, publisher_id, pages, category_id) VALUES ('23', 1, 'hobbit', 1, 2, 3);
INSERT INTO test.books (description, rating, title, publisher_id, pages, category_id) VALUES ('qqqq', 2, 'hobbit itd.', 2, 2, 4);
INSERT INTO test.books (description, rating, title, publisher_id, pages, category_id) VALUES ('qqqqqqqqqqqqqqqqqqqq', 1, 'tak', 2, 2, 1);

INSERT INTO test.book_authors (book_id, author_id) VALUES (4, 1);
INSERT INTO test.book_authors (book_id, author_id) VALUES (5, 1);
INSERT INTO test.book_authors (book_id, author_id) VALUES (1, 3);
INSERT INTO test.book_authors (book_id, author_id) VALUES (2, 3);
INSERT INTO test.book_authors (book_id, author_id) VALUES (3, 3);
INSERT INTO test.book_authors (book_id, author_id) VALUES (4, 2);
INSERT INTO test.book_authors (book_id, author_id) VALUES (3, 2);
INSERT INTO test.book_authors (book_id, author_id) VALUES (2, 1);
INSERT INTO test.book_authors (book_id, author_id) VALUES (1, 2);
INSERT INTO test.book_authors (book_id, author_id) VALUES (5, 2);








INSERT INTO test.people (email, login, password) VALUES ('machniom93@gmail.com', 'Mateusz', '1qaz');
INSERT INTO test.people (email, login, password) VALUES ('machniom93@gmail.com', 'Mateusz', '1qaz');


INSERT INTO test.persons_details (city, firstName, lastName, street, streetNumber, person_id) VALUES ('Miasteczko', 'Mati', 'Machnio', 'tetmajera', 5, 1);


