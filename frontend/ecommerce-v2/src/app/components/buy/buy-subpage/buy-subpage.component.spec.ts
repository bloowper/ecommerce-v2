import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BuySubpageComponent } from './buy-subpage.component';

describe('BuySubpageComponent', () => {
  let component: BuySubpageComponent;
  let fixture: ComponentFixture<BuySubpageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BuySubpageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BuySubpageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
