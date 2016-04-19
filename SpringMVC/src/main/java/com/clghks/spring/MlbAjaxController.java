package com.clghks.spring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MlbAjaxController {
	@RequestMapping("/ajax/xmlTeam")
	@ResponseBody
	public TeamJaxb showTeamXml(){
		TeamJaxb team = new TeamJaxb();
		team.setName("보스턴");
		team.setLogi("logo_bos");
		
		return team;
	}
	
	@RequestMapping("/ajax/xmlMlb")
	@ResponseBody
	public MlbJaxb showMlbXml(){
		
		TeamJaxb team1 = new TeamJaxb();
		team1.setName("보스턴");
		team1.setLogi("logo_bos");
		
		TeamJaxb team2 = new TeamJaxb();
		team2.setName("볼티모어");
		team2.setLogi("logo_bos");
		
		TeamJaxb team3 = new TeamJaxb();
		team3.setName("피츠버그");
		team3.setLogi("logo_bos");
		
		List<TeamJaxb> teamList = new ArrayList<TeamJaxb>();
		
		teamList.add(team1);
		teamList.add(team2);
		teamList.add(team3);

		MlbJaxb jaxb = new MlbJaxb();
		jaxb.setTeamList(teamList);
		
		return jaxb;
	}
}
