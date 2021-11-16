package xohoon.study.JPAdata.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import xohoon.study.JPAdata.entity.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
