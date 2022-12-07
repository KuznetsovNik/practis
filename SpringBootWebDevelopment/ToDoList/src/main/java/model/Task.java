package model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "Tasks")
public class Task {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    public Task() {
    }

    public Task(int id, LocalDateTime creationTime, boolean isDone, String title, String description) {
        this.id = id;
        this.creationTime = creationTime;
        this.isDone = isDone;
        this.title = title;
        this.description = description;
    }

    @Column(name = "creation_time")
    private LocalDateTime creationTime;

    @Column(name = "is_done")
    private boolean isDone;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {

        return "Task{" +
                "id=" + id +
                ", creationTime=" + creationTime.format(formatter) +
                ", isDone=" + isDone +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

}