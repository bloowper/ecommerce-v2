import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {ItemPageable} from "../../entities/ItemPageableEntity";
import {BehaviorSubject, Subject} from "rxjs";

@Injectable({
    providedIn: 'root'
})
export class ItemStorageService {

    public items$ = new BehaviorSubject<ItemPageable|undefined>(undefined);

    constructor(private httpClient: HttpClient) {

    }

    public fetchItems(page: number,
                      pageSize: number | null,
                      sortBy: string | null,
                      sortDirection: string | null
    ) {
        var params = new HttpParams();
        params = params.set("page", page);
        if (pageSize) {
            params = params.set("pageSize", pageSize);
        }
        if (sortBy) {
            params = params.set("sortBy", sortBy)
        }
        if (sortDirection) {
            params = params.set("sortDirection", sortDirection);
        }
        //TODO externalize API
        this.httpClient.get<ItemPageable>("http://localhost:8080/ecommerce/api/items", {
            params: params
        }).subscribe(
            value => {
                console.log(value)
                this.items$.next(value);
            },
            error => {
                console.log(error);
                this.items$.next(error);
            });
    }
}





