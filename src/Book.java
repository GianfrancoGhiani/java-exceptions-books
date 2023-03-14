public class Book {
    //variables
    private String author;
    private String editor;
    private String title;
    private int pgNum;

    //constructor
    public Book(String author, String editor, String title, int pgNum) throws IllegalArgumentException {
        if(isStringEmpty(title) || isStringEmpty(author) || isStringEmpty(editor)){
            throw new IllegalArgumentException("All fields must be filled");
        }
        if (pgNum <= 0){
            throw new IllegalArgumentException("Page Num must be an int bigger than 0");
        }
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
        if (!isStringEmpty(author)) {
            this.author = author;
        }else{
            throw new IllegalArgumentException("The 'Author' field must be filled");
        }
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        if (!isStringEmpty(editor)) {
            this.editor = editor;
        }else{
            throw new IllegalArgumentException("The 'Editor' field must be filled");
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (!isStringEmpty(title)) {
            this.title = title;
        }else{
            throw new IllegalArgumentException("The 'Title' field must be filled");
        }
    }

    public int getPgNum() {
        return pgNum;
    }

    public void setPgNum(int pgNum) {
        if (!(pgNum <= 0)) {
            this.pgNum = pgNum;
        }else{
            throw new IllegalArgumentException("Page Num must be an int bigger than 0");
        }
    }

    //methods
    private boolean isStringEmpty(String stringToCheck){

        if (stringToCheck.isBlank() || stringToCheck == null){
            return true;
        } else {
            return false;
        }
    }
    //override

    @Override
    public String toString() {
        return
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", editor='" + editor + '\'' +
                ", pgNum=" + pgNum;
    }
}
