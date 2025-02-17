package TemaTest;
import java.util.ArrayList;

/*Clasa User retine toate informatiile necesare unui utilizator, precum postarile si
 comentariile sale, pe cine urmareste si de cine este urmarit si likeurile date de el,
 precum si metodele necesare pentru a le accesa si modifica */
public class User implements Comparable<User>{
    private String username;
    private String password;

    ArrayList<User> followers;
    ArrayList<User> following;
    ArrayList<Post> posts;
    ArrayList<Post> likedPosts;
    ArrayList<Comment> likedComments;

    public User(){

    }
    public User(String username, String password){
        this.username = username;
        this.password = password;
        this.followers = new ArrayList<User>();
        this.following = new ArrayList<User>();
        this.posts = new ArrayList<Post>();
        this.likedPosts = new ArrayList<Post>();
        this.likedComments = new ArrayList<Comment>();
    }
    public void addFollower(User user){
        this.followers.add(user);
    }
    public void addFollowing(User user){
        this.following.add(user);
    }

    public void removePost(Post post) {
        this.posts.remove(post);
    }
    public void addPost(Post post){
        this.posts.add(post);
    }
    public void addLikedPost(Post post){
        this.likedPosts.add(post);
    }
    public void addLikedComment(Comment comment){
        this.likedComments.add(comment);
    }
    public void removeFollower(User user){
        this.followers.remove(user);
    }
    public void removeFollowing(User user){
        this.following.remove(user);
    }
    public String getUsername(){
        return this.username;
    }
    public String getPassword(){
        return this.password;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public int getFollowersSize(){
        return this.followers.size();
    }

    @Override
    public int compareTo(User user) {
        return (this.likedPosts.size()+this.likedComments.size()) - (user.likedPosts.size()+user.likedComments.size());
    }
}
