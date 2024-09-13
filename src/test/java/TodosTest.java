import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.*;

public class TodosTest {
    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(
                1,
                "Сходить в спортзал");

        String[] subtasks = {"Молоко", "Сок", "Хлеб"};
        Epic epic = new Epic(
                2,
                subtasks);


        Meeting meeting = new Meeting(
                3,
                "Сдача проекта",
                "Приложение: \"Планировщик задач\" ",
                "Во вторник следующей недели");

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindOneOfTheDifferentTypesTasks() {
        SimpleTask simpleTask = new SimpleTask(
                1,
                "Сходить в спортзал");

        String[] subtasks = {"Молоко", "Сок", "Хлеб"};
        Epic epic = new Epic(
                2,
                subtasks);


        Meeting meeting = new Meeting(
                3,
                "Сдача проекта",
                "Приложение: \"Планировщик задач\" ",
                "Во вторник следующей недели"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask};
        Task[] actual = todos.search("Сходить в спортзал");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchAmongSimpleTasks() {
        SimpleTask simpleTask1 = new SimpleTask(
                1,
                "Сходить в спортзал");
        SimpleTask simpleTask2 = new SimpleTask(
                14,
                "Сходить в кино");
        SimpleTask simpleTask3 = new SimpleTask(
                47,
                "Сходить в магазин");

        Todos todos = new Todos();

        todos.add(simpleTask1);
        todos.add(simpleTask2);
        todos.add(simpleTask3);

        Task[] expected = {simpleTask3};
        Task[] actual = todos.search("Сходить в магазин");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findingTwoIdenticalSimpleTasks() {
        SimpleTask simpleTask1 = new SimpleTask(
                1,
                "Сходить в спортзал");
        SimpleTask simpleTask2 = new SimpleTask(
                14,
                "Сходить в кино");
        SimpleTask simpleTask3 = new SimpleTask(
                47,
                "Сходить в спортзал");

        Todos todos = new Todos();

        todos.add(simpleTask1);
        todos.add(simpleTask2);
        todos.add(simpleTask3);

        Task[] expected = {simpleTask1, simpleTask3};
        Task[] actual = todos.search("Сходить в спортзал");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchingForUnscriptedSimpleTask() {
        SimpleTask simpleTask1 = new SimpleTask(
                1,
                "Сходить в спортзал");
        SimpleTask simpleTask2 = new SimpleTask(
                14,
                "Сходить в кино");
        SimpleTask simpleTask3 = new SimpleTask(
                47,
                "Сходить в магазин");

        Todos todos = new Todos();

        todos.add(simpleTask1);
        todos.add(simpleTask2);
        todos.add(simpleTask3);

        Task[] expected = {};
        Task[] actual = todos.search("Сходить в театр");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchForSimpleTaskStartingWithCapitalLetter() {
        SimpleTask simpleTask1 = new SimpleTask(
                1,
                "Сходить в спортзал");
        SimpleTask simpleTask2 = new SimpleTask(
                14,
                "Сходить в кино");
        SimpleTask simpleTask3 = new SimpleTask(
                47,
                "Сходить в магазин");

        Todos todos = new Todos();

        todos.add(simpleTask1);
        todos.add(simpleTask2);
        todos.add(simpleTask3);

        Task[] expected = {};
        Task[] actual = todos.search("сходить в кино");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchingForSimpleTaskStartingWithLowercaseLetter() {
        SimpleTask simpleTask1 = new SimpleTask(
                1,
                "Сходить в спортзал");
        SimpleTask simpleTask2 = new SimpleTask(
                14,
                "сходить в кино");
        SimpleTask simpleTask3 = new SimpleTask(
                47,
                "Сходить в магазин");

        Todos todos = new Todos();

        todos.add(simpleTask1);
        todos.add(simpleTask2);
        todos.add(simpleTask3);

        Task[] expected = {};
        Task[] actual = todos.search("Сходить в кино");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchAmongSubtasks() {

        String[] subtasks1 = {"Молоко", "Сок", "Хлеб"};
        Epic epic1 = new Epic(
                2,
                subtasks1);
        String[] subtasks2 = {"тетрадь", "ручка", "краски"};
        Epic epic2 = new Epic(
                222,
                subtasks2);
        String[] subtasks3 = {"молоток", "пила", "дрель"};
        Epic epic3 = new Epic(
                26,
                subtasks3);

        Todos todos = new Todos();

        todos.add(epic1);
        todos.add(epic2);
        todos.add(epic3);

        Task[] expected = {epic3};
        Task[] actual = todos.search("дрель");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findingTwoIdenticalSubtasks() {

        String[] subtasks1 = {"Молоко", "Сок", "Хлеб"};
        Epic epic1 = new Epic(
                2,
                subtasks1);
        String[] subtasks2 = {"тетрадь", "ручка", "краски"};
        Epic epic2 = new Epic(
                222,
                subtasks2);
        String[] subtasks3 = {"молоток", "пила", "краски"};
        Epic epic3 = new Epic(
                26,
                subtasks3);

        Todos todos = new Todos();

        todos.add(epic1);
        todos.add(epic2);
        todos.add(epic3);

        Task[] expected = {epic2, epic3};
        Task[] actual = todos.search("краски");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchingForUnscriptedSubtasks() {

        String[] subtasks1 = {"Молоко", "Сок", "Хлеб"};
        Epic epic1 = new Epic(
                2,
                subtasks1);
        String[] subtasks2 = {"тетрадь", "ручка", "краски"};
        Epic epic2 = new Epic(
                222,
                subtasks2);
        String[] subtasks3 = {"молоток", "пила", "краски"};
        Epic epic3 = new Epic(
                26,
                subtasks3);

        Todos todos = new Todos();

        todos.add(epic1);
        todos.add(epic2);
        todos.add(epic3);

        Task[] expected = {};
        Task[] actual = todos.search("бумага");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchForSubtasksStartingWithCapitalLetter() {

        String[] subtasks1 = {"Молоко", "Сок", "Хлеб"};
        Epic epic1 = new Epic(
                2,
                subtasks1);
        String[] subtasks2 = {"тетрадь", "ручка", "краски"};
        Epic epic2 = new Epic(
                222,
                subtasks2);
        String[] subtasks3 = {"молоток", "пила", "краски"};
        Epic epic3 = new Epic(
                26,
                subtasks3);

        Todos todos = new Todos();

        todos.add(epic1);
        todos.add(epic2);
        todos.add(epic3);

        Task[] expected = {};
        Task[] actual = todos.search("Ручка");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchingForSubtasksStartingWithLowercaseLetter() {

        String[] subtasks1 = {"Молоко", "Сок", "Хлеб"};
        Epic epic1 = new Epic(
                2,
                subtasks1);
        String[] subtasks2 = {"тетрадь", "ручка", "краски"};
        Epic epic2 = new Epic(
                222,
                subtasks2);
        String[] subtasks3 = {"молоток", "пила", "краски"};
        Epic epic3 = new Epic(
                26,
                subtasks3);

        Todos todos = new Todos();

        todos.add(epic1);
        todos.add(epic2);
        todos.add(epic3);

        Task[] expected = {};
        Task[] actual = todos.search("сок");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchAmongMeeting() {

        Meeting meeting1 = new Meeting(
                3,
                "Сдача проекта",
                "Приложение: \"Планировщик задач\" ",
                "Во вторник следующей недели");
        Meeting meeting2 = new Meeting(
                333,
                "Начало проекта",
                "Приложение: \"Калькулятор\" ",
                "10 сентября 2024 года");
        Meeting meeting3 = new Meeting(
                102,
                "Выход новой версии",
                "Приложение: \"Как научится плавать\" ",
                "20.09.2024");

        Todos todos = new Todos();

        todos.add(meeting1);
        todos.add(meeting2);
        todos.add(meeting3);

        Task[] expected = {meeting1};
        Task[] actual = todos.search("Сдача проекта");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findingTwoIdenticalMeeting() {

        Meeting meeting1 = new Meeting(
                3,
                "Сдача проекта",
                "Приложение: \"Планировщик задач\" ",
                "Во вторник следующей недели");
        Meeting meeting2 = new Meeting(
                333,
                "Начало проекта",
                "Приложение: \"Планировщик задач\" ",
                "10 сентября 2024 года");
        Meeting meeting3 = new Meeting(
                102,
                "Выход новой версии",
                "Приложение: \"Как научится плавать\" ",
                "20.09.2024");

        Todos todos = new Todos();

        todos.add(meeting1);
        todos.add(meeting2);
        todos.add(meeting3);

        Task[] expected = {meeting1, meeting2};
        Task[] actual = todos.search("Приложение: \"Планировщик задач\" ");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchingForUnscriptedMeeting() {

        Meeting meeting1 = new Meeting(
                3,
                "Сдача проекта",
                "Приложение: \"Планировщик задач\" ",
                "Во вторник следующей недели");
        Meeting meeting2 = new Meeting(
                333,
                "Начало проекта",
                "Приложение: \"Планировщик задач\" ",
                "10 сентября 2024 года");
        Meeting meeting3 = new Meeting(
                102,
                "Выход новой версии",
                "Приложение: \"Как научится плавать\" ",
                "20.09.2024");

        Todos todos = new Todos();

        todos.add(meeting1);
        todos.add(meeting2);
        todos.add(meeting3);

        Task[] expected = {};
        Task[] actual = todos.search("Продление выхода новой версии");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchForMeetingStartingWithCapitalLetter() {

        Meeting meeting1 = new Meeting(
                3,
                "сдача проекта",
                "Приложение: \"Планировщик задач\" ",
                "Во вторник следующей недели");
        Meeting meeting2 = new Meeting(
                333,
                "Начало проекта",
                "Приложение: \"Планировщик задач\" ",
                "10 сентября 2024 года");
        Meeting meeting3 = new Meeting(
                102,
                "Выход новой версии",
                "Приложение: \"Как научится плавать\" ",
                "20.09.2024");

        Todos todos = new Todos();

        todos.add(meeting1);
        todos.add(meeting2);
        todos.add(meeting3);

        Task[] expected = {};
        Task[] actual = todos.search("Сдача проекта");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchingForMeetingStartingWithLowercaseLetter() {

        Meeting meeting1 = new Meeting(
                3,
                "Сдача проекта",
                "Приложение: \"Планировщик задач\" ",
                "Во вторник следующей недели");
        Meeting meeting2 = new Meeting(
                333,
                "Начало проекта",
                "Приложение: \"Планировщик задач\" ",
                "10 сентября 2024 года");
        Meeting meeting3 = new Meeting(
                102,
                "Выход новой версии",
                "Приложение: \"Как научится плавать\" ",
                "20.09.2024");

        Todos todos = new Todos();

        todos.add(meeting1);
        todos.add(meeting2);
        todos.add(meeting3);

        Task[] expected = {};
        Task[] actual = todos.search("приложение: \"Планировщик задач\" ");
        Assertions.assertArrayEquals(expected, actual);
    }
}