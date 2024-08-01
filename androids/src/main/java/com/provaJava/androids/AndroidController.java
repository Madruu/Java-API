package com.provaJava.androids;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/androids")//Any request to this endpoint will be handled in this single controller
public class AndroidController {
    @Autowired
    //Needs reference to service class
    private AndroidService androidService;

    @GetMapping
    public ResponseEntity<List<Android>> getAllAndroids(){
        //Return the list of all movies through a responseEntity
        return new ResponseEntity<List<Android>>(androidService.allAndroids(), HttpStatus.OK);
    }

    //Now a mapping for an android in particular (Based on its id)
    //Using a path variable to let the framework know that it is being passed the information that have been gotten on the
    //mapping as a pathVariable
    @GetMapping("/{imdbId}")
    public ResponseEntity<Optional<Android>> getAndroidById(@PathVariable String imdbId){
        return new ResponseEntity<Optional<Android>>(androidService.getAndroidById(imdbId), HttpStatus.OK);
    }
}
