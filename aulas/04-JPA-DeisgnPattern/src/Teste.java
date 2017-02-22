import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;

import br.com.fiap.dao.impl.TimeDAOImpl;
import br.com.fiap.entity.Time;
import br.com.fiap.singleton.EntityManagerFacotorySingleton;

public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EntityManager em = EntityManagerFacotorySingleton.getInstance().createEntityManager();
		
		byte[] x = null;
		Time t = new Time(0,"teste","estadioTeste",new GregorianCalendar(2000,Calendar.JUNE,12),x);
		TimeDAOImpl tDAO = new TimeDAOImpl(em);
		tDAO.insert(t);
		System.out.println("added");
		em.close();
		
		
	}

}
