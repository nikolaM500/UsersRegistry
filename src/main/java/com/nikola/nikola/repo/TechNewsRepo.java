package com.nikola.nikola.repo;
import com.nikola.nikola.models.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechNewsRepo extends JpaRepository<News,Long>  {
}
