package cn.enjoy.service.fallback;

import cn.enjoy.service.IProductClientService;
import cn.enjoy.vo.Product;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author mla
 * @description
 * @prjectName microcloud
 * @className IProductClientServiceFallback
 * @date 2020/3/1  13:02
 */
@Component
public class IProductClientServiceFallback implements FallbackFactory<IProductClientService> {
    @Override
    public IProductClientService create(Throwable throwable) {
        return new IProductClientService() {
            @Override
            public Product getProduct(long id) {
                Product  product = new Product();
                product.setProductDesc("fegin-hystrixDESC");
                product.setProductName("fegin-hystrixXname");
                product.setProductId(99999999L);
                return product;
            }

            @Override
            public List<Product> listProduct() {
                return null;
            }

            @Override
            public boolean addPorduct(Product product) {
                return  true;
            }
        };
    }
}
