import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        List<Integer> idStudents = session.createSQLQuery("SELECT Students.id FROM Students JOIN Purchaselist ON Purchaselist.student_name = Students.name").getResultList();
        for (Integer integer : idStudents){
            System.out.println(integer);
        }

        List<Integer> idCourses = session.createSQLQuery("SELECT Courses.id FROM Courses JOIN Purchaselist ON Purchaselist.course_name = Courses.name").getResultList();
        for (Integer integer : idCourses){
            System.out.println(integer);
        }
        try {
            for (int i = 1; i < idStudents.size(); i++) {
                for (int x = 1; x < idCourses.size(); x++) {
                    LinkedPurchaseList linkedPurchaseList = new LinkedPurchaseList(idStudents.get(i), idCourses.get(x));
                    session.save(linkedPurchaseList);
                }
            }
        }catch (Exception exception){
            exception.printStackTrace();
        }
        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
