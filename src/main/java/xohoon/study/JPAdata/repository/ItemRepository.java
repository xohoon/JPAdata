package xohoon.study.JPAdata.repository;

import lombok.Getter;
import org.springframework.data.jpa.repository.JpaRepository;
import xohoon.study.JPAdata.entity.Item;

import javax.persistence.Entity;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
