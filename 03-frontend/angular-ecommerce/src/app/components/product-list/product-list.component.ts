import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/common/product';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list-table.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  products: Product[];

  constructor(private producService: ProductService) { }

  ngOnInit(): void {
    this.listProducts();
  }

  listProducts() {
    this.producService.getProductList().subscribe(
      data => {
        this.products = data;
        console.log(data);
      }
    ); 
  }

  constListOfProducts() {
    this.products = [
      {
        sku: "sku",
        name: "name1",
        description: "string",
        unitPrice: 10,
        imageUrl: "string",
        active: true,
        unitsInStock: 5,
        dateCreated: null,
        lastUpdated: null
      },
      {
        sku: "string",
        name: "name2",
        description: "string",
        unitPrice: 20,
        imageUrl: "string",
        active: true,
        unitsInStock: 5,
        dateCreated: null,
        lastUpdated: null
      }
    ];
  }
}
