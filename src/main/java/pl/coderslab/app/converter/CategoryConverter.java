package pl.coderslab.app.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.app.entity.Category;
import pl.coderslab.app.jpaRepository.CategoryRepository;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

public class CategoryConverter implements Converter<String, Category> {

    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public Category convert(String s) {
        if (Long.parseLong(s) <= 0) {
            return null;
        }
//        if (!s.matches("\\d+")) {
//            throw new NumberFormatException("Proszę wybrać kategorię.");
//        }
        return categoryRepository.findById(Long.parseLong(s)).orElseThrow(() -> new EntityNotFoundException("Category not found. Id: " + s));
    }
}
