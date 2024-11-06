package org.oz.adminapi.localmaneger.repository;

import org.oz.adminapi.localmaneger.domain.LocalManager;
import org.oz.adminapi.localmaneger.dto.LocalManagerDTO;
import org.oz.adminapi.localmaneger.repository.search.LocalManagerSearch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface LocalManagerRepository extends JpaRepository<LocalManager, String>, LocalManagerSearch {
//    @Query("select " +
//            "new org.oz.adminapi.localmaneger.dto.LocalManagerDTO(LM.managerNo,LM.managerName,LM.areaName,LM.managerContact) " +
//            "from LocalManager  LM where LM.managerNo = :managerNo")
//    Optional<LocalManagerDTO> read(@Param("managerNo") Long managerNo);
}
