import org.junit.*;
import static org.junit.Assert.*;

public class HackTeamTest {

  @Test
  public void HackTeam_TeamObj_true() {
    HackTeam newMember = new HackTeam("Blossom");
    assertEquals(true, newMember instanceof HackTeam);
  }

  @Test
  public void HackTeam_HackMemberInHackTeam_true() {
    HackTeam newTeam = new HackTeam("Blossom");
    HackMember newMember = new HackMember("keith", "java");
    newTeam.addMember(newMember);
    assertTrue(newTeam.getMembers().contains(newMember));
  }
  
}
