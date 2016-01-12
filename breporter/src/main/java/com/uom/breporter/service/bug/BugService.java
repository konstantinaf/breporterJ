package com.uom.breporter.service.bug;

import java.util.List;

import com.uom.breporter.dto.bug.IssueDTO;


/**
 * Business logic for users management
 * 
 * @author ntinakif89
 */
public interface BugService {

	List<IssueDTO> getBugsFromJira(String url, String username, String password, String projectKey);
}
