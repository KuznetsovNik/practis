import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

@Entity
@Table(name = "Courses")

public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private int duration;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "enum")
    private CourseType type;

    private String description;

    @Column(name = "teacher_id")
    private int teacherId;

    @Column(name = "students_count")
    private int studentsCount;

    private int price;

    @Column(name = "price_per_hour")
    private float pricePerHour;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public CourseType getType() {
        return type;
    }

    public void setType(CourseType type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTeacher_id() {
        return teacherId;
    }

    public void setTeacher_id(int teacher_id) {
        this.teacherId = teacher_id;
    }

    public int getStudents_count() {
        return studentsCount;
    }

    public void setStudents_count(int students_count) {
        this.studentsCount = students_count;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public float getPrice_per_hour() {
        return pricePerHour;
    }

    public void setPrice_per_hour(float price_per_hour) {
        this.pricePerHour = price_per_hour;
    }
}
