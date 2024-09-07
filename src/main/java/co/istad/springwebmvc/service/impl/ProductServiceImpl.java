package co.istad.springwebmvc.service.impl;import co.istad.springwebmvc.dto.ProductDto;import co.istad.springwebmvc.model.Product;import co.istad.springwebmvc.service.ProductService;import org.springframework.stereotype.Service;import java.time.LocalDateTime;import java.util.ArrayList;import java.util.List;import java.util.UUID;@Servicepublic class ProductServiceImpl implements ProductService {    private final List<Product> products;    public ProductServiceImpl() {        products = new ArrayList<>();        Product p1 = new Product();        p1.setId(1);        p1.setUuid(UUID.randomUUID().toString());        p1.setName("Macbook Pro M1");        p1.setPrice(1333.1);        p1.setQty(1);        p1.setImportedDate(LocalDateTime.now());        p1.setStatus(true);        Product p2 = new Product();        p2.setId(2);        p2.setUuid(UUID.randomUUID().toString());        p2.setName("Iphone 15 Pro Max");        p2.setPrice(2000.1);        p2.setQty(1);        p2.setImportedDate(LocalDateTime.now());        p2.setStatus(true);        Product p3 = new Product();        p3.setId(2);        p3.setUuid(UUID.randomUUID().toString());        p3.setName("Iphone 14 Pro Max");        p3.setPrice(2000.1);        p3.setQty(1);        p3.setImportedDate(LocalDateTime.now());        p3.setStatus(false);        Product p4 = new Product();        p4.setId(2);        p4.setUuid(UUID.randomUUID().toString());        p4.setName("Iphone 15 Pro Max");        p4.setPrice(2000.1);        p4.setQty(1);        p4.setImportedDate(LocalDateTime.now());        p4.setStatus(true);        products.add(p1);        products.add(p2);        products.add(p3);        products.add(p4);    }    @Override    public List<ProductDto> findProducts(String name, Boolean status) {        return products.stream()                .filter(product -> product.getName().toLowerCase()                        .contains(name.toLowerCase()) && product.getStatus().equals(true))                .map(product -> new ProductDto(                        product.getUuid(),                        product.getName(),                        product.getPrice(),                        product.getQty()                )).toList();    }    @Override    public ProductDto findProductById(Integer id) {        return products.stream()                .filter(product -> product.getId().equals(id) &&                        product.getStatus().equals(true))                .map(product -> new ProductDto(                        product.getUuid(),                        product.getName(),                        product.getPrice(),                        product.getQty()                ))                .findFirst()                .orElseThrow();    }    @Override    public ProductDto findProductByUuid(String uuid) {        return products.stream()                .filter(product -> product.getUuid().equals(uuid) &&                        product.getStatus().equals(true))                .map(product -> new ProductDto(                        product.getUuid(),                        product.getName(),                        product.getPrice(),                        product.getQty()                ))                .findFirst()                .orElseThrow();    }}