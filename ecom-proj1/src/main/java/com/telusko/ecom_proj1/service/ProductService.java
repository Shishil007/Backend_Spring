package com.telusko.ecom_proj1.service;

import com.telusko.ecom_proj1.model.Product;
import com.telusko.ecom_proj1.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
@Service
public class ProductService {
@Autowired
ProductRepo repo;
    public List<Product> getAllProducts(){
        System.out.println(repo.findAll());
        return repo.findAll();
    }
    public Product getProductById(int id){
        return repo.findById(id).orElse(null);
    }
    public Product addProduct(Product product, MultipartFile imageFile) throws IOException {
        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());
        product.setImageDate(imageFile.getBytes());
        return repo.save(product);

    }
    public Product updateProductById(int id,Product product,MultipartFile imageFile) throws IOException {
    product.setImageName(imageFile.getOriginalFilename());
    product.setImageType(imageFile.getContentType());
    product.setImageDate(imageFile.getBytes());
    return repo.save(product);
    }
    public void deleteProductById(int id){
        repo.deleteById(id);
    }
    public List<Product> searchProducts(String keyword){
        return repo.searchProducts(keyword);
    }


}
