package com.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.ssm.dao.ProductDao;
import com.ssm.domain.Product;
import com.ssm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;
    /**
     * 查询所有
     * @return
     */
    @Override
    public List<Product> findAll(int page,int size) {

        PageHelper.startPage(page, size);
        List<Product> list = productDao.findAll();
        return list;
    }

    /**
     * 添加商品
     * @param product
     */
    @Override
    public void saveProduct(Product product) {
        productDao.saveProduct(product);
    }

    /***
     * 根据Id删除product
     * @param ids
     */
    @Override

    public void delProductById(String ids) {

        String[] id = ids.split(",");
        for (int i = 0; i < id.length; i++) {
            System.out.println("正在删除..."+id[i]);
            productDao.delProductById(id[i]);
        }
    }

    /***
     * 根据Id查询product，进行页面的回显功能
     * @param id
     * @return
     */
    @Override
    public Product findProductById(String id) {
        return productDao.findProductById(id);
    }

    /**
     * 根据id对product进行更新
     * @param product
     */
    @Override
    public void updateProductById(Product product) {
        productDao.updateProductById(product);
    }
}
