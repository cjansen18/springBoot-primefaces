package com.chrisjansen.raptor.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author a426156
 */
@Entity
@Table(name = "px_dataset_props")
@XmlRootElement

public class PxDatasetProps implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "prop_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "px_dataset_props_seq_generator")
    @SequenceGenerator(name="px_dataset_props_seq_generator", sequenceName = "px_dataset_props_seq", allocationSize = 20)
    private Integer propId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "data_set")
    private String dataSet;

    @Basic(optional = false)
    //@NotNull(message = "This propertyName may not be null")
    @Size(min = 1, max = 80)
    @Column(name = "property_name")

    private String propertyName;
    @Size(max = 5000)
    @Column(name = "property_value")
    private String propertyValue;

    @Column(name = "updateTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;

    public PxDatasetProps() {
    }

    public PxDatasetProps(Integer propId) {
        this.propId = propId;
    }

    public PxDatasetProps(Integer propId, String dataSet, String propertyName) {
        this.propId = propId;
        this.dataSet = dataSet;
        this.propertyName = propertyName;
    }

    public Integer getPropId() {
        return propId;
    }

    public void setPropId(Integer propId) {
        this.propId = propId;
    }

    public String getDataSet() {
        return dataSet;
    }

    public void setDataSet(String dataSet) {
        this.dataSet = dataSet;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getPropertyValue() {
        return propertyValue;
    }

    public void setPropertyValue(String propertyValue) {
        this.propertyValue = propertyValue;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (propId != null ? propId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PxDatasetProps)) {
            return false;
        }
        PxDatasetProps other = (PxDatasetProps) object;
        if ((this.propId == null && other.propId != null) || (this.propId != null && !this.propId.equals(other.propId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.PxDatasetProps[ propId=" + propId + " ]";
    }

}

