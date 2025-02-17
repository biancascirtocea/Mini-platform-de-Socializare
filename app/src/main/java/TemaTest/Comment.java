package TemaTest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Comment implements Comparable<Comment>, Likeable{
    private static Integer comment_Counter = 0;
    private int id = comment_Counter;
    private String commentDate;
    private String username;
    private String text;

    ArrayList<User> likes;

    public Comment(){

    }

    // Formatarea datei
    private LocalDateTime data = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    String dataFormata = data.format(formatter);
    public Comment(String username, String text){
        this.id = ++comment_Counter;
        this.commentDate = dataFormata;
        this.username = username;
        this.text = text;
        this.likes = new ArrayList<User>();
    }
    public int getId(){
        return this.id;
    }
    public String getUsername(){
        return this.username;
    }
    public String getText(){
        return this.text;
    }
    public String getCommentDate() {
        return dataFormata;
    }

    /* Functia resetCommentCounter() este folosita pentru a reseta
     numarul de comentarii, atunci cand se face clear la lista de comentarii*/
    public void resetCommentCounter() {
        comment_Counter = 0;
    }
    public int getLikes(){
        return this.likes.size();
    }
    @Override
    public void likeComment (User user) {
        this.likes.add(user);
    }
    @Override
    public void unlikeComment (User user) {
        this.likes.remove(user);
    }
    @Override
    public void likePost (User user) {
    }
    @Override
    public void unlikePost(User user) {
    }
    @Override
    public int compareTo(Comment comment) {
        return this.likes.size() - comment.getLikes();
    }
}
