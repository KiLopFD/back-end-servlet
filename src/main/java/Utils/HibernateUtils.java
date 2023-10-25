package Utils;

import Models.UsersEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
    private static final SessionFactory sessionFactory;
    protected Object object = null;
    static {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public HibernateUtils(Object object) {
        this.object = object;
    }

    public void saveEntity() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        // Save the cat object
        session.save(this.object);

        session.getTransaction().commit();
        session.close();
    }

    public Object getEntityById(int pk) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        // Retrieve the cat object by ID
        this.object = session.get(this.object.getClass(), pk);
        session.getTransaction().commit();
        session.close();

        return this.object;
    }

    public void updateEntity(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(this.object);

        session.getTransaction().commit();
        session.close();
    }
}