import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class JPAUtils {

    public static EntityManagerFactory emf = createEntityManagerFactory();

    private static EntityManagerFactory createEntityManagerFactory(){
        //creates with persistence a entity manager factory with UNIT PERSISTENCE "mysql-jpa-student"
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql-jpa-student");
        return emf;

    }

    public static EntityManager getEntityManger(){
        //with entity manager factory creates a ENTITY MANAGER
        EntityManager entityManager = emf.createEntityManager();
        return entityManager;

    }
}
