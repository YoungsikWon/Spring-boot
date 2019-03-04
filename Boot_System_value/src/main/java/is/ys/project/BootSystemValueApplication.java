package is.ys.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class BootSystemValueApplication {
	
	@Value("${property.test.name}")
	private String ptname;
	
	@Value("#{'${propertyTestList}'.split(',')}")
	private List<String> ptList;
	
	@Autowired
	FruitProperty fruitProperty;

	
	public static void main(String[] args) {
		SpringApplication.run(BootSystemValueApplication.class, args);
	}

	@GetMapping
	public String hello() {
		System.out.println(">>"+ptname);
		System.out.println(">>"+ptList.toString());
		System.out.println(fruitProperty.toString());
		return "Hello world!!";
	}
	

	

}
