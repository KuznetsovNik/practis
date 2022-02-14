import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Subscription subscription = session.get(Subscription.class, new KeyId(1,10));
        System.out.println(subscription);



        //Создаем новый курс
//        Course course = new Course();
//        course.setName("Новый курс");
//        course.setType(CourseType.BUSINESS);
//        course.setTeacher_id(1);
//        session.save(course);

        // Изменяем курс
//        Course course = session.get(Course.class,49);
//        course.setName("Совсем новый курс");
//        session.save(course);

        // Удаление курса
//        Course course = session.get(Course.class,49);
//        session.delete(course);

        transaction.commit();
        sessionFactory.close();
    }
}
