package de.htwberlin.webtech.web.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
    public interface WebsiteRepository extends JpaRepository<WebsiteEntity, Long> {
    }

