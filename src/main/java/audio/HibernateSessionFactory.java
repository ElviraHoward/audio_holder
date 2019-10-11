package audio;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by Elvira on 11.10.2019.
 */
public class HibernateSessionFactory {
  private static final SessionFactory sessionFactory;

  static {
    try {
      sessionFactory = new Configuration().configure().buildSessionFactory();
    } catch (Throwable ex) {
      System.err.println("Initial SessionFactory creation failed." + ex);
      throw new ExceptionInInitializerError(ex);
    }
  }
  public static SessionFactory getSessionFactory() {
    return sessionFactory;
  }
}
