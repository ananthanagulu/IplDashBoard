package com.io.data;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.batch.item.ItemProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.io.model.Match;

public class MatchDataProcessor implements ItemProcessor<MatchInput, Match> {
	private static final Logger log = LoggerFactory.getLogger(MatchDataProcessor.class);

	  @Override
	  public Match process(final MatchInput matchInput) throws Exception {
		  Match match=new Match();
		  match.setId(Long.parseLong(matchInput.getId()));
		  match.setCity(matchInput.getCity());
		  match.setDate(LocalDate.parse(matchInput.getDate()));
		  match.setPlayerOfMatch(matchInput.getPlayer_of_match());
		  match.setVenue(matchInput.getVenue());
		 
		  String fstInnTeam,scndInnTeam;
		  if("bat".equals(matchInput.getToss_decision())) {
			  fstInnTeam=matchInput.getToss_winner();
			  scndInnTeam=matchInput.getToss_winner().equals(matchInput.getTeam1())?matchInput.getTeam2():matchInput.getTeam1();
		  }
		  else {
			  scndInnTeam=matchInput.getToss_winner();
			  fstInnTeam=matchInput.getToss_winner().equals(matchInput.getTeam1())?matchInput.getTeam2():matchInput.getTeam1();
		  }
		  match.setTeam1(fstInnTeam);
		  match.setTeam2(scndInnTeam);
		  match.setTossWinner(matchInput.getToss_winner());
		  match.setTossDecision(matchInput.getToss_decision());
		  match.setResult(matchInput.getResult());
		  match.setResultMargin(matchInput.getResult_margin());
		  match.setUmpire1(matchInput.getUmpire1());
		  match.setUmpire2(matchInput.getUmpire2());
		  match.setMatchWinner(matchInput.getWinner());
		return match;
		  
	  }


}
