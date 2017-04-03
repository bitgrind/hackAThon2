import java.util.List;
import java.util.ArrayList;

public class HackMember{
  private int id;
  private String name;
  private String language;
  private static ArrayList<HackMember> memberList = new ArrayList<HackMember>();

  public HackMember(String name, String language){
    this.id = memberList.size();
    this.name = name;
    this.language = language;
    memberList.add(this);
  }

  public String getName(){
    return name;
  }

  public String getLanguage(){
    return language;
  }

  public static ArrayList<HackMember> all(){
    return memberList;
  }

  public static void clear(){
    memberList.clear();
  }

}
