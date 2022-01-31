package hyperpack;

import org.hibernate.*;
import org.hibernate.query.Query;
import org.hibernate.cfg.Configuration;

import javax.persistence.metamodel.EntityType;

import java.util.List;
import java.util.Map;

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


        //final Session session = getSession();
        /*
        try {
            System.out.println("querying all the managed entities...");
            final Metamodel metamodel = session.getSessionFactory().getMetamodel();
            for (EntityType<?> entityType : metamodel.getEntities()) {
                final String entityName = entityType.getName();
                final Query query = session.createQuery("from " + entityName);
                System.out.println("executing: " + query.getQueryString());
                for (Object o : query.list()) {
                    System.out.println("  " + o);
                }
            }
        } finally {
            session.close();
        }
        */
    }
}