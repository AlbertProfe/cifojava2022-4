import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;


public class StudentDAOTest {

    @Test
    public void testPersistStudent(){

        //create a manager to do all the CRUD operations with student object
        //i can create manager cause I created JPAUtils
        EntityManager manager = JPAUtils.getEntityManger();
        //manager call Transaction, that is, it is a state to persist
        EntityTransaction transaction = manager.getTransaction();
        //let s start with begin the operations, thanks to transaction object
        transaction.begin();

        //Student studentCreated =new Student(1,"Alex", "Pixel", 25, "alex@helsinki.uni");
        Student studentCreated =new Student(2,"Ricard", "Jones", 15, "ricki@helsinki.uni");
        //prepares the operation to be done
        manager.persist(studentCreated);
        //this operation WRITES the object on the actual table
        transaction.commit();
        manager.close();
    }

}
