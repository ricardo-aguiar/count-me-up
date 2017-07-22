package tech.experimental.countmeup.api.utils;

import java.io.IOException;
import java.io.StringWriter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test utilities for JSON mapping.
 */
public final class JsonTestUtils
{

    private static final Logger LOG = LoggerFactory.getLogger(JsonTestUtils.class);
    private static final ObjectMapper OBJECT_MAPPER;

    static
    {
        final ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        OBJECT_MAPPER = mapper;
    }

    /**
     * This class should not be instantiated.
     */
    private JsonTestUtils()
    {

    }

    /**
     * Assert that the objects are equal but not the same.
     *
     * @param firstObject the first object
     * @param secondObject the second object
     */
    public static <T> void assertEqualButNotSame(final T firstObject, final T secondObject)
    {
        // Objects should not be the same, but should be equal!
        assertThat(firstObject).isNotSameAs(secondObject);
        assertThat(firstObject).isEqualTo(secondObject);
    }

    /**
     * Round trip serialisation / deserialisation of object.
     *
     * @param objectToMap the object to map
     * @param clazz the type of object
     * @return the final deserialised object
     * @throws IOException if mapping did not succeed
     */
    public static <T> T roundTrip(final T objectToMap, final Class<T> clazz) throws IOException
    {
        final String serialised = serialise(objectToMap);
        LOG.info("Serialised {}: {}", clazz, serialised);
        return deserialise(clazz, serialised);
    }

    /**
     * Deserialise the given String to the given class type.
     *
     * @param clazz the expected object type
     * @param serialised the serialised data
     * @return the deserialised object
     * @throws IOException if the object could not be deserialised
     */
    public static <T> T deserialise(final Class<T> clazz, final String serialised) throws IOException
    {
        return OBJECT_MAPPER.readValue(serialised, clazz);
    }

    /**
     * Serialise the given object.
     *
     * @param objectToMap the object to map
     * @return serialised JSON as a String
     * @throws IOException if the object could not be serialised
     */
    public static <T> String serialise(final T objectToMap) throws IOException
    {
        final StringWriter writer = new StringWriter();
        OBJECT_MAPPER.writeValue(writer, objectToMap);
        return writer.toString();
    }
}
