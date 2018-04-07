package com.gzu.pyu.tools.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.gzu.pyu.file.java.transfer.Operation;
import com.gzu.pyu.file.java.transfer.OperationGroup;
import com.gzu.pyu.file.java.transfer.Operations;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class XmlBeanTransferUtils {

    /**
     * java对象转换为xml文件
     * @param clazz    java对象.Class
     * @return    xml文件的String
     * @throws JAXBException
     */
    public static String beanToXml(Object obj,Class<?> clazz) throws JAXBException{
        JAXBContext context = JAXBContext.newInstance(clazz);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty(Marshaller.JAXB_ENCODING, "GBK");
        StringWriter writer = new StringWriter();
        marshaller.marshal(obj,writer);
        return writer.toString();
    }

    /**
     * xml文件配置转换为对象
     * @param xmlPath  xml文件路径
     * @param load    java对象.Class
     * @return    java对象
     * @throws JAXBException
     * @throws IOException
     */
    public static Object xmlToBean(String xmlPath,Class<?> load) throws JAXBException, IOException{
        JAXBContext context = JAXBContext.newInstance(load);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Object object = unmarshaller.unmarshal(new File(xmlPath));
        return object;
    }

    public static void main(String[] args) throws JAXBException, IOException {

        List<String> localTargetFile = FileUtils.findLocalTargetFile("operation.xml", true);
        String xmlPath =  "G:/testConfig.xml";
        Object object = xmlToBean(localTargetFile.get(0),Operations.class);
        Operations students = (Operations)object;
//        System.out.println(students);

        String jsonStr= JSON.toJSONString(students);
        System.out.println(JSON.toJSONString(students));

        String formatJsonStr = JsonBeanTransferUtils.formatJsonStr(JSON.toJSONString(students));


        Operations operations = new Operations();
        List<OperationGroup> operationGroupList=new ArrayList<>();
        operationGroupList.add(new OperationGroup("neteco.id","neteco.name","neteco.description"));
        operations.setOperationGroupList(operationGroupList);

        List<Operation> operationList =new ArrayList<>();
        operationList.add(new Operation("query.id","query.name","query.description","neteco.id"));
        operationList.add(new Operation("insert.id","insert.name","insert.description","neteco.id"));
        operations.setOperationList(operationList);
        String str =XmlBeanTransferUtils.beanToXml(operations, Operations.class);

        //写入到xml文件中
        BufferedWriter bfw = new BufferedWriter(new FileWriter(new File(xmlPath)));
        bfw.write(str);
        bfw.close();
    }
}
