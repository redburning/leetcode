package leetcode.algorithm.design;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Twitter {

	class Tweet implements Comparable<Tweet> {
		
		private int id;
		private int timestamp;
		
		public Tweet(int id, int timestamp) {
			this.id = id;
			this.timestamp = timestamp;
		}

		@Override
		public int compareTo(Tweet tweet) {
			return tweet.timestamp - this.timestamp;
		}
		
	}
	
	private Map<Integer, List<Tweet>> userMap;
	private Map<Integer, List<Integer>> followMap;
	private int timestamp;
	
	/** Initialize your data structure here. */
    public Twitter() {
    	userMap = new HashMap<>();
    	followMap = new HashMap<>();
    	timestamp = 0;
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
    	if (!userMap.containsKey(userId)) {
    		List<Tweet> tweets = new LinkedList<>();
    		tweets.add(new Tweet(tweetId, timestamp++));
    		userMap.put(userId, tweets);
    	} else {
    		List<Tweet> tweets = userMap.get(userId);
    		tweets.add(new Tweet(tweetId, timestamp++));
    		userMap.put(userId, tweets);
    	}
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
    	Queue<Tweet> queue = new PriorityQueue<>();
    	if (userMap.containsKey(userId)) {
    		List<Tweet> tweets = userMap.get(userId);
        	for (Tweet t : tweets) {
        		queue.add(t);
        	}
    	}
    	
    	if (followMap.containsKey(userId)) {
    		List<Integer> followees = followMap.get(userId);
        	for (int followee : followees) {
        		if (userMap.containsKey(followee)) {
        			List<Tweet> followeeTweets = userMap.get(followee);
            		for (Tweet t : followeeTweets) {
            			queue.add(t);
            		}
        		}
        	}
    	}
    	
    	List<Integer> newsFeed = new LinkedList<Integer>();
    	int cnt = 0;
    	while (cnt < 10 && !queue.isEmpty()) {
    		Tweet t = queue.poll();
    		newsFeed.add(t.id);
    		cnt++;
    	}
    	return newsFeed;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
    	/** Should follow himself(herself) */
    	if (followerId != followeeId) {
    		if (!followMap.containsKey(followerId)) {
        		List<Integer> followees = new LinkedList<>();
        		followees.add(followeeId);
        		followMap.put(followerId, followees);
        	} else {
        		List<Integer> followees = followMap.get(followerId);
        		if (!followees.contains(followeeId)) {
        			followees.add(followeeId);
            		followMap.put(followerId, followees);
        		}
        	}
    	}
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
    	if (followMap.containsKey(followerId)) {
    		List<Integer> followees = followMap.get(followerId);
    		for (int i = 0; i < followees.size(); i++) {
    			if (followees.get(i) == followeeId) {
    				followees.remove(i);
    			}
    		}
    		followMap.put(followerId, followees);
    	}
    }
	
    public static void testCase1() {
    	Twitter twitter = new Twitter();
    	twitter.postTweet(1, 5);
    	List<Integer> tweets = twitter.getNewsFeed(1);
    	for (int i = 0; i < tweets.size(); i++) {
    		System.out.print(" -> " + tweets.get(i));
    	}
    	System.out.println();
    	
    	twitter.follow(1, 2);
    	twitter.postTweet(2, 6);
    	tweets = twitter.getNewsFeed(1);
    	for (int i = 0; i < tweets.size(); i++) {
    		System.out.print(" -> " + tweets.get(i));
    	}
    	System.out.println();
    	
    	twitter.unfollow(1, 2);
    	tweets = twitter.getNewsFeed(1);
    	for (int i = 0; i < tweets.size(); i++) {
    		System.out.print(" -> " + tweets.get(i));
    	}
    }
    
    public static void testCase2() {
    	Twitter twitter = new Twitter();
    	twitter.postTweet(1, 5);
    	twitter.postTweet(1, 3);
    	List<Integer> tweets = twitter.getNewsFeed(1);
    	for (int i = 0; i < tweets.size(); i++) {
    		System.out.print(" -> " + tweets.get(i));
    	}
    	System.out.println();
    }
    
    public static void testCase3() {
    	Twitter twitter = new Twitter();
    	twitter.postTweet(1, 5);
    	twitter.follow(1, 1);
    	List<Integer> tweets = twitter.getNewsFeed(1);
    	for (int i = 0; i < tweets.size(); i++) {
    		System.out.print(" -> " + tweets.get(i));
    	}
    	System.out.println();
    }
    
    public static void testCase4() {
    	Twitter twitter = new Twitter();
    	twitter.postTweet(2, 5);
    	twitter.follow(1, 2);
    	twitter.follow(1, 2);
    	List<Integer> tweets = twitter.getNewsFeed(1);
    	for (int i = 0; i < tweets.size(); i++) {
    		System.out.print(" -> " + tweets.get(i));
    	}
    	System.out.println();
    }
    
    public static void main(String[] args) {
    	// testCase1();
    	// testCase2();
    	// testCase3();
    	testCase4();
    }
    
}
