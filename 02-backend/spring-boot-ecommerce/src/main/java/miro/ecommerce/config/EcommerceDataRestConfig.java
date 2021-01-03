package miro.ecommerce.config;

import miro.ecommerce.entity.Product;
import miro.ecommerce.entity.ProductCategory;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;

@Configuration
public class EcommerceDataRestConfig implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {

        HttpMethod[] unsupportedVerbs = {HttpMethod.POST, HttpMethod.PUT, HttpMethod.DELETE};

        //disable listed methods
        config.getExposureConfiguration()
                .forDomainType(Product.class)
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(unsupportedVerbs))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(unsupportedVerbs));

        config.getExposureConfiguration()
                .forDomainType(ProductCategory.class)
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(unsupportedVerbs))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(unsupportedVerbs));
    }
}
