package com.wojciech.gaudnik.spock_test.configuration;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.wojciech.gaudnik.spock_test.model.Employee;
import com.wojciech.gaudnik.spock_test.model.request.CarConverted;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

@Slf4j
@JsonComponent
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JsonComponentExample {

	public static class Serializer extends JsonDeserializer<CarConverted> {
		@Override
		public CarConverted deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
			log.error(jsonParser.getText());
			log.error(jsonParser.getValueAsString());
			log.error(jsonParser.nextFieldName());
			log.error(jsonParser.nextTextValue());
			log.error(jsonParser.nextToken().asString());
			return CarConverted.builder().name("from Json Deserializer").horsePower(6616).employee(Employee.builder()
					.id(1L)
					.name("employee")
					.secondName("secondName")
					.pass("asdfasdf")
					.build()).build();
		}
	}

}
   
