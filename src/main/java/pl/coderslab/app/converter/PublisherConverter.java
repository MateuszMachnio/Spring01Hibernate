package pl.coderslab.app.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.coderslab.app.entity.Publisher;
import pl.coderslab.app.repository.PublisherDao;

import java.lang.annotation.Annotation;

public class PublisherConverter implements Converter<String, Publisher> {

    @Autowired
    private PublisherDao publisherDao;

//    public PublisherConverter(PublisherDao publisherDao) {
//        this.publisherDao = publisherDao;
//    }


    @Override
    public Publisher convert(String s) {
        long id = Long.parseLong(s);
        return publisherDao.findById(id);
    }

}
