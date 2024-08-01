package com.provaJava.androids;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    //With the review object, needs to be inserted to the database
    //Needs reference to reviewRepository
    @Autowired
    private ReviewRepository reviewRepository;

    //To associate this with one of the movies, needs a template
    @Autowired
    private MongoTemplate mongoTemplate;//Form a new Dynamic query and do the job inside the database without the repository

    public Review createReview(String reviewBody, String imdbId){
        Review review = reviewRepository.insert(new Review(reviewBody));

        //Associate this with one of the movies
        mongoTemplate.update(Android.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds").value(review))
                .first();
        return review;
    }
}


