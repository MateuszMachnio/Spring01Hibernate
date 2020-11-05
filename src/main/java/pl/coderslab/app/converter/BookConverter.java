package pl.coderslab.app.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.app.entity.Book;
import pl.coderslab.app.repository.BookDao;

public class BookConverter implements Converter<String, Book> {

    @Autowired
    private BookDao bookDao;

    @Override
    public Book convert(String id) {
        return bookDao.findById(Long.parseLong(id));
    }

}
