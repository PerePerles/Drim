package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableAutoConfiguration
public class DrimTimApplication {


	@RequestMapping(value = "/match", method = RequestMethod.GET)
	public @ResponseBody
	String match(@RequestParam("p") String plays) {
		Match match = new Match(Integer.parseInt(plays));

		return match.play();
	}

	@RequestMapping(value = "/team", method = RequestMethod.GET)
	public @ResponseBody String team(@RequestParam("formation") String formation) {
		Team team = new Team(formation);

		return team.toString();
	}

	@RequestMapping(value = "/player", method = RequestMethod.GET)
	public @ResponseBody String player(@RequestParam("position") String position) {
		Player player = new Player(position);

		return "<table border='1' style='width:50%; float: left'>" + player.toString() + "</table>";
	}

	public static void main(String[] args) {
		SpringApplication.run(DrimTimApplication.class, args);
	}

}