package TemaTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.time.format.DateTimeFormatter;

/*Clasa post implementeaza interfetele Comparable si Likeable si retine toate informatiile
 necesare unei postari, precum si metodele necesare pentru a le accesa si modifica */
public class Post implements Comparable<Post>, Likeable{
    private static Integer id_Counter = 0;
    private String text;
    private int id = 0;
    private String postDate;
    private String username;

    ArrayList<Comment> comments;
    ArrayList<User> likes;

    public Post(){

    }

    // Formatarea datei
    private LocalDateTime data = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    String dataFormata = data.format(formatter);
    public Post(String text, String username){
        this.text = text;
        this.id = ++id_Counter;
        this.username = username;
        this.postDate = dataFormata;
        this.comments = new ArrayList<Comment>();
        this.likes = new ArrayList<User>();
    }

    public int getLikes(){
        return this.likes.size();
    }
    public String getText(){
        return this.text;
    }
    public int getId(){
        return this.id;
    }
    public String getUsername(){
        return this.username;
    }
    public String getPostDate() {
        return this.postDate;
    }
    public int getCommentsSize(){
        return this.likes.size();
    }
    public void likePost(User user) {
        this.likes.add(user);
    }
    public void addComment(Comment comment){
        this.comments.add(comment);
    }
    public void resetPostCounter() {
        id_Counter = 0;
    }
    public int getLikesSize(){
        return this.likes.size();
    }
    @Override
    public void unlikePost(User user) {
        this.likes.remove(user);
    }
    @Override
    public void likeComment(User user) {
    }
    @Override
    public void unlikeComment(User user) {
    }
    @Override
    public int compareTo(Post post) {
        return this.likes.size() - post.getLikes();
    }
}
