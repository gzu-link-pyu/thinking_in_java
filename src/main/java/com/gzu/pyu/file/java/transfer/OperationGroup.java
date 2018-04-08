package com.gzu.pyu.file.java.transfer;

import com.alibaba.fastjson.annotation.JSONField;

import javax.xml.bind.annotation.XmlElement;

public class OperationGroup {
    @JSONField(name = "id",ordinal = 0)
    private String id;
    @JSONField(name = "name",ordinal = 1)
    private String name;
    @JSONField(name = "desc",ordinal = 2)
    private String description;

    public OperationGroup() {
    }

    public OperationGroup(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
    @XmlElement(name="id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    @XmlElement(name="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @XmlElement(name="description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("OperationGroup{");
        sb.append("id='").append(id).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
