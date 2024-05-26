/*
Sarai Ayon
5/17/2024
CS240 Data Structures and Algorithms
Week 6: Binary Search tree 
This is a Movie Database program that will allow the user to add, delete, and search for movies
in a binary search tree. Displayed is the movies Title, Genre, Release Date and IMPDg rating.
*/
import java.util.Date;

class Movie {
    String title;
    Date releaseDate;
    String genre;
    double imdbRating;

    Movie(String title, Date releaseDate, String genre, double imdbRating) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.genre = genre;
        this.imdbRating = imdbRating;
    }
}

class BSTNode {
    Movie movie;
    BSTNode left, right;

    BSTNode(Movie movie) {
        this.movie = movie;
        this.left = this.right = null;
    }
}

class MovieBST {
    private BSTNode root;

    public MovieBST() {
        root = null;
    }

    public void insert(Movie movie) {
        root = insertRec(root, movie);
    }

    private BSTNode insertRec(BSTNode root, Movie movie) {
        if (root == null) {
            root = new BSTNode(movie);
            return root;
        }
        if (movie.title.compareTo(root.movie.title) < 0)
            root.left = insertRec(root.left, movie);
        else if (movie.title.compareTo(root.movie.title) > 0)
            root.right = insertRec(root.right, movie);

        return root;
    }

    public void preOrder() {
        preOrderRec(root);
    }

    private void preOrderRec(BSTNode node) {
        if (node != null) {
            System.out.println(node.movie.title + " (" + node.movie.releaseDate + ") - " + node.movie.genre + " - " + node.movie.imdbRating);
            preOrderRec(node.left);
            preOrderRec(node.right);
        }
    }

    public void inOrder() {
        inOrderRec(root);
    }

    private void inOrderRec(BSTNode node) {
        if (node != null) {
            inOrderRec(node.left);
            System.out.println(node.movie.title + " (" + node.movie.releaseDate + ") - " + node.movie.genre + " - " + node.movie.imdbRating);
            inOrderRec(node.right);
        }
    }

    public void postOrder() {
        postOrderRec(root);
    }

    private void postOrderRec(BSTNode node) {
        if (node != null) {
            postOrderRec(node.left);
            postOrderRec(node.right);
            System.out.println(node.movie.title + " (" + node.movie.releaseDate + ") - " + node.movie.genre + " - " + node.movie.imdbRating);
        }
    }

    public static void main(String[] args) {
        MovieBST bst = new MovieBST();

        // Creating sample movies
        Movie movie1 = new Movie("The Shawshank Redemption", new Date(1994 - 1900, 9, 23), "Drama", 9.3);
        Movie movie2 = new Movie("The Godfather", new Date(1972 - 1900, 2, 24), "Crime", 9.2);
        Movie movie3 = new Movie("The Dark Knight", new Date(2008 - 1900, 6, 18), "Action", 9.0);
        Movie movie4 = new Movie("Pulp Fiction", new Date(1994 - 1900, 9, 14), "Crime", 8.9);
        Movie movie5 = new Movie("Schindler's List", new Date(1993 - 1900, 11, 15), "Biography", 8.9);

        // Inserting movies into the BST
        bst.insert(movie1);
        bst.insert(movie2);
        bst.insert(movie3);
        bst.insert(movie4);
        bst.insert(movie5);

        // Performing and printing traversals
        System.out.println("Pre-order traversal:");
        bst.preOrder();

        System.out.println("\nIn-order traversal:");
        bst.inOrder();

        System.out.println("\nPost-order traversal:");
        bst.postOrder();
    }
}
