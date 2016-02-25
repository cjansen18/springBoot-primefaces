package com.chrisjansen.raptor.service;

import com.chrisjansen.raptor.domain.PxAttribute;
import com.chrisjansen.raptor.repo.PxAttributeRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.faces.model.SelectItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Chris Jansen on 2/22/2016.
 */
@Service
public class PxAttributeService {

    @Resource
    private PxAttributeRepository pxAttributeRepository;

    private List<SelectItem> dataTypes=new ArrayList<SelectItem>();

    public Iterable<PxAttribute> save(Iterable<PxAttribute> pxAttributes){
        return pxAttributeRepository.save(pxAttributes);
    }

    public PxAttributeService() {
        this.dataTypes.add(0,new SelectItem("java.lang.Boolean" ));
        this.dataTypes.add(1,new SelectItem("java.lang.Double" ));
        this.dataTypes.add(2,new SelectItem("java.lang.Integer" ));
        this.dataTypes.add(3,new SelectItem("java.lang.String" ));
        this.dataTypes.add(4,new SelectItem("java.util.ArrayList") );
        this.dataTypes.add(5,new SelectItem("java.util.Date" ));
    }

    public Iterable<PxAttribute> findAll(){
        Iterable<PxAttribute> pxAttributes=
                pxAttributeRepository.findAll();
        return pxAttributes;
    }

    public List<SelectItem> getDataTypes() {
        return dataTypes;
    }

    public void setDataTypes(List<SelectItem> dataTypes) {
        this.dataTypes = dataTypes;
    }
}
