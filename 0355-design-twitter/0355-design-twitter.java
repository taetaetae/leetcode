class Twitter {

    static int timeStamp = 0;
    Map<Integer, User> userMap;

    public class User {

      int id;
      Set<Integer> followed;
      Tweet headTweet;

      User(int id) {
        this.id = id;
        this.followed = new HashSet<>();
        follow(id);
        headTweet = null;
      }

      void follow(int id) {
        followed.add(id);
      }

      void unfollow(int id) {
        followed.remove(id);
      }

      void post(int id) {
        Tweet tweet = new Tweet(id);
        tweet.next = headTweet;
        headTweet = tweet;
      }
    }

    public class Tweet {

      int id;
      int time;
      Tweet next;

      Tweet(int id) {
        this.id = id;
        this.time = timeStamp++;
        this.next = null;
      }
    }

    public Twitter() {
      this.userMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
      if(!userMap.containsKey(userId)){
			User u = new User(userId);
			userMap.put(userId, u);
		}
		userMap.get(userId).post(tweetId);
    }

    public List<Integer> getNewsFeed(int userId) {
      if (!userMap.containsKey(userId)) {
        return Collections.emptyList();
      }

      Set<Integer> followed = userMap.get(userId).followed;
      PriorityQueue<Tweet> queue = new PriorityQueue<>(followed.size(), (a, b) -> (b.time - a.time));
      for (Integer followerId : followed) {
        Tweet tweet = userMap.get(followerId).headTweet;

        if (tweet != null) {
          queue.add(tweet);
        }
      }

      int count = 0;
      List<Integer> results = new ArrayList<>();
      while (!queue.isEmpty() && count < 10) {
        Tweet poll = queue.poll();

        results.add(poll.id);
        count++;
        if (poll.next != null) {
          queue.add(poll.next);
        }
      }

      return results;

    }

    public void follow(int followerId, int followeeId) {
      if (!userMap.containsKey(followerId)) {
        userMap.put(followerId, new User(followerId));
      }
      if (!userMap.containsKey((followeeId))) {
        userMap.put(followeeId, new User(followeeId));
      }
      userMap.get(followerId).follow(followeeId);

    }

    public void unfollow(int followerId, int followeeId) {
      if (!userMap.containsKey(followerId)) {
        return;
      }
      userMap.get(followerId).unfollow(followeeId);
    }

}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */