package com.provaJava.androids;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AndroidService {
    @Autowired //Lets the framework know that it is needed to instance for us
    private AndroidRepository androidRepository;

    //Write database access methods
    public List<Android> allAndroids() {
        return androidRepository.findAll();
    }

    //Optional lets java know that there may be no id, so it returns null
    public Optional<Android> getAndroidById(String imdbId) {
        return androidRepository.findAndroidByImdbId(imdbId);
    }
}
