package clubsysteem;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateHandler extends StdDeserializer<LocalDate> {
    public DateHandler(){
        this(null);
    }

    public DateHandler(Class<?> clazz){
        super(clazz);
    }

    @Override
    public LocalDate deserialize(JsonParser jsonparser, DeserializationContext context)
        throws IOException {
        String date = jsonparser.getText();
        try{
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            return LocalDate.parse(date, formatter).plusDays(1);
        } catch (Exception e) {
            return null;
        }
    }
}
