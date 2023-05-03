public class SimpleTask extends Task {
    protected String title;

    public SimpleTask(int id, String title) {
        super(id); // вызов родительского конструктора
        this.title = title; // название
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean matches(String query) {
        //s1.contains(s2) отвечает на вопрос, содержится ли текст из s2 в тексте из s1
        if (title.contains(query)) {
            return true;
        }
        return false;
    }
}
