import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LibrenewbookComponent } from './librenewbook.component';

describe('LibrenewbookComponent', () => {
  let component: LibrenewbookComponent;
  let fixture: ComponentFixture<LibrenewbookComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LibrenewbookComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LibrenewbookComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
