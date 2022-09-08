package com.nikola.nikola.repo;

import com.nikola.nikola.models.BusinessNews;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessNewsRepo extends JpaRepository<BusinessNews,Long> {
}
