package com.chrisjansen.raptor.domain;


import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author a426156
 */
@Entity
@Table(name = "px_attribute")
@XmlRootElement

public class PxAttribute implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 64)
    @Column(name = "data_set")
    private String dataSet;
    @Size(max = 64)
    @Column(name = "display_name")
    private String displayName;
    @Size(max = 256)
    @Column(name = "source_name")
    private String sourceName;
    @Size(max = 32)
    @Column(name = "type")
    private String type;
    @Size(max = 80)
    @Column(name = "format")
    private String format;
    @Column(name = "col_size")
    private Integer colSize;
    @Size(max = 32)
    @Column(name = "group_action")
    private String groupAction;
    @Size(max = 5)
    @Column(name = "col_visible")
    private String colVisible;
    @Size(max = 256)
    @Column(name = "px_attr_name")
    private String pxAttrName;
    @Column(name = "updateTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;
    @Size(max = 1000)
    @Column(name = "formula")
    private String formula;
    @Size(max = 32)
    @Column(name = "historic")
    private String historic;

    public PxAttribute() {
    }

    public PxAttribute(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDataSet() {
        return dataSet;
    }

    public void setDataSet(String dataSet) {
        this.dataSet = dataSet;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public Integer getColSize() {
        return colSize;
    }

    public void setColSize(Integer colSize) {
        this.colSize = colSize;
    }

    public String getGroupAction() {
        return groupAction;
    }

    public void setGroupAction(String groupAction) {
        this.groupAction = groupAction;
    }

    public String getColVisible() {
        return colVisible;
    }

    public void setColVisible(String colVisible) {
        this.colVisible = colVisible;
    }

    public String getPxAttrName() {
        return pxAttrName;
    }

    public void setPxAttrName(String pxAttrName) {
        this.pxAttrName = pxAttrName;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public String getHistoric() {
        return historic;
    }

    public void setHistoric(String historic) {
        this.historic = historic;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PxAttribute)) {
            return false;
        }
        PxAttribute other = (PxAttribute) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.PxAttribute[ id=" + id + " ]";
    }

}

