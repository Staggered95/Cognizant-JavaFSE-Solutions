package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
  public static void main(String[] args) {
    // 1. Boot up Spring and read the XML file
    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

    // 2. Ask Spring to hand us the fully constructed BookService (which has the
    // Repository inside it)
    BookService service = (BookService) context.getBean("bookService");

    // 3. Test it!
    service.manageBook();
  }
}
