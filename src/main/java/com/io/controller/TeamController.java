package com.io.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.io.data.Team;
import com.io.model.Match;
import com.io.repository.MatchRepositiry;
import com.io.repository.TeamRepository;

@RestController
@CrossOrigin
public class TeamController {
	@Autowired
	private TeamRepository teamRepository;
	@Autowired
	private MatchRepositiry matchRepositiry;
	@GetMapping("/team/{teamName}")
	public Team getTeam(@PathVariable("teamName") String teamName) {
		Team team=teamRepository.findByTeamName(teamName);
		
		List<Match> matches=matchRepositiry.findLatestMatchesByName(teamName, 4);
		team.setMatches(matches);
		return team;
		
	}
}
