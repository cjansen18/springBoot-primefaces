package com.chrisjansen.raptor.service;

import com.chrisjansen.raptor.domain.PxDatasetProps;
import com.chrisjansen.raptor.repo.PxDatasetPropsRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Chris Jansen on 2/25/2016.
 */
@Service
public class PxDatasetPropsService {

    @Resource
    private PxDatasetPropsRepository  pxDatasetPropsRepository;

    public Iterable<PxDatasetProps> findAll() {
        return pxDatasetPropsRepository.findAll();
    }

    public Iterable<PxDatasetProps> save(Iterable<PxDatasetProps> editedExistingPxDatasetProps) {
        return pxDatasetPropsRepository.save(editedExistingPxDatasetProps);
    }
    public void save(PxDatasetProps editedExistingPxDatasetProps) {
        pxDatasetPropsRepository.save(editedExistingPxDatasetProps);
    }
}
