import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LibrarysigninComponent } from './librarysignin.component';

describe('LibrarysigninComponent', () => {
  let component: LibrarysigninComponent;
  let fixture: ComponentFixture<LibrarysigninComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LibrarysigninComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LibrarysigninComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
