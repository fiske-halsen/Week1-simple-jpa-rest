package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.EmployeeDTO;
import entities.Employee;
import facades.EmployeeFacade;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("employee")
public class EmployeeResource {

    private static Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
    EmployeeFacade facade = EmployeeFacade.getEmployeeFacade(emf);

    //NOTE: Change Persistence unit name according to your setup
    @GET
    @Path("all")
    @Produces({MediaType.APPLICATION_JSON})
    public String demo1() {
        
        List<Employee> listOfEmployees = facade.getAllEmployees();
        
        List<EmployeeDTO> listOfEmployeeDto = new ArrayList();
        
        
        for (Employee employee : listOfEmployees) {
            
            listOfEmployeeDto.add(new EmployeeDTO(employee));
            
        }
        
        return GSON.toJson(listOfEmployeeDto);
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(Employee entity) {
        throw new UnsupportedOperationException();
    }

    
   
    
    
@Path("{id}")
@GET
@Produces(MediaType.APPLICATION_JSON)
public String getEmployeeById(@PathParam("id") int id) {
    
      EmployeeDTO employee = new EmployeeDTO(facade.getEmployeeById(id));
       
       return GSON.toJson(employee);
  //Hvis den kaldes med .../animalbyid/2  vil id nu være lig 2.
  //Den værdi kan I så benytte til at slå op i databasen med em.find(

    
    
}
    
     @GET
    @Path("highestpaid")
    @Produces({MediaType.APPLICATION_JSON})
    public String demo2() {
        
       List<Employee> listOfEmployees = facade.getEmployeesWithHighestSalary();
        
        List<EmployeeDTO> listOfEmployeeDto = new ArrayList();
        
        
        for (Employee employee : listOfEmployees) {
            
            listOfEmployeeDto.add(new EmployeeDTO(employee));
            
        }
        
        return GSON.toJson(listOfEmployeeDto);
    }
    
 @Path("employeename/{name}")
@GET
@Produces(MediaType.APPLICATION_JSON)
public String getEmployeesByname(@PathParam("name") String name) {
    
      List<Employee> listOfEmployees = facade.getEmployeesByName(name);
        
        List<EmployeeDTO> listOfEmployeeDto = new ArrayList();
        
        
        for (Employee employee : listOfEmployees) {
            
            listOfEmployeeDto.add(new EmployeeDTO(employee));
            
        }
        
        return GSON.toJson(listOfEmployeeDto);
 
    
}
    
    
    
    
    
    

}
