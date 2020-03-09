import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import io.corp.calculator.ConfigAplicacion;

import java.net.URI;
import java.net.URISyntaxException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ConfigAplicacion.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CalculatorTest {
    @LocalServerPort
    int randomServerPort;

    private ResponseEntity<Double> calculator(double salary, int hours, String operation) throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();

        final String baseUrl = "http://localhost:" + randomServerPort +
                "/calculator/calculate?salary=" + salary +
                "&hours=" + hours + "&operacion=" + operation;
        URI uri = new URI(baseUrl);

        ResponseEntity<Double> resultado = restTemplate.getForEntity(uri, Double.class);
        return resultado;
    }

    @Test
    public void hoursCalculation() throws URISyntaxException {

        ResponseEntity<Double> resultado = calculator(30, 6, "calculator");

       
        Assert.assertEquals(200, resultado.getStatusCodeValue());
   
    }





}