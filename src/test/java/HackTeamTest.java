import org.junit.*;
import java.util.List;
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

  @Test
  public void HackTeam_Addmember_true() {
    HackTeam newTeam = new HackTeam("Blossom");
    HackMember newMember = new HackMember("keith", "java");
    newTeam.addMember(newMember);
    assertEquals(true, newTeam.getMembers() instanceof List<?>);
  }

  @Test
  public void HackTeam_allteams_true(){
    HackTeam newTeam = new HackTeam("Blossom");
    assertTrue(newTeam.allTeams() instanceof List<?>);
  }

  @Test
  public void test_getters(){
    HackTeam newTeam = new HackTeam("Blossom");
    assertEquals(0, newTeam.getId());
    assertEquals("Blossom", newTeam.getName());
  }

}
