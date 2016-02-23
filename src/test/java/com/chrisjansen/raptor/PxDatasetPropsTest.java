package com.chrisjansen.raptor;

import com.chrisjansen.raptor.domain.PxAttribute;
import com.chrisjansen.raptor.domain.PxDatasetProps;
import com.chrisjansen.raptor.repo.PxAttributeRepository;
import com.chrisjansen.raptor.repo.PxDatasetPropsRepository;
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
    private PxDatasetPropsRepository pxDatasetPropsRepository;

    @Test
    public void findDatasetRecordsRecordsFindAll(){
       Iterable<PxDatasetProps> pxDatasetPropses=pxDatasetPropsRepository.findAll();
        assertThat(pxDatasetPropses).isNotEmpty();
    }
}
