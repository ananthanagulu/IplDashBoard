package com.io.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.io.data.Team;
@Repository
public interface TeamRepository extends CrudRepository<Team,Long>{

	Team findByTeamName(String teamName);
}
