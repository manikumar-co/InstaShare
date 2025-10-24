package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Post {
    private int id;
    private String caption;
    private String imageName;
    private String username;
    private LocalDateTime timestamp;
    private List<String> likes = new ArrayList<>();
    private List<String> comments = new ArrayList<>();

    public Post(int id, String caption, String imageName, String username) {
        this.id = id;
        this.caption = caption;
        this.imageName = imageName;
        this.username = username;
        this.timestamp = LocalDateTime.now();
    }

    public void like(String user) {
        likes.add(user);
    }

    public void addComment(String comment) {
        comments.add(comment);
    }

    @Override
    public String toString() {
        return String.format("📸 %s\n📝 %s\n❤️ %d Likes | 💬 %d Comments | 👤 %s | ⏰ %s",
                imageName, caption, likes.size(), comments.size(), username, timestamp);
    }
}
