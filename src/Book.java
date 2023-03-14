public class Book {
    //variables
    private String author;
    private String editor;
    private String title;
    private int pgNum;

    //constructor
    public Book(String author, String editor, String title, int pgNum) {
        this.author = author;
        this.editor = editor;
        this.title = title;
        this.pgNum = pgNum;
    }
    // getters and setters
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPgNum() {
        return pgNum;
    }

    public void setPgNum(int pgNum) {
        this.pgNum = pgNum;
    }
}
