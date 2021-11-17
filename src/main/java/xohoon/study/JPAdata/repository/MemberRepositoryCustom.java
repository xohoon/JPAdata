package xohoon.study.JPAdata.repository;

import xohoon.study.JPAdata.entity.Member;

import java.util.List;

public interface MemberRepositoryCustom {
    List<Member> findMemberCustom();
}
