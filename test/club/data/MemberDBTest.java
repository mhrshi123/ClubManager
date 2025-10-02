package club.data;

import club.business.Member;
import org.h2.jdbcx.JdbcDataSource;
import org.junit.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class MemberDBTest {
    private static InitialContext ic;
    private Member testMember;

    @BeforeClass
    public static void setUpClass() throws NamingException {
        // Set up JNDI for H2 Database
        System.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.naming.java.javaURLContextFactory");
        System.setProperty(Context.URL_PKG_PREFIXES, "org.apache.naming");
        ic = new InitialContext();

        ic.createSubcontext("java:");
        ic.createSubcontext("java:/comp");
        ic.createSubcontext("java:/comp/env");
        ic.createSubcontext("java:/comp/env/jdbc");

        // Configure H2 DataSource
        JdbcDataSource dataSource = new JdbcDataSource();
        dataSource.setURL("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1");
        dataSource.setUser("sa");
        dataSource.setPassword("");

        ic.bind("java:/comp/env/jdbc/memberdb", dataSource);

        // Initialize database schema
        try (Connection conn = dataSource.getConnection(); Statement stmt = conn.createStatement()) {
            String createTable = "CREATE TABLE member (" +
                    "FullName VARCHAR(255), " +
                    "EmailAddress VARCHAR(255) PRIMARY KEY, " +
                    "PhoneNumber VARCHAR(20), " +
                    "ProgramName VARCHAR(100), " +
                    "YearLevel INT)";
            stmt.execute(createTable);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public static void tearDownClass() throws NamingException {
        // Unbind JNDI resource
        ic.unbind("java:/comp/env/jdbc/memberdb");
        System.clearProperty(Context.INITIAL_CONTEXT_FACTORY);
        System.clearProperty(Context.URL_PKG_PREFIXES);
    }

    @Before
    public void setUp() {
        // Create a test member
        testMember = new Member("John Doe", "test@example.com");
        testMember.setPhoneNumber("1234567890");
        testMember.setProgramName("Computer Science");
        testMember.setYearLevel(2);
    }

    @After
    public void tearDown() {
        // Clean up test data
        if (MemberDB.emailExists(testMember.getEmailAddress())) {
            MemberDB.delete(testMember);
        }
    }

    @Test
    public void testInsert() {
        System.out.println("Testing insert...");
        int result = MemberDB.insert(testMember);
        assertEquals("Insert should return 1 if successful.", 1, result);
    }

    @Test
    public void testUpdate() {
        System.out.println("Testing update...");
        
        // Insert test member first
        MemberDB.insert(testMember);
        
        // Modify member details
        testMember.setFullName("Jane Doe");
        testMember.setPhoneNumber("9876543210");
        
        int result = MemberDB.update(testMember);
        assertEquals("Update should return 1 if successful.", 1, result);
        
        // Verify changes
        Member updatedMember = MemberDB.selectMember("test@example.com");
        assertEquals("Updated name should match.", "Jane Doe", updatedMember.getFullName());
        assertEquals("Updated phone number should match.", "9876543210", updatedMember.getPhoneNumber());
    }

    @Test
    public void testDelete() {
        System.out.println("Testing delete...");
        MemberDB.insert(testMember);
        int result = MemberDB.delete(testMember);
        assertEquals("Delete should return 1 if successful.", 1, result);
        assertFalse("Email should not exist after deletion.", MemberDB.emailExists("test@example.com"));
    }

    @Test
    public void testEmailExists() {
        System.out.println("Testing emailExists...");
        MemberDB.insert(testMember);
        assertTrue("Email should exist after insertion.", MemberDB.emailExists("test@example.com"));
    }

    @Test
    public void testSelectMember() {
        System.out.println("Testing selectMember...");
        MemberDB.insert(testMember);
        Member retrieved = MemberDB.selectMember("test@example.com");
        assertNotNull("Member should not be null.", retrieved);
        assertEquals("Full name should match.", "John Doe", retrieved.getFullName());
        assertEquals("Phone number should match.", "1234567890", retrieved.getPhoneNumber());
    }

    @Test
    public void testSelectMembers() {
        System.out.println("Testing selectMembers...");
        
        // Insert test members
        MemberDB.insert(new Member("Alice Smith", "alice@example.com"));
        MemberDB.insert(new Member("Bob Johnson", "bob@example.com"));

        ArrayList<Member> members = MemberDB.selectMembers();
        assertNotNull("List of members should not be null.", members);
        assertEquals("There should be 2 members.", 2, members.size());
    }
}
