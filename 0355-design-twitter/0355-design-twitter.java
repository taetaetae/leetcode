class Twitter {
    /*
    누가 어떤 아이디로 글을 썼고
    누가 누구를 팔로우 하고
    사용자가 팔로우 하는 사람들의 글 목록을 보여주고
     */

    Map<Integer, Set<Integer>> relations;
    List<Tweet> tweets;

    class Tweet {

      Integer userId;
      Integer postId;

      Tweet(Integer userId, Integer postId) {
        this.userId = userId;
        this.postId = postId;
      }
    }

    public Twitter() {
      tweets = new LinkedList<>();
      relations = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
      tweets.add(0,new Tweet(userId, tweetId));

    }

    public List<Integer> getNewsFeed(int userId) {
      List<Integer> tweetIds = new ArrayList<>();
      Set<Integer> follower = relations.get(userId);
      for (Tweet tweet : tweets) {
        if (tweetIds.size() == 10) {
          break;
        }
        if (follower != null && follower.contains(tweet.userId)) {
          tweetIds.add(tweet.postId);
        } else if (tweet.userId == userId) {
          tweetIds.add(tweet.postId);
        }
      }
      return tweetIds;
    }

    public void follow(int followerId, int followeeId) {
      if (!relations.containsKey(followerId)) {
        Set<Integer> follower = new HashSet<>();
        follower.add(followeeId);
        relations.put(followerId, follower);
      } else {
        Set<Integer> follower = relations.get(followerId);
        follower.add(followeeId);
      }
    }

    public void unfollow(int followerId, int followeeId) {
      if (relations.containsKey(followerId)) {
        Set<Integer> follower = relations.get(followerId);
        follower.remove(followeeId);
      }
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