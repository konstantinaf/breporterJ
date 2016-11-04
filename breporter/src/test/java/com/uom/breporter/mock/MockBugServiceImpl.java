package com.uom.breporter.mock;

import com.uom.breporter.dto.bug.IssueDTO;
import com.uom.breporter.service.bug.BugService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by fotarik on 04/11/2016.
 */
public class MockBugServiceImpl implements BugService {

    @Autowired
    MockResponseFactory responseFactory;

    @Override
    public List<IssueDTO> getBugsFromJira(String url, String username, String password, String projectKey) {
        InputStream is = this.responseFactory.getMockInputStream("ActiveDepotsRS");
        IssueDTO activeDepotsRSDTO = new IssueDTO();
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(IssueDTO.class);
            activeDepotsRSDTO = (IssueDTO) jaxbContext.createUnmarshaller().unmarshal(is);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
}
