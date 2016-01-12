/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.uom.breporter.service.bug;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.uom.breporter.dto.bug.IssueDTO;

/**
 *
 * @author ntinaki2f
 */
public class BugServiceTest {

    @Autowired
    BugService bugService;

    public BugServiceTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }
  
    @Transactional
    @Test
    public void testGetListForBuildingGrid() {
        String url = "https://konstantinauom.atlassian.net/";
        String username = "admin";
        String password = "6988190541NTIna";
        String projectKey = "COOK";
        
        
        List<IssueDTO> dtoList = bugService.getBugsFromJira(url, username, password, projectKey);
        
        assertEquals(dtoList.get(0).getFixVersions(), null);
    }

}
