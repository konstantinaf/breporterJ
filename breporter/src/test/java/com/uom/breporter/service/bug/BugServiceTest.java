/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.uom.breporter.service.bug;

import com.uom.breporter.config.MockBReporterSpringConfig;
import com.uom.breporter.dto.bug.IssueDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 *
 * @author ntinaki2f
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MockBReporterSpringConfig.class})
public class BugServiceTest {

    @Autowired
    BugService bugService;

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
