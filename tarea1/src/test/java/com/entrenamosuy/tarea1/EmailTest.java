package com.entrenamosuy.tarea1;

import com.entrenamosuy.tarea1.data.Email;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmailTest {

    @Test
    void emailGetters() {
        Email e1 = new Email("test", "email.com");
        assertEquals("test", e1.getPrefix());
        assertEquals("email.com", e1.getDomain());
    }
}
