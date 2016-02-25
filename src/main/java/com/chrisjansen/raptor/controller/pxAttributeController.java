package com.chrisjansen.raptor.controller;

import com.chrisjansen.raptor.domain.PxAttribute;
import com.chrisjansen.raptor.service.PxAttributeService;
import com.google.common.collect.Lists;
import org.primefaces.event.FlowEvent;
import org.primefaces.event.RowEditEvent;
import org.springframework.stereotype.Component;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by Chris Jansen on 2/22/2016.
 */
@Component("pxAttributeController")
@ViewScoped
public class PxAttributeController implements Serializable{

    @Resource
    private PxAttributeService pxAttributeService;

    private List<PxAttribute> pxAttributeList;

    private List<PxAttribute> filteredPxAttributeList;
    private List<PxAttribute>  selectedPxAttributes;
    private List<PxAttribute>  selectedPxAttributesForSoftDelete=new ArrayList<PxAttribute>();
    private List<PxAttribute> editedExistingPxAttributes=new ArrayList<PxAttribute>();

    private PxAttribute newPxAttribute=new PxAttribute();



    private String newDataSetName;

    @PostConstruct
    public void init() {
        this.pxAttributeList= Lists.newArrayList(pxAttributeService.findAll());
    }


    public void onRowCancel(RowEditEvent event){
        PxAttribute editedPxAttribute=((PxAttribute) event.getObject());
        editedExistingPxAttributes.remove(editedPxAttribute);

        FacesMessage msg = new FacesMessage("PxAttribute Edit Removed", editedPxAttribute.getId().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowEdit(RowEditEvent event){
        PxAttribute editedPxAttribute=((PxAttribute) event.getObject());
        editedExistingPxAttributes.add(editedPxAttribute);

        FacesMessage msg = new FacesMessage("PxAttribute Edited", editedPxAttribute.getId().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public String resetNewDataSetName(FlowEvent flowEvent){
        this.newDataSetName=null;
        return flowEvent.getNewStep();
    }


    public void refreshList(ActionEvent actionEvent){
        init();
    }

    public boolean filterByPrice(Object value, Object filter, Locale locale) {
        String filterText = (filter == null) ? null : filter.toString().trim();
        if(filterText == null||filterText.equals("")) {
            return true;
        }

        if(value == null) {
            return false;
        }

        return ((Comparable) value).compareTo(Integer.valueOf(filterText)) > 0;
    }

    public void saveList(ActionEvent actionEvent){
        pxAttributeService.save(editedExistingPxAttributes);
        editedExistingPxAttributes.clear();

        FacesMessage msg = new FacesMessage("Editing PxAttributes are saved!", null);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void saveListAsNew(ActionEvent actionEvent){

        if(newDataSetName!=null)
        {
            for (PxAttribute pxAttribute:selectedPxAttributes){
                pxAttribute.setDataSet(newDataSetName);
                pxAttribute.setId(null);
            }
        }

        selectedPxAttributes=Lists.newArrayList(pxAttributeService.save(selectedPxAttributes));

        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "PxAttribute records saved to database!",  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }


    public void doSoftDelete(ActionEvent actionEvent){
        selectedPxAttributes.removeAll(selectedPxAttributesForSoftDelete);
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Records deleted from Table!",  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void addToSelectedAttributeList(ActionEvent actionEvent){
        selectedPxAttributes.add(newPxAttribute);

        newPxAttribute=new PxAttribute();
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "New PxAttribute row added to Table!",  null);
        FacesContext.getCurrentInstance().addMessage(null, message);

    }

    public List<SelectItem> getTypes(){
        return pxAttributeService.getDataTypes();
    }

    public List<PxAttribute> getPxAttributeList() {
        return pxAttributeList;
    }

    public void setPxAttributeList(List<PxAttribute> pxAttributeList) {
        this.pxAttributeList = pxAttributeList;
    }

    public List<PxAttribute> getFilteredPxAttributeList() {
        return filteredPxAttributeList;
    }

    public void setFilteredPxAttributeList(List<PxAttribute> filteredPxAttributeList) {
        this.filteredPxAttributeList = filteredPxAttributeList;
    }

    public List<PxAttribute> getSelectedPxAttributes() {
        return selectedPxAttributes;
    }

    public void setSelectedPxAttributes(List<PxAttribute> selectedPxAttribute) {
        this.selectedPxAttributes = selectedPxAttribute;
    }

    public String getNewDataSetName() {
        return newDataSetName;
    }

    public void setNewDataSetName(String newDataSetName) {
        this.newDataSetName = newDataSetName;
    }

    public PxAttribute getNewPxAttribute() {
        return newPxAttribute;
    }

    public void setNewPxAttribute(PxAttribute newPxAttribute) {
        this.newPxAttribute = newPxAttribute;
    }

    public List<PxAttribute> getSelectedPxAttributesForSoftDelete() {
        return selectedPxAttributesForSoftDelete;
    }

    public void setSelectedPxAttributesForSoftDelete(List<PxAttribute> selectedPxAttributesForSoftDelete) {
        this.selectedPxAttributesForSoftDelete = selectedPxAttributesForSoftDelete;
    }
}
