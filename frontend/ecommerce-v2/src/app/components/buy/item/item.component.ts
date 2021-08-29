import {Component, Input, OnInit} from '@angular/core';
import {ItemEntity} from "../../../entities/ItemEntity";

@Component({
  selector: 'app-item',
  templateUrl: './item.component.html',
  styleUrls: ['./item.component.css']
})
export class ItemComponent implements OnInit {

  @Input() item: ItemEntity|undefined;

  constructor() { }

  ngOnInit(): void {
  }

}
