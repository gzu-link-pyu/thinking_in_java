package com.gzu.pyu.tools.utils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;

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
    public static <T>T xmlToBean(String xmlPath,Class<T> load) throws JAXBException, IOException{
        JAXBContext context = JAXBContext.newInstance(load);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        T object = (T)unmarshaller.unmarshal(new File(xmlPath));
        return object;
    }

}
