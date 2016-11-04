package com.uom.breporter.service.bug.impl;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@Service("bugService")
public class BugServiceImpl implements BugService{
 
	public List<IssueDTO> getBugsFromJira(String url, String username, String password, String projectKey) {
		 List<IssueDTO> dtoList = new ArrayList<IssueDTO>();
		 final AsynchronousJiraRestClientFactory factory = new AsynchronousJiraRestClientFactory();
	        URI jiraServerUri = null;
			try {
				jiraServerUri = new URI(url);
			} catch (URISyntaxException e) {
				log.error("Syntax Exception ", e);
			}
	        final JiraRestClient restClient = factory.createWithBasicHttpAuthentication(jiraServerUri, username, password);
	        
	        try {
	        	StringBuilder sb = new StringBuilder();
	        	sb.append("project=");
	        	sb.append(projectKey);
	        	sb.append("and type=bug");

	            Iterable<Issue> issues = restClient.getSearchClient().searchJql(sb.toString()).get().getIssues();
	           
	            List<Issue> myList = Lists.newArrayList(issues);
	            
	            for (Issue issue : myList) {
	            	dtoList.add(IssueDTO.map(issue));
	            }
	        } catch (InterruptedException e) {
				log.error("Interrupted Exception : ",e);
			} catch (ExecutionException e) {
				log.error("Execution Excetion ",e);
			}
	        finally {
	            try {
					restClient.close();
				} catch (IOException e) {
					log.error("Error closing connection ",e);
				}
	        }
			return dtoList;
	}

}
