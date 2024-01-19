import org.junit.jupiter.api.Test;
import org.hibernate.Session;
import com.pepinho.ad.hibernate.HibernateUtil;
import com.pepinho.ad.hibernate.entities.Alumno;

public class Probas {


    @Test
    public void test() {
        System.out.println("Hello and welcome!");
        for (int i = 1; i <= 5; i++) {
            System.out.println("i = " + i);
        }
    }


    @Test
    public void insertAlumnno() {
        Alumno alumno = new Alumno("Pepe", "Calo", 20, "Calle de la piruleta");
        Alumno alumno2 = new Alumno("Manolo", "Morán", 18, "San Clemente");
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.persist(alumno);
        session.persist(alumno2);
        session.getTransaction().commit();
        System.out.println(alumno);
    }
}
