CREATE TABLE Author (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        firstname VARCHAR(255),
                        lastname VARCHAR(255),
                        image VARCHAR(255)
);

CREATE TABLE Language (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          language VARCHAR(255)
);

CREATE TABLE Genre (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       genre VARCHAR(255)
);

CREATE TABLE Customer (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          userName VARCHAR(255),
                          password VARCHAR(255),
                          image VARCHAR(500)
);

CREATE TABLE Book (
                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                      title VARCHAR(255) NOT NULL UNIQUE,
                      page INT,
                      price DOUBLE,
                      image VARCHAR(255),
                      author_id INT NOT NULL,
                      language_id INT NOT NULL,
                      FOREIGN KEY (author_id) REFERENCES Author(id),
                      FOREIGN KEY (language_id) REFERENCES Language(id)
);

CREATE TABLE app_user (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          username VARCHAR(255) NOT NULL,
                          password VARCHAR(255) NOT NULL
);

CREATE TABLE refresh_token2 (
                                id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                user_id BIGINT NOT NULL,
                                token VARCHAR(255) NOT NULL UNIQUE,
                                expiry_date TIMESTAMP NOT NULL,
                                FOREIGN KEY (user_id) REFERENCES app_user(id)
);

CREATE TABLE book_genre (
                            book_id BIGINT,
                            genre_id INT,
                            PRIMARY KEY (book_id, genre_id),
                            FOREIGN KEY (book_id) REFERENCES Book(id),
                            FOREIGN KEY (genre_id) REFERENCES Genre(id)
);

CREATE TABLE book_customer (
                               book_id BIGINT,
                               customer_id BIGINT,
                               PRIMARY KEY (book_id, customer_id),
                               FOREIGN KEY (book_id) REFERENCES Book(id),
                               FOREIGN KEY (customer_id) REFERENCES Customer(id)
);


-- Insert data into Author table
-- Author tablosuna veri ekleme
INSERT INTO Author (firstname, lastname, image) VALUES
                                                    ('George', 'Orwell', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRgioi6Sl_7AdbapJfTzCfP7m7ZGPgm2JTYsw&s'),
                                                    ('J.K.', 'Rowling', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSQiX0NdMrzEAu8TtR8QljDshdprso61u5ntg&s'),
                                                    ('Mark', 'Twain', 'https://upload.wikimedia.org/wikipedia/commons/thumb/0/0c/Mark_Twain_by_AF_Bradley.jpg/640px-Mark_Twain_by_AF_Bradley.jpg'),
                                                    ('Agatha', 'Christie', 'https://img.kitapyurdu.com/v1/getImage/fn:1176463/wi:200/wh:6890d88d7'),

                                                    ('Leo', 'Tolstoy', 'https://cdn.kobo.com/book-images/62b12831-e29d-490a-9b93-b31ec0009170/1200/1200/False/leo-tolstoy-collection.jpg'),
                                                    ('Virginia', 'Woolf', 'https://i.pinimg.com/736x/85/9b/04/859b0480f93aa78f973d87af4c0b67cb.jpg'),
                                                    ('Ernest', 'Hemingway', 'https://iyikigormusum.com/uploads/fcf36947892a6b77cc4a5ed0e69132d8.jpeg'),
                                                    ('Fyodor', 'Dostoevsky', 'https://1k-cdn.com/resimler/yazarlar/73622_hASgt_1527370965.jpg'),
                                                    ('Franz', 'Kafka', 'https://www.yapikrediyayinlari.com.tr/dosyalar/2019/08/fkafka.jpg'),
                                                    ('Charles', 'Dickens', 'https://i.natgeofe.com/n/88c6025f-a20d-4127-9037-a657223b15aa/87333_square.jpg');


-- Insert data into Language table
INSERT INTO Language (language) VALUES
                                    ('English'),
                                    ('French'),
                                    ('Spanish');

-- Insert data into Genre table
INSERT INTO Genre (genre) VALUES
                              ('Fiction'),
                              ('Non-Fiction'),
                              ('Science Fiction'),
                              ('Fantasy');

-- Insert data into Customer table
INSERT INTO Customer (userName, password, image) VALUES
                                                     ('johndoe', 'password123', 'https://media.licdn.com/dms/image/v2/D4D22AQG0HJMDRNLtKQ/feedshare-shrink_800/feedshare-shrink_800/0/1675098254619?e=2147483647&v=beta&t=4LEh7WGBwhvJ-IF2Gk4SURN98lAoF1Gttu_6tOOZoIM'),
                                                     ('Musa Halil Ecer', 'mhe10', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQBykn8MFcy9X2s5ZnmSmpF40qLxIpVy0P76g&s'),
                                                     ('Emir Petek', 'emir10', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT6bXYdCoAr1PnZ-STgOcGhPjhIWNqoScIBiA&s');

-- Insert data into Book table
INSERT INTO Book (title, page, price, image, author_id, language_id) VALUES
                                                                         ('The Great Adventure', 320, 19.99, 'https://m.media-amazon.com/images/M/MV5BMTgzNDU5MjgxNF5BMl5BanBnXkFtZTgwOTM4MjkwMzE@._V1_.jpg', 1, 1),
                                                                         ('Mystery of the Lost City', 250, 14.99, 'https://m.media-amazon.com/images/I/817ig1yzoLL._AC_UF1000,1000_QL80_.jpg', 2, 2),
                                                                         ('Space Odyssey', 400, 25.99, 'https://m.media-amazon.com/images/I/71WoWlyQKtL._AC_UF1000,1000_QL80_.jpg', 3, 3);




-- Insert data into book_genre table
INSERT INTO book_genre (book_id, genre_id) VALUES
                                               (1, 1), -- The Great Adventure - Fiction
                                               (2, 1), -- Mystery of the Lost City - Fiction
                                               (2, 2), -- Mystery of the Lost City - Non-Fiction
                                               (3, 3), -- Space Odyssey - Science Fiction
                                               (3, 4); -- Space Odyssey - Fantasy

-- Insert data into book_customer table
INSERT INTO book_customer (book_id, customer_id) VALUES
                                                     (1, 1), -- The Great Adventure - Purchased by johndoe
                                                     (1, 2), -- The Great Adventure - Purchased by janedoe
                                                     (2, 3), -- Mystery of the Lost City - Purchased by emilyj
                                                     (3, 1); -- Space Odyssey - Purchased by johndoe


