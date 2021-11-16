package xohoon.study.JPAdata.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import xohoon.study.JPAdata.entity.Member;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {
    List<Member> findByUsernameAndAgeGreaterThan(String username, int age);

    List<Member> findTop3HelloBy();
}
