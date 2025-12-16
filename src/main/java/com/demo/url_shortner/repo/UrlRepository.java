package com.demo.url_shortner.repo;

import com.demo.url_shortner.model.ShortLongURLRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UrlRepository extends JpaRepository<ShortLongURLRelation,String> {

    public Optional<ShortLongURLRelation> findByLongUrl(String longUrl);

}
