package com.apishehelps.shehelps.repositories;

import com.apishehelps.shehelps.models.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, Integer> {
    Status findByName(String name);
}
