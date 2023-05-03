public class Epic extends Task {
    protected String[] subtasks;

    public Epic(int id, String[] subtasks) {
        super(id); // вызов родительского конструктора
        this.subtasks = subtasks; //  массив из подзадач, каждая из которых является простым текстом
    }

    public String[] getSubtasks() {
        return subtasks;
    }

    @Override
    public boolean matches(String query) {
        //s1.contains(s2) отвечает на вопрос, содержится ли текст из s2 в тексте из s1
        for (int i = 0; i < subtasks.length; i++)
            if (subtasks[i].contains(query)) {
                return true;
            }
        return false;
    }

}
