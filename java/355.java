class Tweet {
    final public int tweetId;
    final public int time; 
    public Tweet next = null;

    public Tweet(int tweetId, int time) {
        this.tweetId = tweetId;
        this.time = time;
    }
}

class User {
    private int userId;
    public Set<Integer> followees;
    public Tweet tweetHead = null;

    public User(int userId) {
        this.userId = userId;
        this.followees = new HashSet<>();
        this.follow(userId); // add self to the followees set
    }

    public void follow(int id) {
        this.followees.add(id);
    }
    public void unfollow(int id) {
        this.followees.remove(id);
    }

    public void post(int tweetId, int time) {
        Tweet newTweetHead = new Tweet(tweetId, time);
        newTweetHead.next = this.tweetHead;
        this.tweetHead = newTweetHead;
    }
}

class Twitter {
    private int time = 0;
    private Map<Integer, User> users;
    // private Map<Integer, LinkedList<Tweet>> userTweets; 
    // private Map<Integer, Set<Integer>> followers; 

    public Twitter() {
        this.time = 0;
        this.users = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        users.putIfAbsent(userId, new User(userId)); // add to user db if it is a new user
        users.get(userId).post(tweetId, time++);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        if (!users.containsKey(userId)) return new ArrayList<>();

        List<Integer> newsFeed = new ArrayList<>();
        PriorityQueue<Tweet> maxHeap = new PriorityQueue<>((a, b) -> (b.time - a.time));

        for (int followeeId : users.get(userId).followees) {
            Tweet tweetHead = users.get(followeeId).tweetHead;
            if (tweetHead != null) maxHeap.offer(tweetHead);
        }

        int count = 0;
        while (!maxHeap.isEmpty() && count < 10) {
            Tweet tweet = maxHeap.poll();
            newsFeed.add(tweet.tweetId);
            if (tweet.next != null) maxHeap.offer(tweet.next);
            count++;
        }

        return newsFeed;
    }
    
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return; // A user cannot follow himself
        users.putIfAbsent(followerId, new User(followerId));
        users.putIfAbsent(followeeId, new User(followeeId));
        users.get(followerId).follow(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) return; // A user cannot unfollow himself
        if (users.containsKey(followerId) && users.containsKey(followeeId)) { // unfollow operation if both users exist
            users.get(followerId).unfollow(followeeId);
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
