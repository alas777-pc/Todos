import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.Epic;
import ru.netology.Meeting;
import ru.netology.SimpleTask;

public class TasksTest {
    @Test
    public void shouldMatchSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        Assertions.assertTrue(simpleTask.matches("Позвонить"));
        Assertions.assertFalse(simpleTask.matches("Купить"));
    }

    @Test
    public void shouldMatchEpic() {
        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);
        Assertions.assertTrue(epic.matches("Молоко"));
        Assertions.assertFalse(epic.matches("Купить"));
    }

    @Test
    public void shouldMatchMeeting() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        Assertions.assertTrue(meeting.matches("Приложение"));
        Assertions.assertFalse(meeting.matches("Купить"));
    }
}

