package ar.com.marcos;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class TestSessionBean
 */
@Stateless
@LocalBean
public class TestSessionBean {

    /**
     * Default constructor. 
     */
    public TestSessionBean() {
        // TODO Auto-generated constructor stub
    }
    
    public String getRegard(){
    	return "Hi I'm a session bean";
    }

}
