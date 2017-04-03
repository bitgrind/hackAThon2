import org.junit.*;
import static org.junit.Assert.*;

public class HackMemberTest {

  @Test
  public void HackMember_MemberObj_true() {
    HackMember newMember = new HackMember("Keith2", "java");
    assertEquals(true, newMember instanceof HackMember);
  }

  @Test
  public void HackMember_MemberGetName_true() {
    HackMember newMember = new HackMember("Keith", "java");
    assertEquals("Keith", newMember.getName());
  }

  @Test
  public void HackMember_MemberGetLanguage_true() {
    HackMember newMember = new HackMember("Keith", "java");
    assertEquals("java", newMember.getLanguage());
  }

  @Test
  public void HackMember_MemberListSize_0() {
    HackMember newMember = new HackMember("Keith", "java");
    HackMember.clear();
    assertEquals(0, HackMember.all().size());
  }

  @Test
  public void HackMember_MemberListSize_1() {
    HackMember newMember = new HackMember("Keith", "java");
    assertEquals(1, HackMember.all().size());
  }

}
