package com.gzu.pyu.tools.utils;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.util.List;

public class MainTest {

	public static void main(String[] args) throws Exception {
		//得到解析器
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		List<String> localTargetFile = FileUtils.findLocalTargetFile("operation.xml");
		//通过解析器就可以得到代表整个内存中XML的Document对象
		Document document = builder.parse(localTargetFile.get(0));
		test2(document);
	}
	//  1、得到某个具体的节点内容:  刘丰
	private static void test1(Document document){
		NodeList nl = document.getElementsByTagName("作者");
		Node authorNode = nl.item(0);
		System.out.println(authorNode.getTextContent());
	}
	//  2、遍历所有元素节点:打印元素的名称
	private static void test2(Node node){
		//确定node的类型
		//方式一
//      if(node.getNodeType()==Node.ELEMENT_NODE){
//          //是元素
//      }
		//方式二
		if(node instanceof Element){
			//是元素
			Element e = (Element)node;
			System.out.println(e.getNodeName());//打印元素名称
		}
		//判断有没有子节点
		NodeList nl = node.getChildNodes();
		for(int i=0;i<nl.getLength();i++){
			Node n = nl.item(i);
			test2(n);
		}
	}
	//  3、修改某个元素节点的主体内容:<售价>39.00元</售价>--->10元
	private static void test3(Document document) throws Exception{
		//得到售价
		Node priceNode = document.getElementsByTagName("售价").item(0);
		priceNode.setTextContent("10元");
		//更新XML文件
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer t = tf.newTransformer();
		//构建输入源：
		Source source = new DOMSource(document);
		//构建目标：
		Result result = new StreamResult("src/book.xml");

		t.transform(source, result);
	}

	//  4、向指定元素节点中增加子元素节点:第一本书添加子元素 <出版社>黑马程序员</出版社>
	private static void test4(Document document) throws Exception{
		//创建：<出版社>黑马程序员</出版社>
		Element e = document.createElement("出版社");
		e.setTextContent("黑马程序员");
		//得到书，把新节点挂上去
		Node bookNode = document.getElementsByTagName("书").item(0);
		bookNode.appendChild(e);
		//更新XML文件
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer t = tf.newTransformer();
		//构建输入源：
		Source source = new DOMSource(document);
		//构建目标：
		Result result = new StreamResult("src/book.xml");

		t.transform(source, result);
	}
	//  5、向指定元素节点上增加同级元素节点:第一本书<售价>前面添加<批发价>30</批发价>
	private static void test5(Document document) throws Exception{
		//创建新节点
		Element e = document.createElement("批发价");
		e.setTextContent("30元");
		//找到<售价>
		Node priceNode = document.getElementsByTagName("售价").item(0);
		//父标签：调用insertBefore(新节点,参考节点);

		Node bookNode = priceNode.getParentNode();
		bookNode.insertBefore(e, priceNode);
		//更新XML文件
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer t = tf.newTransformer();
		//构建输入源：
		Source source = new DOMSource(document);
		//构建目标：
		Result result = new StreamResult("src/book.xml");

		t.transform(source, result);
	}
	//  6、删除指定元素节点:删除批发价
	private static void test6(Document document) throws Exception{
		Node priceNode = document.getElementsByTagName("批发价").item(0);
		priceNode.getParentNode().removeChild(priceNode);
		//更新XML文件
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer t = tf.newTransformer();
		//构建输入源：
		Source source = new DOMSource(document);
		//构建目标：
		Result result = new StreamResult("src/book.xml");

		t.transform(source, result);
	}
	//  7、操作XML文件属性:书籍添加一个属性：ISBN=“ABC”
	private static void test7(Document document) throws Exception{
		Node bookNode = document.getElementsByTagName("书").item(0);
		if(bookNode instanceof Element){
			Element e = (Element)bookNode;
			e.setAttribute("ISBN", "ABC");
		}
		//更新XML文件
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer t = tf.newTransformer();
		//构建输入源：
		Source source = new DOMSource(document);
		//构建目标：
		Result result = new StreamResult("src/book.xml");

		t.transform(source, result);
	}
	//  8、操作XML文件属性:获取ISBN=“ABC”
	private static void test8(Document document) throws Exception{
		Node bookNode = document.getElementsByTagName("书").item(0);
		if(bookNode instanceof Element){
			Element e = (Element)bookNode;
			System.out.println(e.getAttribute("ISBN"));
		}
	}
}
