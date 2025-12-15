package com.demo.url_shortner.repo;

import com.demo.url_shortner.model.ShortLongURLRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlRepository extends JpaRepository<ShortLongURLRelation,String> {


}
