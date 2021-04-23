import { Component, OnInit } from '@angular/core';
import { ApiserviceService } from "../services/apiservice.service";
import { DataClass } from "../classes/data-class";
@Component({
  selector: 'app-searchbook',
  templateUrl: './searchbook.component.html',
  styleUrls: ['./searchbook.component.css']
})

export class SearchbookComponent {
    constructor(private _apiservice: ApiserviceService){
    
    }

 continue:boolean;
 checkData:boolean;
bookDetails:DataClass[]
bookName:''
    onSubmit(){
      this.continue = true
      this._apiservice.getData(this.bookName)
      .subscribe(
        data=>
        {
          this.bookDetails = data
        }
        
      );
      
    }

   

}
