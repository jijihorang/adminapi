package org.oz.adminapi.store.repository.search;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPQLQuery;
import org.oz.adminapi.common.dto.PageRequestDTO;
import org.oz.adminapi.common.dto.PageResponseDTO;
import org.oz.adminapi.localmaneger.domain.QLocalManager;
import org.oz.adminapi.store.domain.QStore;
import org.oz.adminapi.store.domain.Store;
import org.oz.adminapi.store.dto.StoreDTO;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class StoreSearchImpl extends QuerydslRepositorySupport implements StoreSearch {

    public StoreSearchImpl() {
        super(Store.class);
    }

    @Override
    public PageResponseDTO<StoreDTO> list(PageRequestDTO pageRequestDTO) {

        Pageable pageable = PageRequest.of(
                pageRequestDTO.getPage() - 1,
                pageRequestDTO.getSize(),
                Sort.by("storeNo").descending());

        QStore store = QStore.store;
        QLocalManager localManager = QLocalManager.localManager;

        JPQLQuery<Store> query = from(store).leftJoin(localManager).on(store.localManager.eq(localManager));

        this.getQuerydsl().applyPagination(pageable, query);

        JPQLQuery<StoreDTO> dtoQuery = query.select(
                Projections.bean(StoreDTO.class,
                        store.storeNo,
                        store.storeName,
                        store.storeContact,
                        store.areaName,
                        store.storeLatitude,
                        store.storeLongitude,
                        store.isRentAvailable,
                        localManager.as("localManager")
                )
        );

        java.util.List<StoreDTO> dtoList = dtoQuery.fetch();
        long total = dtoQuery.fetchCount();

        return PageResponseDTO.<StoreDTO>withAll()
                .dtoList(dtoList)
                .pageRequestDTO(pageRequestDTO)
                .totalCount(total)
                .build();
    }
}
