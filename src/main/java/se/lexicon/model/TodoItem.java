package se.lexicon.model;

import java.time.LocalDate;
import java.util.Objects;

public class TodoItem {
    private Integer id;
    private String title;
    private String description;
    private LocalDate deadLine;
    private boolean done;
    private Person assignee;

    public TodoItem(Integer id, String title, String description, LocalDate deadLine, boolean done,Person assignee) {
       setId(id);
       setTitle(title);
       setDescription(description);
       setDeadLine(deadLine);
       setDone(done);
       setAssignee(assignee);
    }

    public TodoItem(String title, String description, LocalDate deadLine) {
        setTitle(title);
        setDescription(description);
        setDeadLine(deadLine);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        if (id == null) throw new RuntimeException("id was null");
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null) throw new IllegalArgumentException("title was null");
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(LocalDate deadLine) {
        if (deadLine == null) throw new IllegalArgumentException("deadline was null");
        this.deadLine = deadLine;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public Person getAssignee() {
        return assignee;
    }

    public void setAssignee(Person assignee) {
        this.assignee = assignee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TodoItem todoItem = (TodoItem) o;
        return done == todoItem.done && Objects.equals(id, todoItem.id) && Objects.equals(title, todoItem.title) && Objects.equals(description, todoItem.description) && Objects.equals(deadLine, todoItem.deadLine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, deadLine, done);
    }

    @Override
    public String toString() {
        return "TodoItem{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", deadLine=" + deadLine +
                ", done=" + done +
                ", personName=" + assignee.getFirstName() + " " + assignee.getLastName() +
                '}';
    }
}
