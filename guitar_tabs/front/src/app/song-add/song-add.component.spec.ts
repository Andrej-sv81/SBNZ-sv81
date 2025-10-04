import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SongAddComponent } from './song-add.component';

describe('SongAddComponent', () => {
  let component: SongAddComponent;
  let fixture: ComponentFixture<SongAddComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SongAddComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(SongAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
