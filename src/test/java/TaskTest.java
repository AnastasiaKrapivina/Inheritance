import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {
    Task task = new Task(5);
    SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

    String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
    Epic epic = new Epic(55, subtasks);

    Meeting meeting = new Meeting(
            555,
            "Выкатка 3й версии приложения",
            "Приложение НетоБанка",
            "Во вторник после обеда"
    );

    @Test
    public void testDataOutput() {

        String[] expectedEpic = {"Молоко", "Яйца", "Хлеб"};

        Assertions.assertEquals(5, task.getId());
        Assertions.assertEquals("Позвонить родителям", simpleTask.getTitle());
        Assertions.assertArrayEquals(expectedEpic, epic.getSubtasks());
        Assertions.assertEquals("Выкатка 3й версии приложения", meeting.getTopic());
        Assertions.assertEquals("Приложение НетоБанка", meeting.getProject());
        Assertions.assertEquals("Во вторник после обеда", meeting.getStart());

    }

    @Test
    public void matchesTaskByFalse() {

        boolean expected = false;
        boolean actual = task.matches("Молоко");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void matchesMeetingByFalse() {

        boolean expected = false;
        boolean actual = meeting.matches("Молоко");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void matchesMeetingByTopicTrue() {

        boolean expected = true;
        boolean actual = meeting.matches("Выкатка 3й версии приложения");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void matchesMeetingByProgectTrue() {

        boolean expected = true;
        boolean actual = meeting.matches("Приложение НетоБанка");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void matchesEpicByFalse() {

        boolean expected = false;
        boolean actual = epic.matches("Приложение НетоБанка");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void matchesEpicByTrue() {

        boolean expected = true;
        boolean actual = epic.matches("Молоко");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void matchesSimpleTaskFalse() {

        boolean expected = false;
        boolean actual = epic.matches("Приложение НетоБанка");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void matchesSimpleTaskByTrue() {

        boolean expected = true;
        boolean actual = simpleTask.matches("Позвонить родителям");
        Assertions.assertEquals(expected, actual);
    }

}