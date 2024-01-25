import { Component } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent {
  allWords: string = '';
  exactPhrase: string = '';
  anyWords: string = '';
  noneWords: string = '';
  dateRangeStart: string = '';
  dateRangeEnd: string = '';

  clearFilters() {
    this.allWords = '';
    this.exactPhrase = '';
    this.anyWords = '';
    this.noneWords = '';
    this.dateRangeStart = '';
    this.dateRangeEnd = '';
  }
}
