package xohoon.study.JPAdata.entity;

import lombok.Getter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/*
* application @EnableJpaAuditing 꼭 추가해야 작동
* */
@EntityListeners(AuditingEntityListener.class) // xml 설정하는 방법도 있음
@MappedSuperclass
@Getter
public class BaseEntity extends BaseTimeEntity{

    /*
    * auditorProvider() 에서 값을 꺼내 자동으로 주입
    * */
    @CreatedBy
    @Column(updatable = false)
    private String createdBy;

    @LastModifiedBy
    private String lastModifiedBy;
}
