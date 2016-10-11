package com.flp.ems.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flp.ems.service.EmployeeServiceImpl;
@WebServlet("/Hello")
public class Hello extends HttpServlet{

	private static final String ACTION_KEY = "action";
    private static final String VIEW_ALL_EMPLOYEES = "view";
    private static final String ADD_EMPLOYEE = "add";
    private static final String SAVE_EMPLOYEE = "save";
    private static final String MODIFY_EMPLOYEE = "modify";
    private static final String REMOVE_EMPLOYEE = "remove";
    static EmployeeServiceImpl service = new EmployeeServiceImpl() ;
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		processRequest(request, response);
		
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}
	public void processRequest(HttpServletRequest request, HttpServletResponse response) 
	{
		String actionName = request.getParameter(ACTION_KEY);
		if(VIEW_ALL_EMPLOYEES.equals(actionName))
        {            
			//HashMap<String,String>[] hashArray=service.getAllEmployee();
			
		
		}
        
	}

}
