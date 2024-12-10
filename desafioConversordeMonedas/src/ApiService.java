import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiService {


      private final  String apiKey ="3caa14298cbedd164d6400ec";
      private final String urlBase= "https://v6.exchangerate-api.com/v6/";

        public ConvertirDatos convertir(String modenaBase , String monedaCotizada){

            URI direccion = URI.create(urlBase+apiKey+"/pair/"+modenaBase+"/"+monedaCotizada+"/");


            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(direccion)
                    .build();

            try {
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                return new Gson().fromJson(response.body(), ConvertirDatos.class);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException("Error en la request");
            }



        }

}
