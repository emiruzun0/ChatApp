import javax.persistence.*;


public class DbOperations {
    static EntityManagerFactory factory;
    static EntityManager entityManager;

    private synchronized static void begin() {
        factory = Persistence.createEntityManagerFactory("MessageUnit");
        entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();
    }

    private synchronized static void add(Message message) {
        entityManager.persist(message);
    }

    private synchronized static void end() {
        entityManager.getTransaction().commit();

        entityManager.close();
        factory.close();
    }

    public synchronized static void addToDb(Message m) {
        begin();
        add(m);
        end();
    }
}


