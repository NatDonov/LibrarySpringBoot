package co.jb.authors.clr;


import co.jb.authors.beans.Author;
import co.jb.authors.beans.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;


@Component
@Order(3)
public class LibraryControllerTest implements CommandLineRunner {


    @Autowired
    private RestTemplate restTemplate;

    private String url = "http://localhost:8080/api/library";

    @Override
    public void run(String... args) throws Exception {

        Book b1 = Book.builder().name("Love to love - New").year(1999).build();
        Author a1 = Author.builder().name("Moshe").books(List.of(b1)).build();


        System.out.println("------------ADD AUTHOR---------------");
        ResponseEntity<String> res = restTemplate.postForEntity(url, a1, String.class );
        System.out.println(res.getStatusCode());


        System.out.println("-------------GET ALL AUTHORS--------------");
        Author[] res1 = restTemplate.getForObject(url+"/authors", Author[].class);
        Arrays.asList(res1).forEach(System.out::println);

        System.out.println("-------------GET ONE AUTHOR--------------");
        Author res2 = restTemplate.getForObject(url+"/authors/2", Author.class);
        System.out.println(res2);

        System.out.println("--------------BOOKS BETWEEN RANGE-------------");
        Book[] res3 = restTemplate.getForObject(url+"/books/year/btw?start=2000&end=2022", Book[].class);
        Arrays.asList(res3).forEach(System.out::println);


        System.out.println("--------------DELETE AUTHOR-------------");
        restTemplate.delete(url + "/3");
        Arrays.asList(restTemplate.getForObject(url+"/authors", Author[].class)).forEach(System.out::println);

        System.out.println("--------------UPDATE-------------");
        Author res4 = restTemplate.getForObject(url+"/authors/2", Author.class);
        System.out.println(res4);

        res4.setName("Elena");
        restTemplate.put(url + "/authors/2" , res4);

        System.out.println(restTemplate.getForObject(url+"/authors/2", Author.class));


        System.out.println("---------------AVG-----------------");
        Double res5 = restTemplate.getForObject(url+"/books/year/avg", Double.class);
        System.out.println(res5);

        System.out.println("---------------AVG BY AUTHOR ID-----------------");
        Double res6 = restTemplate.getForObject(url+"/books/avg/2", Double.class);
        System.out.println(res6);










    }
}
