import com.fasterxml.jackson.databind.ObjectMapper;
import model.JsonFile;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.InputStreamReader;

import static com.codeborne.pdftest.assertj.Assertions.assertThat;

@DisplayName("Тестирование чтения информации из json файла")
public class JsonTests {
    private final ClassLoader cl = JsonTests.class.getClassLoader();

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    @DisplayName("Проверка инфо")
    void processJsonFile() throws Exception {
        try (InputStreamReader isr = new InputStreamReader(cl.getResourceAsStream("JsonFile.json"))) {
            JsonFile data = objectMapper.readValue(isr, JsonFile.class);
            assertThat(data.getName()).isEqualTo("Donnell Ritchie");
            assertThat(data.getPhoneNumber()).isEqualTo("+1-793-643-0373");
            assertThat(data.getEmail()).isEqualTo("eulalia.marquardt@hotmail.com");

        }

    }

}
