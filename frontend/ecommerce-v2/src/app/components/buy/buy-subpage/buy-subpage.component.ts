import {Component, OnDestroy, OnInit} from '@angular/core';
import {ItemEntity} from "../../../entities/ItemEntity";
import {ItemPageable} from "../../../entities/ItemPageableEntity";
import {ItemStorageService} from "../../../services/item/item-storage.service";
import {Subscription} from "rxjs";
import {PageEvent} from '@angular/material/paginator';

@Component({
    selector: 'app-buy-subpage',
    templateUrl: './buy-subpage.component.html',
    styleUrls: ['./buy-subpage.component.css']
})
export class BuySubpageComponent implements OnInit, OnDestroy {


    itemPageable: ItemPageable | undefined;
    pageEvent: PageEvent|undefined;


    constructor(private itemStorageService: ItemStorageService) {
        //REACTIVE
        itemStorageService.items$.subscribe(value => {
            if (value !== undefined) {
                this.itemPageable = value;
            }else {
                this.itemStorageService.fetchItems(0, null, null, null);
            }
        })
    }

    ngOnInit(): void {

    }

    ngOnDestroy(): void {

    }

}
