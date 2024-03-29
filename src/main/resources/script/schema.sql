CREATE TABLE authors(
    id SERIAL PRIMARY KEY ,
    name varchar(300),
    gender varchar(10)
);

CREATE TABLE books (
    id SERIAL PRIMARY KEY,
    title VARCHAR(300),
    published_date DATE,
    author_id int,
    CONSTRAINT fk_books_author_id FOREIGN KEY(author_id) REFERENCES authors(id)
);
CREATE TABLE categories(
    id serial PRIMARY KEY ,
    name varchar(200)

);
 CREATE TABLE book_category(
     book_id int,
     category_id int,
     CONSTRAINT fk_book_id FOREIGN KEY (book_id) REFERENCES books(id)
                           ON DELETE CASCADE ON UPDATE CASCADE ,
     CONSTRAINT fk_category_id FOREIGN KEY (category_id) REFERENCES categories(id)
                           ON DELETE CASCADE ON UPDATE CASCADE
 );