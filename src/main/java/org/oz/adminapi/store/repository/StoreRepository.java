package org.oz.adminapi.store.repository;

import org.oz.adminapi.store.domain.Store;
import org.oz.adminapi.store.repository.search.StoreSearch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long>, StoreSearch {
}
