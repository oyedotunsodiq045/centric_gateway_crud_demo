package god.stark.centricgateway;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

@SpringBootApplication
@EntityScan(basePackageClasses = { 
		CentricgatewayApplication.class,
		Jsr310JpaConverters.class 
})
public class CentricgatewayApplication {
	
	@PostConstruct
	void init() {
		/*
		 * Creating a TimeZone Instance
		 * 
		 * TimeZone timeZone = TimeZone.getDefault();
		 * returns the default time zone for the system (computer) this program is running on.
		 * 
		 * TimeZone.setDefault(TimeZone.getTimeZone("Africa/Lagos"));
		 * returns the TimeZone corresponding to the given time zone ID (in this example "Africa/Lagos").
		 * 
		 * ref: http://tutorials.jenkov.com/java-date-time/java-util-timezone.html
		 */
		TimeZone.setDefault(TimeZone.getTimeZone("Africa/Lagos"));
	}

	public static void main(String[] args) {
		SpringApplication.run(CentricgatewayApplication.class, args);
	}

}
