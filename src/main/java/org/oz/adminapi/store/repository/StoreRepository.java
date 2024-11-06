package org.oz.adminapi.store.repository;

import org.oz.adminapi.store.domain.Store;
import org.oz.adminapi.store.repository.search.StoreSearch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long>, StoreSearch {

    @Query("SELECT s FROM Store s WHERE LOWER(s.storeName) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(s.areaName) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    Page<Store> list(@Param("keyword") String keyword, Pageable pageable);

    @Query("SELECT s FROM Store s WHERE s.storeNo = :storeId")
    Store findByStoreNo(@Param("storeId") Long storeId);
}
