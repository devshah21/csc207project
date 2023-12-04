package entity;

import junit.framework.TestCase;

public class CommonUserFactoryTest extends TestCase {

    public void testCreate() {
        // Test the create method of CommonUserFactory
        CommonUserFactory userFactory = new CommonUserFactory();
        User user = userFactory.create("testUser", "password123", 100);

        // Verify that the created user has the correct properties
        assertEquals("testUser", user.getName());
        assertEquals("password123", user.getPassword());
    }
}
