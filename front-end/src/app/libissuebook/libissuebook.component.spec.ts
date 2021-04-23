import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LibissuebookComponent } from './libissuebook.component';

describe('LibissuebookComponent', () => {
  let component: LibissuebookComponent;
  let fixture: ComponentFixture<LibissuebookComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LibissuebookComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LibissuebookComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
