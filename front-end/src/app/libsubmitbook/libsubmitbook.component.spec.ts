import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LibsubmitbookComponent } from './libsubmitbook.component';

describe('LibsubmitbookComponent', () => {
  let component: LibsubmitbookComponent;
  let fixture: ComponentFixture<LibsubmitbookComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LibsubmitbookComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LibsubmitbookComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
