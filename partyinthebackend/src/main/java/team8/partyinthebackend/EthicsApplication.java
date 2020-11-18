package team8.partyinthebackend;

import com.example.cs320EthicsPlayer.Cs320EthicsPlayerApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(value = {Cs320EthicsPlayerApplication.class})
public class EthicsApplication {

	public static void main(String[] args) {
		SpringApplication.run(EthicsApplication.class, args);
	}

}
