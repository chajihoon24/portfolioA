package com.mysite.ProjectA.photos;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotosRepository extends JpaRepository<PhotosDAO, Long> {

}
