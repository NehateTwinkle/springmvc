package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.model.employeemodel;

public class springdao {
	JdbcTemplate jt;

	public JdbcTemplate getJt() {
		return jt;
	}

	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}
	
	
	public int save(employeemodel p)
	{
		String sql="insert into employee(name,salary,desg) values('"+p.getName()+"',"+p.getSalary()+",'"+p.getDesg()+"')";
		return jt.update(sql);
	}
	
	public List<employeemodel> getEmployees(){    
	    return jt.query("select * from employee",new RowMapper<employeemodel>(){    
	        public employeemodel mapRow(ResultSet rs, int row) throws SQLException {    
	            employeemodel e=new employeemodel();    
	            e.setId(rs.getInt(1));    
	            e.setName(rs.getString(2));    
	            e.setSalary(rs.getString(3));    
	            e.setDesg(rs.getString(4));    
	            return e;    
	        }    
	    });    

}
	public employeemodel getEmpById(int id){    
	    String sql="select * from employee where id=?";    
	    return jt.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<employeemodel>(employeemodel.class));    
	}  	
	
	public int update(employeemodel p){    
	    String sql="update employee set name='"+p.getName()+"', salary='"+p.getSalary()+"',desg='"+p.getDesg()+"' where id="+p.getId()+"";    
	    return jt.update(sql);    
	}    
	public int delete(int id){    
	    String sql="delete from employee where id="+id+"";    
	    return jt.update(sql);    
	}    
	
	
	
	
	
	
}
