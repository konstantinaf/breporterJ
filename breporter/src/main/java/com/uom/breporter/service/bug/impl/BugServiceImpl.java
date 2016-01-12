package com.uom.breporter.service.bug.impl;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;

import com.atlassian.jira.rest.client.api.JiraRestClient;
import com.atlassian.jira.rest.client.api.domain.Issue;
import com.atlassian.jira.rest.client.internal.async.AsynchronousJiraRestClientFactory;
import com.google.common.collect.Lists;
import com.uom.breporter.dto.bug.IssueDTO;
import com.uom.breporter.service.bug.BugService;


/**
 *
 * @author ntinaki2f
 */
@Service("bugService")
public class BugServiceImpl implements BugService{
 
	public List<IssueDTO> getBugsFromJira(String url, String username, String password, String projectKey) {
		 List<IssueDTO> dtoList = new ArrayList<IssueDTO>();
		 final AsynchronousJiraRestClientFactory factory = new AsynchronousJiraRestClientFactory();
	        URI jiraServerUri = null;
			try {
				jiraServerUri = new URI(url);
			} catch (URISyntaxException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        //put password in order to work
	        final JiraRestClient restClient = factory.createWithBasicHttpAuthentication(jiraServerUri, username, password);
	        
	        try {
	        	StringBuilder sb = new StringBuilder();
	        	sb.append("project=");
	        	sb.append(projectKey);
	        	sb.append("and type=bug");
	            //get all bugs for specific project key
	            Iterable<Issue> issues = restClient.getSearchClient().searchJql(sb.toString()).get().getIssues();
	           
	            List<Issue> myList = Lists.newArrayList(issues);
	            
	            for (Issue issue : myList) {
	            	dtoList.add(IssueDTO.map(issue));
	            }
	        } catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        finally {
	            // cleanup the restClient
	            try {
					restClient.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
			return dtoList;
	}

}
