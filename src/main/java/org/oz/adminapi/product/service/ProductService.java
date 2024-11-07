package org.oz.adminapi.product.service;

import lombok.RequiredArgsConstructor;
import org.oz.adminapi.common.dto.PageRequestDTO;
import org.oz.adminapi.common.dto.PageResponseDTO;
import org.oz.adminapi.product.dto.ProductListDTO;
import org.oz.adminapi.product.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

public PageResponseDTO<ProductListDTO> getProductList(PageRequestDTO pageRequestDTO) {

        return productRepository.productList(pageRequestDTO);
    }
}
