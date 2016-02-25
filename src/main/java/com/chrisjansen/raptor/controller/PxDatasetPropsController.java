package com.chrisjansen.raptor.controller;

import com.chrisjansen.raptor.domain.PxDatasetProps;
import com.chrisjansen.raptor.service.PxDatasetPropsService;
import com.google.common.collect.Lists;
import org.primefaces.event.FlowEvent;
import org.primefaces.event.RowEditEvent;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by Chris Jansen on 2/22/2016.
 */
@Component("pxDatasetPropsController")
@ViewScoped
public class PxDatasetPropsController implements Serializable{

    @Resource
    private PxDatasetPropsService pxDatasetPropsService;

    private List<PxDatasetProps> pxDatasetPropsList;

    private List<PxDatasetProps> filteredPxDatasetPropsList;
    private List<PxDatasetProps>  selectedPxDatasetProps;
    private List<PxDatasetProps>  selectedPxDatasetPropsForSoftDelete=new ArrayList<PxDatasetProps>();
    private List<PxDatasetProps> editedExistingPxDatasetProps=new ArrayList<PxDatasetProps>();

    private PxDatasetProps newPxDatasetProps=new PxDatasetProps();



    private String newDataSetName;

    @PostConstruct
    public void init() {
        this.pxDatasetPropsList = Lists.newArrayList(pxDatasetPropsService.findAll());
    }


    public void onRowCancel(RowEditEvent event){
        PxDatasetProps editedPxDatasetProps=((PxDatasetProps) event.getObject());
        editedExistingPxDatasetProps.remove(editedPxDatasetProps);

        FacesMessage msg = new FacesMessage("PxDatasetProps Edit Removed", editedPxDatasetProps.getPropId().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowEdit(RowEditEvent event){
        PxDatasetProps editedPxDatasetProps=((PxDatasetProps) event.getObject());
        editedExistingPxDatasetProps.add(editedPxDatasetProps);

        FacesMessage msg = new FacesMessage("PxDatasetProps Edited", editedPxDatasetProps.getPropId().toString());
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
        pxDatasetPropsService.save(editedExistingPxDatasetProps);
        editedExistingPxDatasetProps.clear();

        FacesMessage msg = new FacesMessage("Editing PxDatasetProps are saved!", null);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void saveListAsNew(ActionEvent actionEvent){

        if(newDataSetName!=null)
        {
            for (PxDatasetProps PxDatasetProps:selectedPxDatasetProps){
                PxDatasetProps.setDataSet(newDataSetName);
                PxDatasetProps.setPropId(null);
            }
        }

        selectedPxDatasetProps=Lists.newArrayList(pxDatasetPropsService.save(selectedPxDatasetProps));

        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "PxDatasetProps records saved to database!",  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }


    public void doSoftDelete(ActionEvent actionEvent){
        selectedPxDatasetProps.removeAll(selectedPxDatasetPropsForSoftDelete);
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Records deleted from Table!",  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void addToSelectedDatasetPropsTable(ActionEvent actionEvent){
        selectedPxDatasetProps.add(newPxDatasetProps);

        newPxDatasetProps=new PxDatasetProps();
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "New PxDatasetProps row added to Table!",  null);
        FacesContext.getCurrentInstance().addMessage(null, message);

    }
    
    public List<PxDatasetProps> getPxDatasetPropsList() {
        return pxDatasetPropsList;
    }

    public void setPxDatasetPropsList(List<PxDatasetProps> PxDatasetPropsList) {
        this.pxDatasetPropsList = PxDatasetPropsList;
    }

    public List<PxDatasetProps> getFilteredPxDatasetPropsList() {
        return filteredPxDatasetPropsList;
    }

    public void setFilteredPxDatasetPropsList(List<PxDatasetProps> filteredPxDatasetPropsList) {
        this.filteredPxDatasetPropsList = filteredPxDatasetPropsList;
    }

    public List<PxDatasetProps> getSelectedPxDatasetProps() {
        return selectedPxDatasetProps;
    }

    public void setSelectedPxDatasetProps(List<PxDatasetProps> selectedPxDatasetProps) {
        this.selectedPxDatasetProps = selectedPxDatasetProps;
    }

    public String getNewDataSetName() {
        return newDataSetName;
    }

    public void setNewDataSetName(String newDataSetName) {

        this.newDataSetName = newDataSetName;
    }

    public PxDatasetProps getNewPxDatasetProps() {
        return newPxDatasetProps;
    }

    public void setNewPxDatasetProps(PxDatasetProps newPxDatasetProps) {
        this.newPxDatasetProps = newPxDatasetProps;
    }

    public List<PxDatasetProps> getSelectedPxDatasetPropsForSoftDelete() {
        return selectedPxDatasetPropsForSoftDelete;
    }

    public void setSelectedPxDatasetPropsForSoftDelete(List<PxDatasetProps> selectedPxDatasetPropsForSoftDelete) {
        this.selectedPxDatasetPropsForSoftDelete = selectedPxDatasetPropsForSoftDelete;
    }
}
