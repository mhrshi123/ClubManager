package club.business;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class MemberTest {
    
    private Member member;
    
    public MemberTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        member = new Member();
    }
    
    @After
    public void tearDown() {
        member = null;
    }

    @Test
    public void testGetFullName() {
        System.out.println("Testing getFullName");
        member.setFullName("John Doe");
        assertEquals("John Doe", member.getFullName());
    }

    @Test
    public void testSetFullName() {
        System.out.println("Testing setFullName");
        member.setFullName("Jane Doe");
        assertEquals("Jane Doe", member.getFullName());
    }

    @Test
    public void testGetEmailAddress() {
        System.out.println("Testing getEmailAddress");
        member.setEmailAddress("jane.doe@example.com");
        assertEquals("jane.doe@example.com", member.getEmailAddress());
    }

    @Test
    public void testSetEmailAddress() {
        System.out.println("Testing setEmailAddress");
        member.setEmailAddress("john.doe@example.com");
        assertEquals("john.doe@example.com", member.getEmailAddress());
    }

    @Test
    public void testGetPhoneNumber() {
        System.out.println("Testing getPhoneNumber");
        member.setPhoneNumber("123-456-7890");
        assertEquals("123-456-7890", member.getPhoneNumber());
    }

    @Test
    public void testSetPhoneNumber() {
        System.out.println("Testing setPhoneNumber");
        member.setPhoneNumber("987-654-3210");
        assertEquals("987-654-3210", member.getPhoneNumber());
    }

    @Test
    public void testGetProgramName() {
        System.out.println("Testing getProgramName");
        member.setProgramName("Computer Science");
        assertEquals("Computer Science", member.getProgramName());
    }

    @Test
    public void testSetProgramName() {
        System.out.println("Testing setProgramName");
        member.setProgramName("Software Engineering");
        assertEquals("Software Engineering", member.getProgramName());
    }

    @Test
    public void testGetYearLevel() {
        System.out.println("Testing getYearLevel");
        member.setYearLevel(3);
        assertEquals(3, member.getYearLevel());
    }

    @Test
    public void testSetYearLevel() {
        System.out.println("Testing setYearLevel");
        member.setYearLevel(2);
        assertEquals(2, member.getYearLevel());
    }
}