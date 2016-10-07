package com.cg;

import java.io.IOException;
import java.lang.Exception;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cg.dao.CarDAO;
import com.cg.dao.impl.JDBCCarDAO;
import com.cg.dto.CarDTO;
import com.cg.util.DBUtility;

//TODO 1 Import appropriate classes

//Follow TODOs (if available)
/**
 * 
 * This is a ControllerServlet class
 * @see java.lang.Object
 * @author Abhishek
 * 
 *
 */

public class ControllerServlet extends HttpServlet
{
    private static final String ACTION_KEY = "action";
    private static final String VIEW_CAR_LIST_ACTION = "viewCarList";
    private static final String ADD_CAR_ACTION = "addCar";
    private static final String SAVE_CAR_ACTION = "saveCar";
    private static final String EDIT_CAR_ACTION = "editCar";
    private static final String DELETE_CAR_ACTION = "deleteCar";
    private static final String ERROR_KEY = "errorMessage";

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
		
    	processRequest(request, response);
    		}

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        //TODO 3 Invoke processRequest
    	processRequest(request, response);
    }

    /**
     * This method will process request based on action performed on screen. 
     * @param request				HttpServletRequest
     * @param response				HttpServletResponse
     * @throws ServletException		if error occurs
     * @throws IOException			if error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String actionName = request.getParameter(ACTION_KEY);
        String destinationPage = null; 
        CarDAO carDAO = DBUtility.getCarDAO();
        
        // perform action
        if(VIEW_CAR_LIST_ACTION.equals(actionName))
        {            
            //TODO 4 
			//Use carDao to get the list of the cars
        	request.setAttribute("carList", (JDBCCarDAO)carDAO.findAll()); ;
			//Set the list in request with attribute name as 'carList'
        	response.sendRedirect("carList.jsp");
			//Set the destination page to carList.jsp
			
        }
        else if(ADD_CAR_ACTION.equals(actionName))
        {
			//TODO 5 
        	CarDTO dto=new CarDTO() ;
        	request.setAttribute("car", dto);
        	response.sendRedirect("carForm.jsp");
			//Create a new CarDTO and set in request with attribute name as 'car'
        	response.sendRedirect("carForm.jsp");
			//Set the destination page to carForm.jsp
            
        }  
        else if(EDIT_CAR_ACTION.equals(actionName))
        {
			//TODO 6 
			//Get the car id from request, with parameter name as 'id'
        	int id=Integer.parseInt(request.getParameter("id")) ;
        	CarDTO car=carDAO.findById(id) ;
        	carDAO.update(car);
   
			//Find the respective car (CarDTO) from carDAO using appropriate API of DAO
			//Set the found car in request with name as 'car'
        	request.setAttribute("car", car);
			//Set the destination page to carForm.jsp
        	response.sendRedirect("carForm.jsp");
            
        }        
        else if(SAVE_CAR_ACTION.equals(actionName))
        {
			//TODO 7 
			//Create a new CarDTO
        	CarDTO car=new CarDTO() ;
			//set the properties of the DTO from request parameters
        	car.setId(Integer.parseInt(request.getParameter("id"))) ;
        	car.setMake(request.getParameter("make")) ;
        	car.setModel(request.getParameter("model")) ;
        	car.setModelYear(request.getParameter("modelyear"));
        	//If it is a new car then invoke create api of DAO else update api                                                
        	if(carDAO.findById(Integer.parseInt(request.getParameter("id")))==null)
        	{
        		carDAO.create(car);
        	}
        	else
        	{
        		carDAO.update(car);
        	}
			
			//Get all the Cars using DAO
        	request.setAttribute("carList", carDAO.findAll()) ;
			//Set the found cars in request with name as 'carList'
			//Set the destination page to carList.jsp
        	response.sendRedirect("carList.jsp");
			
            
        }  
        else if(DELETE_CAR_ACTION.equals(actionName))
        {
            //TODO 8 
			//Get the ids of all cars to be deleted from request
        	String []ids=request.getParameterValues("id") ;
        	//Use appropriate api of DAO to delete all cars 
        	carDAO.delete(ids);
			
			//Get all the Cars using DAO
        	request.setAttribute("carList", carDAO.findAll() ) ;
			//Set the found cars in request with name as 'carList'
        	response.sendRedirect("carList.jsp");
			//Set the destination page to carList.jsp
            
        }                    
        else
        {
            String errorMessage = "[" + actionName + "] is not a valid action.";
            request.setAttribute(ERROR_KEY, errorMessage);
        }


        //TODO 9 Use appropriate Servlet API to forward the request to 
		//appropriate destination page set in above if else blocks depending on action.
        
    }
}
