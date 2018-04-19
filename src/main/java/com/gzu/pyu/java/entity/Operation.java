package com.gzu.pyu.java.entity;

import com.alibaba.fastjson.annotation.JSONField;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.ArrayList;
import java.util.List;

public class Operation {
    @JSONField(name = "id",ordinal = 0)
    private String id;
    @JSONField(name = "name",ordinal = 1)
    private String name;
    @JSONField(name = "desc",ordinal = 2)
    private String description;
    @JSONField(name = "groups",ordinal = 3)
    private List<String> groupids=new ArrayList<>();
    @JSONField(name = "deps",ordinal = 4)
    private List<String> deps;

    private String groupid;

    @XmlElementWrapper(name = "dependents")
    @XmlElement(name="dependent")
    public List<String> getDeps()
    {
        return deps;
    }

    public void setDeps(List<String> deps)
    {
        this.deps = deps;
    }

    public List<String> getGroupids()
    {
        return groupids;
    }

    public void setGroupids(List<String> groupids)
    {
        this.groupids = groupids;
    }

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
        groupids.add(groupid);
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
