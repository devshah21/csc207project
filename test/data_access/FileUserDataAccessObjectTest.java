package data_access;

import entity.CommonUserFactory;
import entity.User;
import entity.UserFactory;
import junit.framework.TestCase;


import java.io.IOException;

public class FileUserDataAccessObjectTest extends TestCase {

    private FileUserDataAccessObject fileUserDataAccessObject;
    private UserFactory userFactory;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        userFactory = new CommonUserFactory();
        fileUserDataAccessObject = new FileUserDataAccessObject("test.csv", userFactory);
    }

    public void testSave() {
        User user = userFactory.create("testUser", "password123", 100);
        fileUserDataAccessObject.save(user);

        // Retrieve the user and check if it was saved correctly
        User retrievedUser = fileUserDataAccessObject.get("testUser");
        assertNotNull(retrievedUser);
        assertEquals("testUser", retrievedUser.getName());
        assertEquals("password123", retrievedUser.getPassword());
    }

    public void testGet() {
        // Assuming you've already tested saving, you can retrieve a user here and assert its properties.
        // The detailed testing of this method might depend on the actual implementation.
    }

    public void testExistsByName() {
        // Test if a user exists by name
        assertFalse(fileUserDataAccessObject.existsByName("nonExistentUser"));

        // Save a user and then check if it exists
        User user = userFactory.create("existingUser", "password456", 150);
        fileUserDataAccessObject.save(user);
        assertTrue(fileUserDataAccessObject.existsByName("existingUser"));
    }

    public void testErase() throws IOException {
        // Save a user, then erase all data, and check if the data is cleared
        User user = userFactory.create("userToErase", "password789", 200);
        fileUserDataAccessObject.save(user);

        fileUserDataAccessObject.erase();

        assertFalse(fileUserDataAccessObject.existsByName("userToErase"));
    }

    public void testGetUsers() {
        // Assuming you've already tested saving, you can retrieve the list of users and assert their properties.
        // The detailed testing of this method might depend on the actual implementation.
        assertNotNull(fileUserDataAccessObject.getUsers());
    }
}
