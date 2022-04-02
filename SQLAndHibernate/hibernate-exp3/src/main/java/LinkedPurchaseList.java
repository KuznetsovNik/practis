import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "LinkedPurchaseList")
public class LinkedPurchaseList {
    @EmbeddedId
    private KeyId keyId;

    @Column(name = "student_id", insertable = false, updatable = false)
    private int studentId;

    @Column(name = "course_id", insertable = false, updatable = false)
    private int courseId;

    public LinkedPurchaseList() {
    }

    public LinkedPurchaseList(int studentId, int courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public KeyId getKeyId() {
        return keyId;
    }

    public void setKeyId(KeyId keyId) {
        this.keyId = keyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinkedPurchaseList that = (LinkedPurchaseList) o;
        return studentId == that.studentId &&
                courseId == that.courseId &&
                Objects.equals(keyId, that.keyId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(keyId, studentId, courseId);
    }

    @Override
    public String toString() {
        return "LinkedPurchaseList{" +
                "keyId=" + keyId +
                ", studentId=" + studentId +
                ", courseId=" + courseId +
                '}';
    }
}
