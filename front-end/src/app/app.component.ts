import { Component } from '@angular/core';

import { ApiserviceService } from "./services/apiservice.service";
import { DataClass } from "./classes/data-class";
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
    constructor(private _apiservice: ApiserviceService){
    
    }

continue = false    
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
