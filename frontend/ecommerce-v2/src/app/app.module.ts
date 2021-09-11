import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HeaderComponent } from './components/header/header.component';
import { FlexLayoutModule } from '@angular/flex-layout';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatButtonModule} from '@angular/material/button';
import { Routes, RouterModule } from '@angular/router';
import { AppRoutingModule } from './app-routing.module';
import { HomepageComponent } from './components/homepage/homepage.component';
import {MatIconModule} from "@angular/material/icon";
import { ItemComponent } from './components/buy/item/item.component';
import { BuySubpageComponent } from './components/buy/buy-subpage/buy-subpage.component';
import {MatCardModule} from '@angular/material/card';
import {MatPaginatorModule} from '@angular/material/paginator';
import { HttpClientModule, HttpClient } from '@angular/common/http';
import { SingleItemComponent } from './components/buy/buy-subpage/singleitem/single-item.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    HomepageComponent,
    ItemComponent,
    BuySubpageComponent,
    SingleItemComponent,
  ],
    imports: [
        BrowserModule,
        BrowserAnimationsModule,
        FlexLayoutModule,
        MatToolbarModule,
        MatButtonModule,
        RouterModule,
        AppRoutingModule,
        MatIconModule,
        MatCardModule,
        MatPaginatorModule,
        HttpClientModule,

    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
