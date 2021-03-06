package xohoon.study.JPAdata.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import xohoon.study.JPAdata.dto.MemberDto;
import xohoon.study.JPAdata.entity.Member;
import xohoon.study.JPAdata.entity.Team;

import javax.persistence.LockModeType;
import javax.persistence.QueryHint;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long>, MemberRepositoryCustom {
    // 기본으로 정의된 기능을 주로 쓰고
    List<Member> findByUsernameAndAgeGreaterThan(String username, int age);

    List<Member> findTop3HelloBy();

    // @Query(name = "Member.findByUsername") named query가 없으면 메서드 이름 검색
    List<Member> findByUsername(@Param("username") String username);

    // 조금 복잡한 정적쿼리 추천(애플리케이션 로딩시 장애발생)
    @Query("select m from Member m where m.username = :username and m.age = :age")
    List<Member> findUser(@Param("username") String username, @Param("age") int age);

    //단순한 값, DTO 호출
    @Query("select m.username from Member m")
    List<String> findUsernameList();

    @Query("select new xohoon.study.JPAdata.dto.MemberDto(m.id, m.username, t.name) from Member m join m.team t")
    List<MemberDto> findMemberDto();

    @Query("select m from Member m where m.username in :names")
    List<Member> findByNames(@Param("names") Collection<String> names);

    List<Member> findListByUsername(String username); // 컬렉션
    Member findMemberByUsername(String username); // 단건
    Optional<Member> findOptionalByUsername(String username); // 단건 optional

    // 쿼리가 복잡하면 count query 분리
    @Query(value = "select m from Member m left join m.team t",
            countQuery = "select count(m.username) from Member m")
    Page<Member> findByAge(int age, Pageable pageable);

    @Modifying(clearAutomatically = true) // 제외하면 update 안됨, clear auto 해주면 clear 안해줘도됨
    @Query("update Member m set m.age = m.age + 1 where m.age >= :age")
    int bulkAgePlus(@Param("age") int age);

    @Query("select m from Member m left join fetch m.team")
    List<Member> findMemberFetchJoin();

    // v1~3
    @Override
    @EntityGraph(attributePaths = {"team"}) // JPA query 사용하지 않고 성능 최적화(fetch join)
    List<Member> findAll();

    @EntityGraph(attributePaths = {"team"})
    @Query("select m from Member m")
    List<Member> findMemberEntityGraph();

//    @EntityGraph(attributePaths = {"team"})
    @EntityGraph("Member.all")
    List<Member> findEntityGraphByUsername(@Param("username") String username);

    // 오로지 100% read 할때 사용(어마어마하게 트래픽이 많아서 성능이 안나올때) - 이전에 캐시를 깔아야함
    @QueryHints(value = @QueryHint(name = "org.hibernate.readOnly", value = "true"))
    Member findReadOnlyByUsername(String username);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    List<Member> findLockByUsername(String username);
}
