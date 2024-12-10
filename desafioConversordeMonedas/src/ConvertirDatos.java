import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public record ConvertirDatos(String base_code, String target_code, double conversion_rate) {

    public static class HistorialDeConversiones {
        public  void guardarJson(CambioMoneda cambioMoneda) throws IOException {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            FileWriter escritura = new FileWriter("Historial Conversiones"+".json",true);
            escritura.write(gson.toJson(cambioMoneda));
            escritura.close();
        }

    }
}
