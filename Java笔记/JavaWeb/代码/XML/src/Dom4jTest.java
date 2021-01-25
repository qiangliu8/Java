import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import javax.xml.parsers.SAXParser;
import java.util.List;

public class Dom4jTest {
    @Test
    public void test1(){
        //创建一个SAXReader输入流，去读取xml配置文件，生成Document对象
        try {
            SAXReader saxReader = new SAXReader();
            Document document = saxReader.read("src/books.xml");
            System.out.println(document);
        }catch (DocumentException e){
            e.printStackTrace();
        }

    }
    /*
    * 读取books.xml文件生成Book类
    * */
    @Test
    public void test2() throws DocumentException {
        //1.读取books.xml文件
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read("src/books.xml");
        //2.通过document对象获取根元素
        Element rootElement = document.getRootElement();
        System.out.println(rootElement);
        //3.通过根元素获取book标签元素
        List<Element> books = rootElement.elements("book");
        //4.通过处理每个book标签转换为Book类
        for (Element book: books) {
            Element element = book.element("name");
            String name = element.getText();

            String price = book.elementText("price");
            String author = book.elementText("author");

            String sn = book.attributeValue("sn");

            System.out.println(new Book(sn,name,author,Double.parseDouble(price)));
        }
    }
}
