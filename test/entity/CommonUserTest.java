package entity;

import junit.framework.TestCase;

public class CommonUserTest extends TestCase {

    public void testGetName() {
        // Test the getName method
        CommonUser user = new CommonUser("testUser", "password123", 100);
        assertEquals("testUser", user.getName());
    }

    public void testGetPassword() {
        // Test the getPassword method
        CommonUser user = new CommonUser("testUser", "password123", 100);
        assertEquals("password123", user.getPassword());
    }
}
