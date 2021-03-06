package com.gzu.pyu.java.entity;


import com.alibaba.fastjson.annotation.JSONField;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "operations")
public class Operations {
    @JSONField(name = "groups",ordinal = 0)
    private List<OperationGroup> operationGroupList=new ArrayList<>();
    @JSONField(name = "operations",ordinal = 1)
    private List<Operation> operationList=new ArrayList<>();

    public Operations() {
    }

    public void addOperation(List<Operation> operationList)
    {
        this.operationList.addAll(operationList);
    }

    public void addGroup(List<OperationGroup> operationGroupList)
    {
        this.operationGroupList.addAll(operationGroupList);
    }

    public Operations(List<OperationGroup> operationGroupList, List<Operation> operationList) {
        this.operationGroupList = operationGroupList;
        this.operationList = operationList;
    }

    @XmlElement(name = "operationgroup")
    public List<OperationGroup> getOperationGroupList() {
        return operationGroupList;
    }

    public void setOperationGroupList(List<OperationGroup> operationGroupList) {
        this.operationGroupList = operationGroupList;
    }

    @XmlElement(name = "operation")
    public List<Operation> getOperationList() {
        return operationList;
    }

    public void setOperationList(List<Operation> operationList) {
        this.operationList = operationList;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Operations{");
        sb.append("operationGroupList=").append(operationGroupList);
        sb.append(", operationList=").append(operationList);
        sb.append('}');
        return sb.toString();
    }
}
