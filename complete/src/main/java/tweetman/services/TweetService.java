package tweetman.services;

import org.springframework.stereotype.Service;
import tweetman.models.Tweet;

import java.util.*;

@Service
public class TweetService {

    Map<String, ArrayList<Tweet>> tweets;

    public TweetService() {
        this.tweets = new HashMap<>();
    }

    public boolean newTweet(Tweet tweet) {
        if (!tweets.containsKey(tweet.getUsername())) {
            this.tweets.put(tweet.getUsername(), new ArrayList<>());
        }
        return this.tweets.get(tweet.getUsername()).add(tweet);
    }

    public List<Tweet> getAllTweets(String username) {
        return this.tweets.get(username);
    }

    public Map<String, ArrayList<Tweet>> getAllUsersTweets() {
        return this.tweets;
    }

}
