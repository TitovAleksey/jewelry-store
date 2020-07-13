package ru.breadwinner.service.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductDAO productDAO;
}
