package pp1301;

public class Magazine implements Comparable<Magazine>{
    private String title;

    public Magazine(String newTitle){
        this.title = newTitle;
    }

    public String getTitle(){
        return this.title;
    }

    public String toString(){
        return title;
    }

    @Override
    public int compareTo(Magazine o) {
        return this.title.compareTo(o.title);
    }
}
