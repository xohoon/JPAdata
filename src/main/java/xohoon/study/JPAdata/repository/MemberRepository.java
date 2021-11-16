package xohoon.study.JPAdata.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import xohoon.study.JPAdata.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
