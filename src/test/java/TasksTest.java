import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.Epic;
import ru.netology.Meeting;
import ru.netology.SimpleTask;
import ru.netology.Task;

import java.util.Objects;

class TasksTest {
    @Test
    public void taskSearchByTopic() {
        Meeting meeting = new Meeting(
                3,
                "Сдача проекта",
                "Приложение: \"Планировщик задач\" ",
                "Во вторник следующей недели");

        Boolean expected = true;
        Boolean actual = meeting.matches("Сдача проекта");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void taskSearchByProject() {
        Meeting meeting = new Meeting(
                3,
                "Сдача проекта",
                "Приложение: \"Планировщик задач\" ",
                "Во вторник следующей недели");

        Boolean expected = true;
        Boolean actual = meeting.matches("Приложение: \"Планировщик задач\" ");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void searchTasksForNonExistentMeeting() {
        Meeting meeting = new Meeting(
                3,
                "Сдача проекта",
                "Приложение: \"Планировщик задач\" ",
                "Во вторник следующей недели");

        Boolean expected = false;
        Boolean actual = meeting.matches("Начало проекта");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void writeDownTopic() {
        Meeting meeting = new Meeting(
                3,
                "Сдача проекта",
                "Приложение: \"Планировщик задач\" ",
                "Во вторник следующей недели");

        String expected = "Сдача проекта";
        String actual = meeting.getTopic();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void writeDownProject() {
        Meeting meeting = new Meeting(
                3,
                "Сдача проекта",
                "Приложение: \"Планировщик задач\" ",
                "Во вторник следующей недели");

        String expected = "Приложение: \"Планировщик задач\" ";
        String actual = meeting.getProject();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void writeDownStart() {
        Meeting meeting = new Meeting(
                3,
                "Сдача проекта",
                "Приложение: \"Планировщик задач\" ",
                "Во вторник следующей недели");

        String expected = "Во вторник следующей недели";
        String actual = meeting.getStart();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void taskSearchByTitle() {
        SimpleTask simpleTask = new SimpleTask(
                1,
                "Сходить в спортзал");
        Boolean expected = true;
        Boolean actual = simpleTask.matches("Сходить в спортзал");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void searchForIssuesByNonExistingTitle() {
        SimpleTask simpleTask = new SimpleTask(
                1,
                "Сходить в спортзал");
        Boolean expected = false;
        Boolean actual = simpleTask.matches("Сходить в кино");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void writeDownTitle() {
        SimpleTask simpleTask = new SimpleTask(
                1,
                "Сходить в спортзал");

        String expected = "Сходить в спортзал";
        String actual = simpleTask.getTitle();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void searchForTaskThatIsInTheList() {
        String[] subtasks = {"Молоко", "Сок", "Хлеб"};
        Epic epic = new Epic(
                2,
                subtasks);
        Boolean expected = true;
        Boolean actual = epic.matches("Сок");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void searchForTaskThatIsNotInTheList() {
        String[] subtasks = {"Молоко", "Сок", "Хлеб"};
        Epic epic = new Epic(
                2,
                subtasks);
        Boolean expected = false;
        Boolean actual = epic.matches("Кофе");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void writeDownSubtasks() {
        String[] subtasks = {"Молоко", "Сок", "Хлеб"};
        Epic epic = new Epic(
                2,
                subtasks);

        String[] expected = {"Молоко", "Сок", "Хлеб"};
        String[] actual = epic.getSubtasks();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void writeDownTheId() {
        Task task = new Task(2);

        int expected = 2;
        int actual = task.getId();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void writeDownTheId_1() {
        Task task = new Task(-1);

        int expected = Objects.hash(-1);
        int actual = task.hashCode();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void writeDownTheId0() {
        Task task = new Task(0);

        int expected = Objects.hash(0);
        int actual = task.hashCode();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void writeDownTheId1() {
        Task task = new Task(1);

        int expected = Objects.hash(1);
        int actual = task.hashCode();
        Assertions.assertEquals(expected, actual);
    }

}