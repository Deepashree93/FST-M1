package Activities;

abstract class Book {
    String title;

    abstract void setTitle(String S) ;
public String getTitle(){
    return title ;
}
}

class MyBook extends Book {
    public void setTitle(String s) {
        title = s;
    }
public static void main (String [] args) {
    MyBook newNovel = new MyBook();
    String title = "Java-Selenium Programming" ;
    newNovel.setTitle(title);
    System.out.println("The title is: " + newNovel.getTitle());
}
}

