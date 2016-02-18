package com.chrisjansen.raptor;

import com.chrisjansen.raptor.domain.PxAttribute;
import com.chrisjansen.raptor.repo.PxAttributeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Chris Jansen on 2/18/2016.
 */
@ActiveProfiles("h2InMem")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {AdmEditorApplication.class})
public class PxDatasetPropsTest {

    @Resource
    private PxAttributeRepository pxAttributeRepository;

    @Test
    public void findPxAttributeRecords(){
       Iterable<PxAttribute> pxAttributes=pxAttributeRepository.findAll();
        assertThat(pxAttributes).isNotEmpty();
    }
}
