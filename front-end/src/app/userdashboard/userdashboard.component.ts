import { Component, OnInit } from '@angular/core';
import { SearchbookComponent } from "../searchbook/searchbook.component";
import { Router,ActivatedRoute } from "@angular/router";
import { ToastrService, Toast } from "ngx-toastr";
import { Getstudentbooks } from "../classes/getstudentbooks";
import { HttpClient,HttpClientModule} from "@angular/common/http";
import { ApiserviceService } from "../services/apiservice.service";
import { Renewbook } from "../classes/renewbook";
@Component({
  selector: 'app-userdashboard',
  templateUrl: './userdashboard.component.html',
  styleUrls: ['./userdashboard.component.css']
})
export class UserdashboardComponent implements OnInit {

data:any
data1:any
getBooks = new Getstudentbooks(0,'','','','','','',0,'')
getRenew = new Renewbook(0)
rollNumber:''
name:''
status:''
notEligible = 0
noOfRenewals:number
bookDetails:Getstudentbooks[]
renewals = 0
isSubmitted: boolean
  constructor(private route: Router,private api:ApiserviceService,private toast: ToastrService,private activatedRouter:ActivatedRoute,private http:HttpClient) { }

  onLogOut()
  {
    this.toast.success("Log Out Success...!","Message")
    this.route.navigate(['/search'])
  }


  ngOnInit() {
   
    this.activatedRouter.queryParams.subscribe((params)=>{

    this.data = JSON.parse(atob(params.data))
    })
    //console.log(this.data)
    this.getBooks.rollNumber = this.data.rollNo
    

    this.api.getBookDetails(this.getBooks.rollNumber).subscribe(

  response=>
    {
     this.bookDetails = response
     
     }
    )
  }


  onRenew(transId)
  {
  
    this.api.onRenewal(transId).subscribe(  

      response=>{
        this.renewals = response
        console.log(response)
        if(this.renewals === 3)
    {
      alert("Limit reached for online renewals. Please visit library")
       //this.toast.warning("Limit reached for online renewals","Visit Library")
    }
    else{
      alert("Book renewal success..!")
    }
  window.location.reload()
      }
    );

    
}

}