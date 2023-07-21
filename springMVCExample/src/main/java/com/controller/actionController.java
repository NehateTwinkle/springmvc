package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dao.springdao;
import com.model.employeemodel;



@Controller
public class actionController {

	@Autowired
	employeemodel emodel;
	@Autowired
	springdao dao;
	@RequestMapping("/addemployee")
	public String show(Model m)
	{
		m.addAttribute("command",new employeemodel());
		return "addemployee";
	}
	@RequestMapping(value = "/save",method = RequestMethod.POST)
	public String save(@ModelAttribute("emp") employeemodel emp)
	{
		dao.save(emp);
		return "redirect:/viewemployee";
		
	}
	
	  @RequestMapping("/viewemployee")    
	    public String viewemployee(Model m){    
	        List<employeemodel> list=dao.getEmployees();    
	        m.addAttribute("list",list);  
	        return "viewemployee";    
	    }    
	  
	  @RequestMapping(value="/editemp/{id}")    
	    public String edit(@PathVariable int id, Model m){    
	        employeemodel emp=dao.getEmpById(id);    
	        m.addAttribute("command",emp);  
	        return "empeditform";    
	    }  
	  
	  @RequestMapping(value="/editsave",method = RequestMethod.POST)    
	    public String editsave(@ModelAttribute("emp") employeemodel emp){    
	        dao.update(emp);    
	        return "redirect:/viewemployee";    
	    }    
	       
	    @RequestMapping(value="/deleteemp/{id}",method = RequestMethod.GET)    
	    public String delete(@PathVariable int id){    
	        dao.delete(id);    
	        return "redirect:/viewemployee";    
	    }     
	  
	  
}
