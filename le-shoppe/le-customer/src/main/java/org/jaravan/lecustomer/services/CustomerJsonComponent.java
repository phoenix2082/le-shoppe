package org.jaravan.lecustomer.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jaravan.lecustomer.entity.Address;
import org.jaravan.lecustomer.entity.Customer;
import org.springframework.boot.jackson.JsonComponent;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

@JsonComponent
public class CustomerJsonComponent {

    public static final class Serializer extends JsonSerializer<Customer> {

        @Override
        public void serialize(final Customer value,
                final JsonGenerator gen,
                final SerializerProvider serializers) throws IOException {
            gen.writeStartObject();
            gen.writeStringField("firstName", value.getFirstName());
            gen.writeStringField("middleName", value.getMiddleName());
            gen.writeStringField("lastName", value.getLastName());

            if (value.getAddresses() != null
                && !value.getAddresses().isEmpty()) {
                gen.writeArrayFieldStart("addresses");
                value.getAddresses().forEach(addr -> {
                    try {
                        gen.writeStartObject();
                        gen.writeStringField("line1", addr.getLine1());
                        gen.writeStringField("line2", addr.getLine2());
                        gen.writeStringField("city", addr.getCity());
                        gen.writeStringField("state", addr.getState());
                        gen.writeStringField("country", addr.getCountry());
                        gen.writeStringField("zipcode", addr.getZipCode());
                        gen.writeStringField("type", addr.getType().name());
                        gen.writeEndObject();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                });
                gen.writeEndArray();
            }
            gen.writeEndObject();
        }
    }

    public static final class Deserializer extends JsonDeserializer<Customer> {

        @Override
        public Customer deserialize(final JsonParser p,
                final DeserializationContext ctxt)
                throws IOException, JsonProcessingException {

            JsonNode node = p.getCodec().readTree(p);
            String firstName = node.get("firstName").asText();
            String middleName = node.get("middleName").asText();
            String lastName = node.get("lastName").asText();
            Customer customer = new Customer(firstName, middleName, lastName);
            JsonNode addresses = node.get("addresses");
            List<Address> addrList =  new ArrayList<Address>();
            if (addresses != null) {
                addresses.forEach(addr -> {

                    String addLine1 = addr.get("line1").asText();
                    String addLine2 = addr.get("line2").asText();
                    String city = addr.get("city").asText();
                    String state = addr.get("state").asText();
                    String country = addr.get("country").asText();
                    String zipCode = addr.get("zipcode").asText();
                    String type = addr.get("type").asText();

                    // Create address object and set Customer.
                    Address address = new Address(addLine1, addLine2,
                            city, state, country, zipCode, type);
                    address.setCustomer(customer);
                    addrList.add(address);
                });
                customer.setAddresses(addrList);
            }
            return customer;
        }
    }
}
