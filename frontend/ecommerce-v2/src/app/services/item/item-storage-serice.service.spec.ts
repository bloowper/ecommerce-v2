import { TestBed } from '@angular/core/testing';

import { ItemStorageService } from './item-storage.service';

describe('ItemStorageSericeService', () => {
  let service: ItemStorageService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ItemStorageService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
