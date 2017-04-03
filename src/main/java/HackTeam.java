import java.util.List;
import java.util.ArrayList;

public class HackTeam {
  private int mId;
  private String mName;
  private static ArrayList<HackTeam> totalTeams = new ArrayList<HackTeam>();
  private ArrayList<HackMember> mMembers;


  public HackTeam(String name){
    mName = name;
    mId = totalTeams.size();
    totalTeams.add(this);
    mMembers = new ArrayList<HackMember>();
  }

  public void addMember(HackMember newMember){
    mMembers.add(newMember);
  }

  public ArrayList<HackMember> getMembers(){
    return mMembers;
  }

  public HackMember getMembersId(int index){
    return mMembers.get(index);
  }

  public static HackTeam find(int id) {
    return totalTeams.get(id);
  }

  public static ArrayList<HackTeam> allTeams() {
   return totalTeams;
  }

  public int getId(){
    return mId;
  }

  public String getName(){
    return mName;
  }

  public void clear() {
    mMembers.clear();
  }
}
