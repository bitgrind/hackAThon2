import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import java.util.List;
import java.util.ArrayList;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args){
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("teamAdd", "templates/team-add.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String teamName = request.queryParams("teamName");
      HackTeam newTeam = new HackTeam(teamName);
      ArrayList<HackTeam> teamListing = newTeam.allTeams();
      model.put("newTeam", "templates/team-list.vtl");
      model.put("teamList", "templates/team-add.vtl");
      model.put("teamListing", teamListing);
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/:id", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      HackTeam gotTeam = HackTeam.find(Integer.parseInt(request.params(":id")));
      List getMembers = gotTeam.getMembers();
      ArrayList<HackTeam> teamListing = gotTeam.allTeams();
      model.put("gotTeam", gotTeam);
      model.put("getTeam", "templates/team-get.vtl");
      model.put("newTeam", "templates/team-list.vtl");
      model.put("teamList", "templates/team-add.vtl");
      model.put("addMember", "templates/member-add.vtl");
      model.put("getMembers", getMembers);
      model.put("teamListing", teamListing);
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/:id", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      HackTeam gotTeam = HackTeam.find(Integer.parseInt(request.params(":id")));

      String memberName = request.params("memberName");
      String memberLanguage = request.params("memberLanguage");
      HackMember newMember = new HackMember(memberName, memberLanguage);

      gotTeam.addMember(newMember);

      model.put("getMember", gotTeam.getMembersId(0));
      model.put("newMember", newMember);
      model.put("gotTeam", gotTeam);
      model.put("addMember", "templates/member-add.vtl");
      model.put("getTeam", "templates/team-get.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());


  }
}
