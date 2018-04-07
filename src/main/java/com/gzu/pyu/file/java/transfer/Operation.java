package com.gzu.pyu.file.java.transfer;

import javax.xml.bind.annotation.XmlElement;

public class Operation {
    private String id;
    private String name;
    private String description;
    private String groupid;

    public Operation() {
    }
    public Operation(String id, String name, String description, String groupid) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.groupid = groupid;
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
    @XmlElement(name="groupid")
    public String getGroupid() {
        return groupid;
    }

    public void setGroupid(String groupid) {
        this.groupid = groupid;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Operation{");
        sb.append("id='").append(id).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", groupid='").append(groupid).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
