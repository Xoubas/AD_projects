package org.example;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.time.LocalDateTime;

public class LocalDateTimeSerizalize implements JsonSerializer<LocalDateTime> {
    @Override
    public JsonElement serialize(LocalDateTime fecha, Type type, JsonSerializationContext jsc) {
        JsonPrimitive fechaStr = new JsonPrimitive(fecha.getYear() + "-" + fecha.getMonthValue() + "-"
                + fecha.getDayOfMonth() + " " + fecha.getHour() + ":" + fecha.getMinute());

        return fechaStr;
    }
}
