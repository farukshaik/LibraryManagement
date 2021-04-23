import { Component, OnInit } from '@angular/core';
import { SearchbookComponent } from "../searchbook/searchbook.component";
import { Router,ActivatedRoute } from "@angular/router";
import { ToastrService, Toast } from "ngx-toastr";
import { Getstudentbooks } from "../classes/getstudentbooks";
import { HttpClient,HttpClientModule} from "@angular/common/http";
import { ApiserviceService } from "../services/apiservice.service";
import { Renewbook } from "../classes/renewbook";


@Component({
  selector: 'app-librenewbook',
  templateUrl: './librenewbook.component.html',
  styleUrls: ['./librenewbook.component.css']
})
export class LibrenewbookComponent implements OnInit {
data:any
data1:any
getBooks = new Getstudentbooks(0,'','','','','','',0,'')
getRenew = new Renewbook(0)
rollNumber:''
name:''
notEligible = 0
noOfRenewals:number
bookDetails:Getstudentbooks[]
renewals = 0
  constructor(private route: Router,private api:ApiserviceService,private toast: ToastrService,private activatedRouter:ActivatedRoute,private http:HttpClient) { }

 

  ngOnInit() {
   
    this.activatedRouter.queryParams.subscribe((params)=>{

    this.rollNumber = JSON.parse(atob(params.rollNumber))
    })

    this.api.getBookDetails(this.rollNumber).subscribe(

    data=>
    {
     this.bookDetails = data
    });
  //  window.location.reload()
  }

  onRenew(transId)
  {
  
    this.api.onRenewalByLib(transId).subscribe(  

      response=>{
        this.renewals = response
       // console.log(this.renewals)
      }
    );
    
  window.location.reload()
}

onBookSubmit(transId)
{
  this.api.onSubmitByLib(transId).subscribe(

    response=>{
      this.renewals = response
    }
  );
  window.location.reload()
}
}

