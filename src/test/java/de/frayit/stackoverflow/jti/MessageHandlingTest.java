package de.frayit.stackoverflow.jti;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

public class MessageHandlingTest {

    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void messageIsHandledProperly() throws Exception {
        AbstractMessage message = mapper.readValue("{\"type\": \".TestMessage\", \"message\":\"just a test\"}", AbstractMessage.class);
        assertThat(message, instanceOf(TestMessage.class));
        assertThat(((TestMessage) message).getMessage(), equalTo("just a test"));
    }

    @Test
    public void otherIsHandledProperly() throws Exception {
        AbstractMessage message = mapper.readValue("{\"type\": \".TestOther\", \"other\": 4711}", AbstractMessage.class);
        assertThat(message, instanceOf(TestOther.class));
        assertThat(((TestOther) message).getOther(), equalTo(4711));
    }

    @Test
    public void somethingElseIsHandledProperly() throws Exception {
        AbstractMessage message = mapper.readValue("{\"type\": \".TestSomethingElse\", \"justSomethingElse\": true}", AbstractMessage.class);
        assertThat(message, instanceOf(TestSomethingElse.class));
        assertThat(((TestSomethingElse) message).isJustSomethingElse(), equalTo(true));
    }


}