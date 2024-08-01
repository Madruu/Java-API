package com.provaJava.androids;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//Does the job of actually talk to the database and give the data back
@Repository
public interface AndroidRepository extends MongoRepository<Android, ObjectId> {
    //Use automatic queries to be able to use the mdbId to search a specific android instead of using the ObjectId
    //Forms queries dynamically from property names
    Optional<Android> findAndroidByImdbId(String imdbId);
}
