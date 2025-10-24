import model.Post;
import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static List<Post> posts = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("===== InstaShare 📷 =====");
        while (true) {
            System.out.println("\n1️⃣ Add Post");
            System.out.println("2️⃣ View Feed");
            System.out.println("3️⃣ Like a Post");
            System.out.println("4️⃣ Comment on Post");
            System.out.println("5️⃣ Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt(); sc.nextLine();

            switch (choice) {
                case 1 -> addPost();
                case 2 -> viewFeed();
                case 3 -> likePost();
                case 4 -> commentPost();
                case 5 -> System.exit(0);
                default -> System.out.println("Invalid option!");
            }
        }
    }

    static void addPost() {
        System.out.print("Enter username: ");
        String user = sc.nextLine();
        System.out.print("Enter caption: ");
        String caption = sc.nextLine();
        System.out.print("Enter image filename: ");
        String image = sc.nextLine();
        posts.add(new Post(posts.size() + 1, caption, image, user));
        System.out.println("✅ Post uploaded!");
    }

    static void viewFeed() {
        if (posts.isEmpty()) {
            System.out.println("No posts yet 😔");
            return;
        }
        posts.forEach(System.out::println);
    }

    static void likePost() {
        System.out.print("Enter Post ID: ");
        int id = sc.nextInt(); sc.nextLine();
        if (id <= 0 || id > posts.size()) return;
        System.out.print("Enter your username: ");
        String user = sc.nextLine();
        posts.get(id - 1).like(user);
        System.out.println("❤️ Liked!");
    }

    static void commentPost() {
        System.out.print("Enter Post ID: ");
        int id = sc.nextInt(); sc.nextLine();
        if (id <= 0 || id > posts.size()) return;
        System.out.print("Enter your comment: ");
        String c = sc.nextLine();
        posts.get(id - 1).addComment(c);
        System.out.println("💬 Comment added!");
    }
}
