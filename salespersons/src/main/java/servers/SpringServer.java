package servers;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringServer {
    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("classpath:springServer.xml");
    }
}
