/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.Employee;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import static org.hamcrest.Matchers.hasSize;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

/**
 *
 * @author phill
 */
public class EmployeeFacadeTest {

    private static EntityManagerFactory emf;

    public EmployeeFacadeTest() {

    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getFacadeExample method, of class EmployeeFacade.
     */
    @Test
    public void testGetFacadeExample() {

    }

    /**
     * Test of getEmployeeById method, of class EmployeeFacade.
     */
    @Test
    public void testGetEmployeeById() {

        emf = Persistence.createEntityManagerFactory("pu");

        EmployeeFacade ef = EmployeeFacade.getEmployeeFacade(emf);

        long id = 11;

        //Employee employee = ef.getEmployeeById((int) id);

       // assertEquals(id, (long) employee.getId());
    }

    /**
     * Test of getEmployeeByName method, of class EmployeeFacade.
     */
    @Test
    public void testGetEmployeesByName() {

        emf = Persistence.createEntityManagerFactory("pu");

        EmployeeFacade ef = EmployeeFacade.getEmployeeFacade(emf);

        List<Employee> listOfEmployees = ef.getEmployeesByName("Hej");
        
        //assertThat(listOfEmployees, hasSize(1));
        
    }

    /**
     * Test of getAllEmployees method, of class EmployeeFacade.
     */
    @Test
    public void testGetAllEmployees() {
        
        emf = Persistence.createEntityManagerFactory("pu");
        EmployeeFacade ef = EmployeeFacade.getEmployeeFacade(emf);
        List<Employee> listOfEmployees = ef.getAllEmployees();
        
         //assertThat(listOfEmployees, hasSize(1));        

    }

    /**
     * Test of getEmployeeWithHighestSalary method, of class EmployeeFacade.
     */
    @Test
    public void testGetEmployeesWithHighestSalary() {
        
        emf = Persistence.createEntityManagerFactory("pu");
        EmployeeFacade ef = EmployeeFacade.getEmployeeFacade(emf);
        
        List<Employee> listOfEmployees = ef.getEmployeesWithHighestSalary();
        
       
        
        //assertThat(listOfEmployees, hasSize(1));
        
    }

    /**
     * Test of createEmployee method, of class EmployeeFacade.
     */
    @Test
    public void testCreateEmployee() {
        
          emf = Persistence.createEntityManagerFactory("pu");
          EmployeeFacade ef = EmployeeFacade.getEmployeeFacade(emf);
          
         // ef.createEmployee("Hej", "hej", 1000);
        

    }

}
