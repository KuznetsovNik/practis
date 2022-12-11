package model;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "tasks")
public class Task implements Serializable {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @CreatedDate
    @Column(name = "creation_time")
    private LocalDateTime creationTime;
    @Column(name = "is_done")
    private boolean isDone;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;

    public Task() {
    }

    public Task(String title, String description) {
        creationTime = LocalDateTime.now();
        isDone = false;
        this.title = title;
        this.description = description;
    }

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