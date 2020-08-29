/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entities.Employee;

/**
 *
 * @author phill
 */
public class EmployeeDTO {
    
    private long id;
    private String name;
    private String adress;
    
    
    public EmployeeDTO(Employee employee){
        
        this.id = employee.getId();
        this.name = employee.getName();
        this.adress = employee.getAdress();
        
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
