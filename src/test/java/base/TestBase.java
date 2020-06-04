package base;


import groovy.util.logging.Log4j;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.log4j.BasicConfigurator;
import org.junit.Before;
import org.junit.BeforeClass;
import org.testng.ReporterConfig;


import org.apache.log4j.Level;
import org.apache.log4j.Logger;

//import java.util.logging.Logger;


public class TestBase {

    public static RequestSpecification httpRequest;
    public static Response response;
    public String ID = "";

    public static Logger logger;

    @BeforeClass
    public void setUp(){
         logger = Logger.getLogger("");
          BasicConfigurator.configure();
        //logger.setLevel(Level.DEBUG);
         //BasicConfigurator.configure(); // added logger
//        logger.setLevel(Level.DEBUG);
    }


    // creating a a class for testing



}
