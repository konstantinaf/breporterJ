package com.breporter.reporter.api.bugs;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.breporter.reporter.api.BaseService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.uom.breporter.dto.ServiceResponseDTO;
import com.uom.breporter.dto.bug.IssueDTO;
import com.uom.breporter.service.bug.BugService;


@Component
@Path("/api/url")
public class Bugs extends BaseService {
        
    protected static final String ERROR_GET_URL = "CANNOT_READ_URL";
    protected static final String ERROR_CODES_JSON_PARSE_ERROR = "ERROR_CODES_JSON_PARSE_ERROR";
    protected static final String ERROR_CODES_IO_ERROR = "ERROR_CODES_IO_ERROR";
    
    @Autowired
    BugService bugService;

    @GET
    @Path("/getBugs/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ServiceResponseDTO getBugsFromJirs(HttpServletRequest request) throws MalformedURLException, JsonParseException, JsonMappingException, IOException {
       
    	String url = request.getParameter("url");
    	String username = request.getParameter("username");
    	String password = request.getParameter("password");
    	String projectKey = request.getParameter("projectKey"); 
        ServiceResponseDTO result = new ServiceResponseDTO();
        result.setError(false);
		result.setError_code("");
		//add try catch
		List<IssueDTO> dtoList = bugService.getBugsFromJira(url, username, password, projectKey);
		result.setData(dtoList);

        return result;
    }

}