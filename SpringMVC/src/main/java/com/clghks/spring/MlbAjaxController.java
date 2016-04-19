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
		team.setLogo("https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcS_ZnUrvK3zFKXrMFBM5S0-WdNgJDw0Kc_82-j83Zw7PUvVa2H8thhMdtjc");
		
		return team;
	}
	
	@RequestMapping("/ajax/xmlMlb")
	@ResponseBody
	public MlbJaxb showMlbXml(){
		
		TeamJaxb team1 = new TeamJaxb();
		team1.setName("보스턴");
		team1.setLogo("https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcS_ZnUrvK3zFKXrMFBM5S0-WdNgJDw0Kc_82-j83Zw7PUvVa2H8thhMdtjc");
		
		TeamJaxb team2 = new TeamJaxb();
		team2.setName("볼티모어");
		team2.setLogo("https://lh3.googleusercontent.com/-LKshlT4uM4s/VxECKZ18dqI/AAAAAAAAUpE/_L7l-a8_EbwhXUmX94gIsMF1haLr0LKzg/w852-h474/img20160415-26551-90toxq");
		
		TeamJaxb team3 = new TeamJaxb();
		team3.setName("다져스");
		team3.setLogo("/spring/resources/la.jpg");
		
		List<TeamJaxb> teamList = new ArrayList<TeamJaxb>();
		
		teamList.add(team1);
		teamList.add(team2);
		teamList.add(team3);

		MlbJaxb jaxb = new MlbJaxb();
		jaxb.setTeamList(teamList);
		
		return jaxb;
	}
}
