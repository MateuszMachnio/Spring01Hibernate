package pl.coderslab.app.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.app.entity.Author;
import pl.coderslab.app.repository.AuthorDao;

public class AuthorConverter implements Converter<String, Author> {

    @Autowired
    private AuthorDao authorDao;

    @Override
    public Author convert(String id) {
        return authorDao.findById(Long.parseLong(id));
    }
}
