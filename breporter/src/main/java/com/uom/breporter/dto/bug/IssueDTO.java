/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.uom.breporter.dto.bug;

import java.io.Serializable;
import java.util.List;

import com.atlassian.jira.rest.client.api.domain.Issue;
import com.atlassian.jira.rest.client.api.domain.IssueField;
import com.atlassian.jira.rest.client.api.domain.Version;

/**
 * DTO data transfer object
 *
 * @author ntinaki2f
 */
public class IssueDTO implements Serializable {

    private static final long serialVersionUID = 909175842420638051L;

    private Long id;
    private List<IssueField> issueFields;
 	private Iterable<Version> affectedVersions;
    private Iterable<Version> fixVersions;
   
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<IssueField> getIssueFields() {
		return issueFields;
	}

	public void setIssueFields(List<IssueField> issueFields) {
		this.issueFields = issueFields;
	}

	public Iterable<Version> getAffectedVersions() {
		return affectedVersions;
	}

	public void setAffectedVersions(Iterable<Version> affectedVersions) {
		this.affectedVersions = affectedVersions;
	}

	public Iterable<Version> getFixVersions() {
		return fixVersions;
	}

	public void setFixVersions(Iterable<Version> fixVersions) {
		this.fixVersions = fixVersions;
	}

	public static IssueDTO map(Issue issue) {
    	IssueDTO dto = new IssueDTO();
        if (issue != null) {

            dto.setId(issue.getId());
            dto.setAffectedVersions(issue.getAffectedVersions());
            dto.setFixVersions(issue.getFixVersions());
        }

        return dto;
    }
}
