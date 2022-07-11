package com.nikola.nikola.repo;

import com.nikola.nikola.models.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessNewsRepo extends JpaRepository<News,Long> {
}
