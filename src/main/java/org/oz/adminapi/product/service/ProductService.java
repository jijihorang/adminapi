package org.oz.adminapi.product.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.oz.adminapi.common.dto.PageRequestDTO;
import org.oz.adminapi.common.dto.PageResponseDTO;
import org.oz.adminapi.maker.domain.MakerEntity;
import org.oz.adminapi.maker.dto.MakerModifyDTO;
import org.oz.adminapi.product.domain.CategoryEntity;
import org.oz.adminapi.product.domain.ProductEntity;
import org.oz.adminapi.product.dto.ProductListDTO;
import org.oz.adminapi.product.dto.ProductModifyDTO;
import org.oz.adminapi.product.dto.ProductReadDTO;
import org.oz.adminapi.product.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log4j2
public class ProductService {

    private final ProductRepository productRepository;

    public PageResponseDTO<ProductListDTO> getProductList(PageRequestDTO pageRequestDTO) {

        return productRepository.productList(pageRequestDTO);
    }

    public ProductReadDTO getProductWithDetails(Long productNo) {
        List<Object[]> result = productRepository.findWithFilesByProductNo(productNo);

        if (result.isEmpty()) {
            throw new RuntimeException("Product not found");
        }

        // ProductEntity를 조회
        ProductEntity product = (ProductEntity) result.get(0)[0];

        // ProductEntity를 가져옴
//        List<CategoryEntity> categoryEntityList = result.stream().map(arr -> (CategoryEntity) arr[1]).collect(Collectors.toList());

        // 카테고리 이름 목록 생성
        List<String> categories = result.stream()
                .map(row -> (String) row[1])
                .distinct()
                .collect(Collectors.toList());

//        // 파일 이름 목록 생성
         List<String> attachFileNames = product.getAttachFiles().stream()
                .map(file -> file.getFileName())
                .toList();

        // ProductReadDTO 생성
        return ProductReadDTO.builder()
                .productNo(product.getProductNo())
                .productName(product.getProductName())
                .productDescription(product.getProductDescription())
                .productStatus(product.getProductStatus())
                .makerName(product.getMaker().getMakerName())
                .categories(categories)
                .attachFileNames(attachFileNames)
                .createDate(product.getCreateDate())
                .lastModifiedDate(product.getLastModifiedDate())
                .creatorName(product.getCreatorName())
                .build();
    }

//    public ProductReadDTO readProduct(Long productNo) {
//
//        List<Object[]> result = productRepository.findWithFilesByProductNo(productNo);
//
//        if (result.isEmpty()) {
//            throw new RuntimeException("ㄴㄴㄴㄴㄴㄴㄴ");
//        }
//
//        for (Object[] row : result) {
//            log.info("Row");
//            for (int i = 0; i < row.length; i++) {
//                log.info("column {} : {}",i, row);
//            }
//        }
//
//
//
////        ProductReadDTO readDTO = ProductReadDTO.builder()
////                .productNo(productNo)
////                .productName(result.get(0)[1])
////                .build();
//
//
//
////        List<String> attachFileNames = entity.getAttachFiles().stream()
////                .map(file -> file.getFileName())
////                .toList();
////
////        ProductReadDTO productReadDTO = ProductReadDTO.builder()
////                .productNo(productNo)
////                .productName(entity.getProductName())
////                .productDescription(entity.getProductDescription())
////                .productStatus(entity.getProductStatus())
////                .attachFileNames(attachFileNames)
////                .makerName(entity.getMaker().getMakerName())
////                .createDate(entity.getCreateDate())
////                .lastModifiedDate(entity.getLastModifiedDate())
////                .build();
//
////        return productReadDTO;
//        return null;
//    }

    public Long modifyProduct (ProductModifyDTO modifyDTO) {

        Optional<ProductEntity> optionalProductEntity = productRepository.findById(modifyDTO.getProductNo());
        if (optionalProductEntity.isEmpty()) {
            throw new RuntimeException("ㄴㄴㄴㄴㄴㄴㄴ");
        }

        ProductEntity updateProductEntity = optionalProductEntity.get();
        updateProductEntity.changeStatus(modifyDTO.getProductStatus());


        return updateProductEntity.getProductNo();
    }
}
