package com.provaJava.androids;

//Annotate this class as a document

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document(collection = "movies")//Should represent any documents on movie collection
@Data //Takes care of all the getters and setters
@AllArgsConstructor //Creates a constructor that takes all these private fields as arguments
@NoArgsConstructor //Takes no parameters whatsoever
public class Android {
    //Annotate this id field as an actual id

    //Id of the movie
    //Annotate this id field as an actual id
    @Id
    private ObjectId id;
    private String imdbId;
    private String title;
    private String releaseDate;
    private String trailerLink;
    private String poster;
    private List<String> genres;
    private List<String> backDrops;

    @DocumentReference
    private List<Review> reviewIds;
}
