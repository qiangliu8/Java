import com.qiangliu8.HelloMaven;
import org.junit.Assert;
import org.junit.Test;

public class TestHelloMaven {
    @Test
    public void testAdd1(){
        HelloMaven helloMaven = new HelloMaven();
        System.out.println("testAdd1："+helloMaven.add(1,2));
    }


    @Test
    public void testAdd2(){
        HelloMaven helloMaven = new HelloMaven();
        System.out.println("testAdd2："+helloMaven.add(1,3));
    }
}
