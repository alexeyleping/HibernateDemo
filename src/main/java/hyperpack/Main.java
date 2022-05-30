package hyperpack;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class Main {
    private static final SessionFactory ourSessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void main(final String[] args) throws Exception {



        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        /*
        //Добавление объекта в базу
        UsersEntity usersEntity = new UsersEntity();
        usersEntity.setName("Pavel22");
        session.save(usersEntity);

        //Удаление объекта
        UsersEntity usersEntity2 = new UsersEntity();
        usersEntity2.setIdusers(9);
        session.remove(usersEntity2);
        //transaction.commit();

        //Получение объекта из бд
        UsersEntity uE3 = session.get(UsersEntity.class, 2);
        System.out.println(uE3);
        */

        List<UsersEntity> list = null;
        Query query = session.createQuery("FROM UsersEntity");
        list = (List<UsersEntity>) query.list();
        System.out.println(list);
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();

    }
}