package se.lexicon.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class AppUserTest {
    private AppUser testObject;

    @BeforeEach
    public void setup() {
        AppUser testObject = new AppUser(1, "Iswarya", "Jaisriram", true, roles.ROLE_USER);
    }

    @Test
    public void testObject_successfully_instantiated() {
        assertEquals(1, testObject.getId());
        assertEquals("user", testObject.getUserName());
        assertNotEquals("USER", testObject.getUserName());
    }
}




