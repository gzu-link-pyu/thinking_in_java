package com.gzu.pyu.file.java.transfer;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "operations")
public class Operations {
    @JSONField(name = "operationgroups")
    private List<OperationGroup> operationGroupList;
    @JSONField(name = "operations")
    private List<Operation> operationList;

    public Operations() {
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
