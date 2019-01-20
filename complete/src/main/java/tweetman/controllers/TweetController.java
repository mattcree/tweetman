package tweetman.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tweetman.models.Tweet;
import tweetman.services.TweetService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/tweets")
public class TweetController {

    private TweetService tweetService;

    public TweetController(TweetService tweetService) {
        this.tweetService = tweetService;
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity newTweet(@RequestBody @Valid Tweet tweet) {
        this.tweetService.newTweet(tweet);
        return ResponseEntity.status(201).body(tweet);
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity allUsersTweets() {
        return ResponseEntity.status(201).body(this.tweetService.getAllUsersTweets());
    }

    @RequestMapping(path = "/{username}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity allTweets(@PathVariable("username") String username) {
        return ResponseEntity.status(200).body(this.tweetService.getAllTweets(username));
    }

}
