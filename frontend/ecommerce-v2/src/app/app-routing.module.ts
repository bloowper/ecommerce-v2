import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {Router, RouterModule, Routes} from "@angular/router";
import {AppComponent} from "./app.component";
import {HomepageComponent} from "./components/homepage/homepage.component";
import {BuySubpageComponent} from "./components/buy/buy-subpage/buy-subpage.component";
import {SingleItemComponent} from "./components/buy/buy-subpage/singleitem/single-item.component";


const routes: Routes = [
  {path: '', redirectTo: '/homepage',pathMatch:'full'},
  {path: 'homepage', component: HomepageComponent},
  {path: 'shop', component: BuySubpageComponent},
  {path: 'item', component: SingleItemComponent}
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]

})
export class AppRoutingModule { }
