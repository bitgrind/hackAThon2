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
      ArrayList<HackTeam> teamListing = HackTeam.allTeams();
      model.put("teamAdd", "templates/team-add.vtl");
      model.put("footer", "templates/footer.vtl");
      model.put("header", "templates/header.vtl");
      model.put("teamListing", teamListing);
      model.put("newTeam", "templates/team-list.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/newteam", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String teamName = request.queryParams("teamName");
      HackTeam newTeam = new HackTeam(teamName);
      ArrayList<HackTeam> teamListing = newTeam.allTeams();
      model.put("newTeam", "templates/team-list.vtl");
      model.put("teamList", "templates/team-add.vtl");
      model.put("teamListing", teamListing);
      model.put("footer", "templates/footer.vtl");
      model.put("header", "templates/header.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/newteam/:id", (request, response) -> {
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
      model.put("footer", "templates/footer.vtl");
      model.put("header", "templates/header.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/addmember/:id", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      HackTeam gotTeam = HackTeam.find(Integer.parseInt(request.params(":id")));

      String memberName = request.queryParams("memberName");
      String memberLanguage = request.queryParams("memberLanguage");
      HackMember newMember = new HackMember(memberName, memberLanguage);

      gotTeam.addMember(newMember);

      ArrayList<HackTeam> teamListing = HackTeam.allTeams();
      model.put("teamListing", teamListing);

      model.put("newMember", newMember);
      model.put("gotTeam", gotTeam);
      model.put("addMember", "templates/member-add.vtl");
      model.put("getTeam", "templates/team-get.vtl");
      model.put("newTeam", "templates/team-list.vtl");
      model.put("footer", "templates/footer.vtl");
      model.put("header", "templates/header.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());


  }
}
