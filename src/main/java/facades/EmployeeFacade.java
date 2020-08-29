package facades;

import entities.Employee;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class EmployeeFacade {

    private static EmployeeFacade instance;
    private static EntityManagerFactory emf;

    //Private Constructor to ensure Singleton
    private EmployeeFacade() {
    }

    /**
     *
     * @param _emf
     * @return an instance of this facade class.
     */
    public static EmployeeFacade getEmployeeFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new EmployeeFacade();
        }
        return instance;
    }

    public Employee getEmployeeById(int id) {

        EntityManager em = emf.createEntityManager();

        try {
            Employee employee = em.find(Employee.class, (long) id);
            

            return employee;
        } finally {

            em.close();

        }
    }

public List<Employee> getEmployeesByName(String name) {
        EntityManager em = emf.createEntityManager();

        try {
            TypedQuery<Employee> query = em.createQuery("Select e FROM Employee e where e.name = :name", Employee.class);
            query.setParameter("name", name);
            return query.getResultList();

        } finally {
            em.close();
        }

    }

    public List<Employee> getAllEmployees() {

        EntityManager em = emf.createEntityManager();

        try {

            TypedQuery<Employee> query = em.createQuery("Select e from Employee e", Employee.class);

            List<Employee> listOfEmployees = query.getResultList();

            return listOfEmployees;
        } finally {

            em.close();

        }
    }

   public List<Employee> getEmployeesWithHighestSalary() {
        EntityManager em = emf.createEntityManager();
        try {
            Query query6 = em.createQuery("SELECT e FROM Employee e WHERE e.salary = (SELECT MAX(e.salary) FROM Employee e)");
            List employeeSalary = query6.getResultList();

            return employeeSalary;
        } finally {
            em.close();
        }
    }

    public Employee createEmployee(String name, String adress, int salary) {

        Employee employee = new Employee(name, adress, salary);
        EntityManager em = emf.createEntityManager();

        try {

            em.getTransaction().begin();
            em.persist(employee);
            em.getTransaction().commit();

            return employee;
        } finally {

            em.close();

        }
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    
    public static void main(String[] args) {
        
        EntityManagerFactory  emf = Persistence.createEntityManagerFactory("pu"); 
        
        EmployeeFacade ef = EmployeeFacade.getEmployeeFacade(emf);
        
        ef.createEmployee("Phillip", "Tornehegnet 7", 200000);
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
    
    
    
    
    
    
    

}
