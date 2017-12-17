package com.fsocity.retail.utils.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.Date;

/**
 * @author zail
 * @version imp01.0.0
 */
public class Date2LongSerializer extends JsonSerializer<Date> {

  @Override
  public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
    jsonGenerator.writeNumber(date.getTime() / 1000);
  }

}
