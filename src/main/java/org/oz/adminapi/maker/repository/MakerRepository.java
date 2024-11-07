package org.oz.adminapi.maker.repository;

import org.oz.adminapi.maker.domain.MakerEntity;
import org.oz.adminapi.maker.repository.search.MakerSearch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MakerRepository extends JpaRepository<MakerEntity, String>, MakerSearch {
}
