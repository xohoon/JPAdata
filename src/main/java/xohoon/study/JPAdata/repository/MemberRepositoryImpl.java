package xohoon.study.JPAdata.repository;

import lombok.RequiredArgsConstructor;
import xohoon.study.JPAdata.entity.Member;

import javax.persistence.EntityManager;
import java.util.List;

@RequiredArgsConstructor
// 명칭 맞춰주면 spring jpa가 알아서 호출해줌
public class MemberRepositoryImpl implements MemberRepositoryCustom {

    private final EntityManager em;

    // another db connection 사용하고 싶을때
    // ex) spring jdbc template, Querydsl 쓸때 사용
    @Override
    public List<Member> findMemberCustom() {
        return em.createQuery("select m from Member m")
                .getResultList();
    }
}
