package com.chrisjansen.raptor.repo;

import com.chrisjansen.raptor.domain.PxDatasetProps;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Chris Jansen on 2/18/2016.
 */
@Transactional
public interface PxDatasetPropsRepository  extends CrudRepository<PxDatasetProps, Long> {
}
